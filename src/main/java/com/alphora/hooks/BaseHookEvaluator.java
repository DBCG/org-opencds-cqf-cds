package com.alphora.hooks;

import ca.uhn.fhir.context.FhirVersionEnum;
import com.alphora.evaluation.EvaluationContext;
import com.alphora.providers.PrefetchDataProviderDstu2;
import com.alphora.providers.PrefetchDataProviderR4;
import com.alphora.providers.PrefetchDataProviderStu3;
import com.alphora.response.CdsCard;
import org.cqframework.cql.elm.execution.ListTypeSpecifier;
import org.cqframework.cql.elm.execution.ParameterDef;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.opencds.cqf.cql.data.fhir.BaseFhirDataProvider;
import org.opencds.cqf.cql.execution.Context;

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
        BaseFhirDataProvider prefetchDataProvider;
        if (context.getFhirVersion() == FhirVersionEnum.DSTU3) {
            prefetchDataProvider = new PrefetchDataProviderStu3(context.getPrefetchResources());
        }
        else if (context.getFhirVersion() == FhirVersionEnum.DSTU2) {
            prefetchDataProvider = new PrefetchDataProviderDstu2(context.getPrefetchResources());
        }
        else {
            prefetchDataProvider = new PrefetchDataProviderR4(context.getPrefetchResources());
        }
        prefetchDataProvider.setTerminologyProvider(context.getSystemProvider().getTerminologyProvider());
        context.getContext().registerDataProvider("http://hl7.org/fhir", prefetchDataProvider);
        context.getContext().registerTerminologyProvider(prefetchDataProvider.getTerminologyProvider());

        return evaluateCdsHooksPlanDefinition(
                context.getContext(),
                context.getPlanDefinition(),
                context.getHook().getRequest().getContext().getPatientId()
        );
    }

    public abstract List<CdsCard> evaluateCdsHooksPlanDefinition(Context context, P planDefinition, String patientId);
}
