package org.opencds.cqf.cds.builders.r4;

import org.opencds.cqf.cds.builders.BaseBuilder;
import org.hl7.fhir.r4.model.*;

import java.util.Collections;
import java.util.List;

public class RequestGroupActionBuilder extends BaseBuilder<RequestGroup.RequestGroupActionComponent> {

    public RequestGroupActionBuilder() {
        super(new RequestGroup.RequestGroupActionComponent());
    }

    // TODO - incomplete

    public RequestGroupActionBuilder buildPrefix(String prefix) {
        complexProperty.setPrefix(prefix);
        return this;
    }

    public RequestGroupActionBuilder buildTitle(String title) {
        complexProperty.setTitle(title);
        return this;
    }

    public RequestGroupActionBuilder buildDescripition(String description) {
        complexProperty.setDescription(description);
        return this;
    }

    public RequestGroupActionBuilder buildDocumentation(List<RelatedArtifact> documentation) {
        complexProperty.setDocumentation(documentation);
        return this;
    }

    public RequestGroupActionBuilder buildType(CodeableConcept type) {
        complexProperty.setType(type);
        return this;
    }

    public RequestGroupActionBuilder buildResource(Reference resource) {
        complexProperty.setResource(resource);
        return this;
    }

    public RequestGroupActionBuilder buildResourceTarget(Resource resource) {
        complexProperty.setResourceTarget(resource);
        return this;
    }

    public RequestGroupActionBuilder buildExtension(String extension) {
        complexProperty.setExtension(Collections.singletonList(new Extension().setUrl("http://example.org").setValue(new StringType(extension))));
        return this;
    }

    public RequestGroupActionBuilder buildExtension(List<Extension> extensions) {
        complexProperty.setExtension(extensions);
        return this;
    }
}
