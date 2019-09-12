package com.alphora.hooks;

import com.alphora.request.Request;
import com.google.gson.JsonElement;

public class OrderSelectHook extends Hook {

    public OrderSelectHook(Request request) {
        super(request);
    }

    @Override
    public JsonElement getContextResources() {
        return getRequest().getContext().getResourceElement("draftOrders");
    }
}
