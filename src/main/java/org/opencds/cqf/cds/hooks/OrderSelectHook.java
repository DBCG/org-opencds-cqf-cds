package org.opencds.cqf.cds.hooks;

import org.opencds.cqf.cds.request.JsonHelper;
import org.opencds.cqf.cds.request.Request;
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
