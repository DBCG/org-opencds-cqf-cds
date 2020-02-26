package org.opencds.cqf.hooks;

import org.opencds.cqf.request.JsonHelper;
import org.opencds.cqf.request.Request;
import com.google.gson.JsonElement;

public class OrderSelectHook extends Hook {

    public OrderSelectHook(Request request) {
        super(request);
    }

    @Override
    public JsonElement getContextResources() {
        return JsonHelper.getObjectRequired(getRequest().getContext().getContextJson(), "draftOrders");
    }
}
