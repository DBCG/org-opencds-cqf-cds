package com.alphora.hooks;

import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.rest.client.api.IGenericClient;

import com.alphora.evaluation.EvaluationContext;
import com.alphora.providers.PrefetchDataProviderDstu2;
import com.alphora.providers.PrefetchDataProviderR4;
import com.alphora.providers.PrefetchDataProviderStu3;
import com.alphora.response.CdsCard;
import org.cqframework.cql.elm.execution.ListTypeSpecifier;
import org.cqframework.cql.elm.execution.ParameterDef;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.opencds.cqf.cql.data.CompositeDataProvider;
import org.opencds.cqf.cql.execution.Context;
import org.opencds.cqf.cql.model.Dstu2FhirModelResolver;
import org.opencds.cqf.cql.model.Dstu3FhirModelResolver;
import org.opencds.cqf.cql.model.ModelResolver;
import org.opencds.cqf.cql.model.R4FhirModelResolver;
import org.opencds.cqf.cql.retrieve.TerminologyAwareRetrieveProvider;

import java.io.IOException;
import java.util.List;

public abstract class BaseHookEvaluator<P extends IBaseResource> {

    public List<CdsCard> evaluate(EvaluationContext<P> context) throws IOException {

        // resolve context resources parameter
        // TODO - this will need some work for libraries with multiple parameters
        if (context.getLibrary().getParameters() != null && !(context.getHook() instanceof PatientViewHook)) {
            for (ParameterDef params : context.getLibrary().getParameters().getDef()) {
                if (params.getParameterTypeSpecifier() instanceof ListTypeSpecifier) {
                    context.getContext().setParameter(null, params.getName(), context.getContextResources());
                }
            }
        }

        // resolve PrefetchDataProvider
        TerminologyAwareRetrieveProvider prefetchDataProvider;
        ModelResolver resolver;
        if (context.getFhirVersion() == FhirVersionEnum.DSTU3) {
            prefetchDataProvider = new PrefetchDataProviderStu3(context.getPrefetchResources());
            resolver = new Dstu3FhirModelResolver();
        }
        else if (context.getFhirVersion() == FhirVersionEnum.DSTU2) {
            prefetchDataProvider = new PrefetchDataProviderDstu2(context.getPrefetchResources());
            resolver = new Dstu2FhirModelResolver();
        }
        else {
            prefetchDataProvider = new PrefetchDataProviderR4(context.getPrefetchResources());
            resolver = new R4FhirModelResolver();
        }

        // TODO: Get the "system" terminology provider.
        prefetchDataProvider.setTerminologyProvider(context.getContext().resolveTerminologyProvider());
        context.getContext().registerDataProvider("http://hl7.org/fhir", new CompositeDataProvider(resolver, prefetchDataProvider));
        context.getContext().registerTerminologyProvider(prefetchDataProvider.getTerminologyProvider());

        return evaluateCdsHooksPlanDefinition(
                context.getContext(),
                context.getPlanDefinition(),
                context.getHook().getRequest().getContext().getPatientId(),
                context.getSystemFhirClient()
        );
    }

    public abstract List<CdsCard> evaluateCdsHooksPlanDefinition(Context context, P planDefinition, String patientId, IGenericClient applyClient);
}
