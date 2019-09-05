package com.alphora.hooks;

import com.alphora.request.Request;
import com.google.gson.JsonElement;

public class PatientViewHook extends Hook {

    public PatientViewHook(Request request) {
        super(request);
    }

    @Override
    public JsonElement getContextResources() {
        return null;
    }
}
