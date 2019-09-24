package com.alphora.hooks;

import com.alphora.exceptions.MissingRequiredFieldException;
import com.alphora.request.Request;
import com.google.gson.JsonElement;

public class OrderSelectHook extends Hook {

    public OrderSelectHook(Request request) {
        super(request);
    }

    @Override
    public JsonElement getContextResources() {
        JsonElement draftOrdersElement = getRequest().getContext().getResourceElement("draftOrders");

        if (draftOrdersElement == null) {
            throw new MissingRequiredFieldException("draftOrders is required but not found.");
        }

        return draftOrdersElement;
    }
}
