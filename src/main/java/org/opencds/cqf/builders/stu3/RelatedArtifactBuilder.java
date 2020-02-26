package org.opencds.cqf.builders.stu3;

import org.opencds.cqf.builders.BaseBuilder;
import org.hl7.fhir.dstu3.model.Attachment;
import org.hl7.fhir.dstu3.model.RelatedArtifact;
import org.hl7.fhir.exceptions.FHIRException;

public class RelatedArtifactBuilder extends BaseBuilder<RelatedArtifact> {

    public RelatedArtifactBuilder() {
        super(new RelatedArtifact());
    }

    // TODO - incomplete

    public RelatedArtifactBuilder buildType(String type) throws FHIRException {
        complexProperty.setType(RelatedArtifact.RelatedArtifactType.fromCode(type));
        return this;
    }

    public RelatedArtifactBuilder buildType(RelatedArtifact.RelatedArtifactType type) {
        complexProperty.setType(type);
        return this;
    }

    public RelatedArtifactBuilder buildDisplay(String display) {
        complexProperty.setDisplay(display);
        return this;
    }

    public RelatedArtifactBuilder buildUrl(String url) {
        complexProperty.setUrl(url);
        return this;
    }

    public RelatedArtifactBuilder buildDocument(Attachment document) {
        complexProperty.setDocument(document);
        return this;
    }
}
