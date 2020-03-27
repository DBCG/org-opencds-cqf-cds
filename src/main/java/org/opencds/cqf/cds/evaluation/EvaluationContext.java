package org.opencds.cqf.cds.evaluation;

import java.io.IOException;
import java.util.List;

import org.opencds.cqf.cds.hooks.Hook;
import org.opencds.cqf.cds.exceptions.NotImplementedException;

import org.cqframework.cql.elm.execution.Library;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.opencds.cqf.cql.data.CompositeDataProvider;
import org.opencds.cqf.cql.data.DataProvider;
import org.opencds.cqf.cql.execution.Context;
import org.opencds.cqf.cql.model.Dstu2FhirModelResolver;
import org.opencds.cqf.cql.model.Dstu3FhirModelResolver;
import org.opencds.cqf.cql.model.ModelResolver;
import org.opencds.cqf.cql.model.R4FhirModelResolver;
import org.opencds.cqf.cql.retrieve.RestFhirRetrieveProvider;
import org.opencds.cqf.cql.searchparam.SearchParameterResolver;
import org.opencds.cqf.cql.terminology.TerminologyProvider;
import org.opencds.cqf.cql.terminology.fhir.Dstu3FhirTerminologyProvider;
import org.opencds.cqf.cql.terminology.fhir.R4FhirTerminologyProvider;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.jpa.searchparam.registry.ISearchParamRegistry;
import ca.uhn.fhir.jpa.searchparam.registry.SearchParamRegistryDstu2;
import ca.uhn.fhir.jpa.searchparam.registry.SearchParamRegistryDstu3;
import ca.uhn.fhir.jpa.searchparam.registry.SearchParamRegistryR4;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.interceptor.BearerTokenAuthInterceptor;

public abstract class EvaluationContext<T extends IBaseResource> {

    // Provided
    private Hook hook;
    private FhirVersionEnum fhirVersion;
    private FhirContext fhirContext;
    private DataProvider systemProvider;
    private Context context;
    private T planDefinition;
    private Library library;

    // Requires resolution
    private DataProvider remoteProvider;
    private List<Object> contextResources;
    private List<Object> prefetchResources;

    private IGenericClient client;


    public EvaluationContext(Hook hook, FhirVersionEnum fhirVersion, IGenericClient fhirClient,
                             Context context, Library library, T planDefinition)
    {

        // How to determine if it's a local server?
        // Local Server url?
        // Need a DataRetriever for that.
        // Otherwise, it's a remote data retriver.

        this.hook = hook;
        this.fhirVersion = fhirVersion;
        this.fhirContext = new FhirContext(fhirVersion);
        this.context = context;
        this.planDefinition = planDefinition;
        this.library = library;

        this.client = fhirClient;

        context.registerDataProvider("http://hl7.org/fhir", getDataProvider());
    }

    public Hook getHook() {
        return hook;
    }

    public FhirVersionEnum getFhirVersion() {
        return fhirVersion;
    }

    public FhirContext getFhirContext() {
        return fhirContext;
    }

    public DataProvider getSystemProvider() {
        return systemProvider;
    }

    public T getPlanDefinition() {
        if (planDefinition == null) {
            throw new RuntimeException("Provided PlanDefinition cannot be null");
        }
        return planDefinition;
    }

    public Library getLibrary() {
        if (library == null) {
            throw new RuntimeException("Provided Library cannot be null");
        }
        return library;
    }

    private DataProvider getDataProvider() {
        if (remoteProvider == null) {
            ModelResolver resolver;

            // TODO: Need to factor out all the SearchParamRegistry stuff.
            TerminologyProvider terminologyProvider;
            switch (fhirVersion) {
                case DSTU2:
                    resolver = new Dstu2FhirModelResolver();
                    terminologyProvider = new Dstu3FhirTerminologyProvider(this.getSystemFhirClient());
                    break;
                case DSTU3:
                    resolver = new Dstu3FhirModelResolver();
                    terminologyProvider = new Dstu3FhirTerminologyProvider(this.getSystemFhirClient());
                    break;
                case R4:
                    resolver = new R4FhirModelResolver();
                    terminologyProvider = new R4FhirTerminologyProvider(this.getSystemFhirClient());
                    break;
                default:
                    throw new NotImplementedException("This CDS Hooks implementation is not configured for FHIR version: " + fhirVersion.getFhirVersionString());
            }

            RestFhirRetrieveProvider provider = new RestFhirRetrieveProvider(new SearchParameterResolver(this.fhirContext), this.getHookFhirClient());
            provider.setTerminologyProvider(terminologyProvider);

            this.remoteProvider = new CompositeDataProvider(resolver, provider);
        }
        return remoteProvider;
    }

    public Context getContext() {
        if (context == null) {
            throw new RuntimeException("The cql execution context must be provided");
        }
        return context;
    }

    public List<Object> getContextResources() {
        if (contextResources == null) {
            contextResources = EvaluationHelper.resolveContextResources(hook.getContextResources(), fhirContext);
            if (hook.getRequest().isApplyCql()) {
                contextResources = applyCqlToResources(contextResources);
            }
        }
        return contextResources;
    }

    public List<Object> getPrefetchResources() throws IOException {
        if (prefetchResources == null) {
            prefetchResources =
                    EvaluationHelper.resolvePrefetchResources(
                            hook,
                            fhirContext,
                            this.getHookFhirClient()
                    );
            if (hook.getRequest().isApplyCql()) {
                prefetchResources = applyCqlToResources(prefetchResources);
            }
        }
        return prefetchResources;
    }

    public IGenericClient getSystemFhirClient() {
        return this.client;
    }

    public IGenericClient getHookFhirClient() {
        IGenericClient client = this.fhirContext.newRestfulGenericClient(this.hook.getRequest().getFhirServerUrl());
        if (this.hook.getRequest().getFhirAuthorization() != null
                    && hook.getRequest().getFhirAuthorization().getTokenType().equals("Bearer")) {
            BearerTokenAuthInterceptor authInterceptor = new BearerTokenAuthInterceptor(hook.getRequest().getFhirAuthorization().getAccessToken());
            client.registerInterceptor(authInterceptor);

            // TODO: account for the expires_in, scope and subject properties within workflow
        }

        return client;
    }

    // NOTE: This is an operation defined in the cqf-ruler
    abstract List<Object> applyCqlToResources(List<Object> resources);
}
