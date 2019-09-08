package com.alphora.evaluation;

import ca.uhn.fhir.context.FhirVersionEnum;
import com.alphora.hooks.Hook;
import org.hl7.fhir.r4.model.PlanDefinition;
import org.opencds.cqf.cql.data.fhir.BaseFhirDataProvider;
import org.opencds.cqf.cql.execution.Context;
import org.opencds.cqf.cql.terminology.TerminologyProvider;

import java.util.List;

public class R4EvaluationContext extends EvaluationContext<PlanDefinition> {

    public R4EvaluationContext(Hook hook, FhirVersionEnum fhirVersion, BaseFhirDataProvider systemProvider,
                               TerminologyProvider terminologyProvider, Context context, PlanDefinition planDefinition)
    {
        super(hook, fhirVersion, systemProvider, context, planDefinition);
    }

    @Override
    void applyCqlToResources(List<Object> resources) {
        // TODO
    }
}
