package com.alphora.builders.stu3;

import com.alphora.builders.BaseBuilder;
import org.hl7.fhir.dstu3.model.Extension;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.dstu3.model.Type;

public class ExtensionBuilder extends BaseBuilder<Extension> {

    public ExtensionBuilder() {
        super(new Extension());
    }

    public ExtensionBuilder buildUrl(String url) {
        complexProperty.setUrl(url);
        return this;
    }

    public ExtensionBuilder buildValue(Type value) {
        complexProperty.setValue(value);
        return this;
    }

    public ExtensionBuilder buildValue(String value) {
        complexProperty.setValue(new StringType(value));
        return this;
    }
}
