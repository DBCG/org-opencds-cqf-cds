package org.opencds.cqf.cds.hooks;

import org.opencds.cqf.cds.request.JsonHelper;
import org.opencds.cqf.cds.request.Request;
import com.google.gson.JsonElement;

public class MedicationPrescribeHook extends Hook {

    public MedicationPrescribeHook(Request request) {
        super(request);
    }

    @Override
    public JsonElement getContextResources() {
        return JsonHelper.getObjectRequired(getRequest().getContext().getContextJson(), "medications");
    }
}
