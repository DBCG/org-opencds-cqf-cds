package org.opencds.cqf.cds.hooks;

import org.opencds.cqf.cds.request.JsonHelper;
import org.opencds.cqf.cds.request.Request;
import com.google.gson.JsonElement;

public class OrderSignHook extends Hook {

    public OrderSignHook(Request request) {
        super(request);
    }

    @Override
    public JsonElement getContextResources() {
        return JsonHelper.getObjectRequired(getRequest().getContext().getContextJson(), "draftOrders");
    }
}
