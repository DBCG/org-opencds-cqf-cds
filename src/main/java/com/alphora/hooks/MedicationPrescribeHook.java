package com.alphora.hooks;

import com.alphora.exceptions.MissingRequiredFieldException;
import com.alphora.request.Request;
import com.google.gson.JsonElement;

public class MedicationPrescribeHook extends Hook {

    public MedicationPrescribeHook(Request request) {
        super(request);
    }

    @Override
    public JsonElement getContextResources() {
        JsonElement medicationsElement = getRequest().getContext().getResourceElement("medications");

        if (medicationsElement == null) {
            throw new MissingRequiredFieldException("medications is required but not found.");
        }

        return medicationsElement;
    }
}
