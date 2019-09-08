package com.alphora.evaluation;

import ca.uhn.fhir.context.FhirVersionEnum;
import com.alphora.hooks.Hook;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Parameters;
import org.hl7.fhir.dstu3.model.PlanDefinition;
import org.hl7.fhir.dstu3.model.Resource;
import org.opencds.cqf.cql.data.fhir.BaseFhirDataProvider;
import org.opencds.cqf.cql.execution.Context;
import org.opencds.cqf.cql.terminology.TerminologyProvider;

import java.util.List;
import java.util.stream.Collectors;

public class Stu3EvaluationContext extends EvaluationContext<PlanDefinition> {

    public Stu3EvaluationContext(Hook hook, FhirVersionEnum fhirVersion, BaseFhirDataProvider systemProvider,
                                 TerminologyProvider terminologyProvider, Context context, PlanDefinition planDefinition)
    {
        super(hook, fhirVersion, systemProvider, context, planDefinition);
    }

    @Override
    void applyCqlToResources(List<Object> resources) {
        Bundle bundle = new Bundle();
        for (Object res : resources) {
            bundle.addEntry(new Bundle.BundleEntryComponent().setResource((Resource) res));
        }
        Parameters parameters = new Parameters();
        parameters.addParameter().setResource(bundle);

        Parameters ret = this.getSystemProvider().getFhirClient().operation().onType(Bundle.class).named("$apply-cql").withParameters(parameters).execute();
        Bundle appliedResources = (Bundle) ret.getParameter().get(0).getResource();
        resources = appliedResources.getEntry().stream().map(Bundle.BundleEntryComponent::getResource).collect(Collectors.toList());
    }
}
