package com.alphora.hooks;

import com.alphora.request.Request;
import com.google.gson.JsonElement;

public class OrderReviewHook extends Hook {

    public OrderReviewHook(Request request) {
        super(request);
    }

    @Override
    public JsonElement getContextResources() {
        return getRequest().getContext().getResourceElement("orders");
    }
}
