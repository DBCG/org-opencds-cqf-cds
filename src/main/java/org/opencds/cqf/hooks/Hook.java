package org.opencds.cqf.hooks;

import org.opencds.cqf.request.Request;
import com.google.gson.JsonElement;

public abstract class Hook {

    private Request request;

    public Hook(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }

    public abstract JsonElement getContextResources();
}
