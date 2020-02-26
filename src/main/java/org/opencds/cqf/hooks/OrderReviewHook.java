package org.opencds.cqf.hooks;

import org.opencds.cqf.request.JsonHelper;
import org.opencds.cqf.request.Request;
import com.google.gson.JsonElement;

public class OrderReviewHook extends Hook {

    public OrderReviewHook(Request request) {
        super(request);
    }

    @Override
    public JsonElement getContextResources() {
        return JsonHelper.getObjectRequired(getRequest().getContext().getContextJson(), "orders");
    }
}
