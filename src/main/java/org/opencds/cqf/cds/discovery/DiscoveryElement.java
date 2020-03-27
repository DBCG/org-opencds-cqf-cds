package org.opencds.cqf.cds.discovery;

import com.google.gson.JsonObject;
import org.hl7.fhir.dstu3.model.PlanDefinition;

public class DiscoveryElement {
    private PlanDefinition planDefinition;
    private PrefetchUrlList prefetchUrlList;

    public DiscoveryElement(PlanDefinition planDefinition, PrefetchUrlList prefetchUrlList) {
        this.planDefinition = planDefinition;
        this.prefetchUrlList = prefetchUrlList;
    }

    public JsonObject getAsJson() {
        JsonObject service = new JsonObject();
        if (planDefinition != null) {
            if (planDefinition.hasAction()) {
                // TODO - this needs some work - too naive
                if (planDefinition.getActionFirstRep().hasTriggerDefinition()) {
                    if (planDefinition.getActionFirstRep().getTriggerDefinitionFirstRep().hasEventName()) {
                        service.addProperty("hook", planDefinition.getActionFirstRep().getTriggerDefinitionFirstRep().getEventName());
                    }
                }
            }
            if (planDefinition.hasName()) {
                service.addProperty("name", planDefinition.getName());
            }
            if (planDefinition.hasTitle()) {
                service.addProperty("title", planDefinition.getTitle());
            }
            if (planDefinition.hasDescription()) {
                service.addProperty("description", planDefinition.getDescription());
            }
            service.addProperty("id", planDefinition.getIdElement().getIdPart());

            if (prefetchUrlList != null && !prefetchUrlList.isEmpty()) {
                JsonObject prefetchContent = new JsonObject();
                prefetchContent.addProperty("item1", "Patient?_id={{context.patientId}}");
                int itemNo = 1;
                for (String item : prefetchUrlList) {
                    prefetchContent.addProperty("item" + Integer.toString(++itemNo), item);
                }
                service.add("prefetch", prefetchContent);
            }

            return service;
        }

        return null;
    }
}
