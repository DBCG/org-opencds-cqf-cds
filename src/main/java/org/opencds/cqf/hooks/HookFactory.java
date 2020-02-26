package org.opencds.cqf.hooks;

import org.opencds.cqf.request.Request;
import org.opencds.cqf.exceptions.InvalidHookException;

public class HookFactory {

    public static Hook createHook(Request request) {
        switch (request.getHook()) {
            case "patient-view": return new PatientViewHook(request);
            case "medication-prescribe": return new MedicationPrescribeHook(request);
            case "order-review": return new OrderReviewHook(request);
            case "order-select": return new OrderSelectHook(request);
            default: throw new InvalidHookException("Unknown Hook: " + request.getHook());
        }
    }
}
