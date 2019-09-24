package com.alphora.hooks;

import com.alphora.exceptions.MissingRequiredFieldException;
import com.alphora.request.JsonHelper;
import com.alphora.request.Request;
import com.google.gson.JsonElement;

public class MedicationPrescribeHook extends Hook {

    public MedicationPrescribeHook(Request request) {
        super(request);
    }

    @Override
    public JsonElement getContextResources() {
        return JsonHelper.getObjectRequired(getRequest().getRequestJson(), "medications");
    }
}
