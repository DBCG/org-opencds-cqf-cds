package com.alphora.hooks;

import com.alphora.request.Request;
import com.google.gson.JsonElement;

public class MedicationPrescribeHook extends Hook {

    public MedicationPrescribeHook(Request request) {
        super(request);
    }

    @Override
    public JsonElement getContextResources() {
        return getRequest().getContext().getResourceElement("medications");
    }
}
