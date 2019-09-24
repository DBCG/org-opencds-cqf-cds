package com.alphora.hooks;

import com.alphora.exceptions.MissingRequiredFieldException;
import com.alphora.request.Request;
import com.google.gson.JsonElement;

public class OrderReviewHook extends Hook {

    public OrderReviewHook(Request request) {
        super(request);
    }

    @Override
    public JsonElement getContextResources() {
        JsonElement ordersElement = getRequest().getContext().getResourceElement("orders");

        if (ordersElement == null) {
            throw new MissingRequiredFieldException("orders is required but not found.");
        }

        return ordersElement;
    }
}
