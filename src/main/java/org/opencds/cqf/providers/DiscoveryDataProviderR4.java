package org.opencds.cqf.providers;

public class DiscoveryDataProviderR4 extends DiscoveryDataProvider {
    @Override
    public String convertPathToSearchParam(String type, String path) {
        path = path.replace(".value", "");
        if (path.equals("id")) {
            path = "_id";
        }

        switch (type) {
            case "Account":
                switch (path) {
                    case "identifier":
                        return "identifier";
                    case "name":
                        return "name";
                    case "owner":
                        return "owner";
                    case "subject.where(resolve() is Patient)":
                        return "patient";
                    case "servicePeriod":
                        return "period";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                    case "type":
                        return "type";
                }
                break;
            case "ActivityDefinition":
                switch (path) {
                    case "relatedArtifact.where(type='composed-of').resource":
                        return "composed-of";
                    case "useContext":
                        return "context-type-quantity";
                    //case "useContext": return "context-type-value";
                    case "useContext.code":
                        return "context-type";
                    case "date":
                        return "date";
                    case "relatedArtifact.where(type='depends-on').resource | ActivityDefinition.library":
                        return "depends-on";
                    case "relatedArtifact.where(type='derived-from').resource":
                        return "derived-from";
                    case "description":
                        return "description";
                    case "effectivePeriod":
                        return "effective";
                    case "identifier":
                        return "identifier";
                    case "jurisdiction":
                        return "jurisdiction";
                    case "name":
                        return "name";
                    case "relatedArtifact.where(type='predecessor').resource":
                        return "predecessor";
                    case "publisher":
                        return "publisher";
                    case "status":
                        return "status";
                    case "relatedArtifact.where(type='successor').resource":
                        return "successor";
                    case "title":
                        return "title";
                    case "topic":
                        return "topic";
                    case "url":
                        return "url";
                    case "version":
                        return "version";
                }
                break;
            case "AdverseEvent":
                switch (path) {
                    case "actuality":
                        return "actuality";
                    case "category":
                        return "category";
                    case "date":
                        return "date";
                    case "event":
                        return "event";
                    case "location":
                        return "location";
                    case "recorder":
                        return "recorder";
                    case "resultingCondition":
                        return "resultingcondition";
                    case "seriousness":
                        return "seriousness";
                    case "severity":
                        return "severity";
                    case "study":
                        return "study";
                    case "subject":
                        return "subject";
                    case "suspectEntity.instance":
                        return "substance";
                }
                break;
            case "AllergyIntolerance":
                switch (path) {
                    case "asserter":
                        return "asserter";
                    case "category":
                        return "category";
                    case "clinicalStatus":
                        return "clinical-status";
                    case "criticality":
                        return "criticality";
                    case "lastOccurrence":
                        return "last-date";
                    case "reaction.manifestation":
                        return "manifestation";
                    case "reaction.onset":
                        return "onset";
                    case "recorder":
                        return "recorder";
                    case "reaction.exposureRoute":
                        return "route";
                    case "reaction.severity":
                        return "severity";
                    case "verificationStatus":
                        return "verification-status";
                }
                break;
            case "Appointment":
                switch (path) {
                    case "participant.actor":
                        return "actor";
                    case "appointmentType":
                        return "appointment-type";
                    case "basedOn":
                        return "based-on";
                    case "start":
                        return "date";
                    case "identifier":
                        return "identifier";
                    case "participant.actor.where(resolve() is Location)":
                        return "location";
                    case "participant.status":
                        return "part-status";
                    case "participant.actor.where(resolve() is Patient)":
                        return "patient";
                    case "participant.actor.where(resolve() is Practitioner)":
                        return "practitioner";
                    case "reasonCode":
                        return "reason-code";
                    case "reasonReference":
                        return "reason-reference";
                    case "serviceCategory":
                        return "service-category";
                    case "serviceType":
                        return "service-type";
                    case "slot":
                        return "slot";
                    case "specialty":
                        return "specialty";
                    case "status":
                        return "status";
                    case "supportingInformation":
                        return "supporting-info";
                }
                break;
            case "AppointmentResponse":
                switch (path) {
                    case "actor":
                        return "actor";
                    case "appointment":
                        return "appointment";
                    case "identifier":
                        return "identifier";
                    case "actor.where(resolve() is Location)":
                        return "location";
                    case "participantStatus":
                        return "part-status";
                    case "actor.where(resolve() is Patient)":
                        return "patient";
                    case "actor.where(resolve() is Practitioner)":
                        return "practitioner";
                }
                break;
            case "AuditEvent":
                switch (path) {
                    case "action":
                        return "action";
                    case "agent.network.address":
                        return "address";
                    case "agent.name":
                        return "agent-name";
                    case "agent.role":
                        return "agent-role";
                    case "agent.who":
                        return "agent";
                    case "agent.altId":
                        return "altid";
                    case "recorded":
                        return "date";
                    case "entity.name":
                        return "entity-name";
                    case "entity.role":
                        return "entity-role";
                    case "entity.type":
                        return "entity-type";
                    case "entity.what":
                        return "entity";
                    case "outcome":
                        return "outcome";
                    case "agent.who.where(resolve() is Patient) | AuditEvent.entity.what.where(resolve() is Patient)":
                        return "patient";
                    case "agent.policy":
                        return "policy";
                    case "source.site":
                        return "site";
                    case "source.observer":
                        return "source";
                    case "subtype":
                        return "subtype";
                    case "type":
                        return "type";
                }
                break;
            case "Basic":
                switch (path) {
                    case "author":
                        return "author";
                    case "code":
                        return "code";
                    case "created":
                        return "created";
                    case "identifier":
                        return "identifier";
                    case "subject.where(resolve() is Patient)":
                        return "patient";
                    case "subject":
                        return "subject";
                }
                break;
            case "BodyStructure":
                switch (path) {
                    case "identifier":
                        return "identifier";
                    case "location":
                        return "location";
                    case "morphology":
                        return "morphology";
                    case "patient":
                        return "patient";
                }
                break;
            case "Bundle":
                switch (path) {
                    case "entry[0].resource":
                        return "composition";
                    case "identifier":
                        return "identifier";
                    //case "entry[0].resource": return "message";
                    case "timestamp":
                        return "timestamp";
                    case "type":
                        return "type";
                }
                break;
            case "CapabilityStatement":
                switch (path) {
                    case "version":
                        return "fhirversion";
                    case "format":
                        return "format";
                    case "implementationGuide":
                        return "guide";
                    case "rest.mode":
                        return "mode";
                    case "rest.resource.profile":
                        return "resource-profile";
                    case "rest.resource.type":
                        return "resource";
                    case "rest.security.service":
                        return "security-service";
                    case "software.name":
                        return "software";
                    case "rest.resource.supportedProfile":
                        return "supported-profile";
                }
                break;
            case "CarePlan":
                switch (path) {
                    case "activity.detail.code":
                        return "activity-code";
                    case "activity.detail.scheduled":
                        return "activity-date";
                    case "activity.reference":
                        return "activity-reference";
                    case "basedOn":
                        return "based-on";
                    case "careTeam":
                        return "care-team";
                    case "category":
                        return "category";
                    case "addresses":
                        return "condition";
                    case "encounter":
                        return "encounter";
                    case "goal":
                        return "goal";
                    case "instantiatesCanonical":
                        return "instantiates-canonical";
                    case "instantiatesUri":
                        return "instantiates-uri";
                    case "intent":
                        return "intent";
                    case "partOf":
                        return "part-of";
                    case "activity.detail.performer":
                        return "performer";
                    case "replaces":
                        return "replaces";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "CareTeam":
                switch (path) {
                    case "category":
                        return "category";
                    case "encounter":
                        return "encounter";
                    case "participant.member":
                        return "participant";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "ChargeItem":
                switch (path) {
                    case "account":
                        return "account";
                    case "code":
                        return "code";
                    case "context":
                        return "context";
                    case "enteredDate":
                        return "entered-date";
                    case "enterer":
                        return "enterer";
                    case "factorOverride":
                        return "factor-override";
                    case "identifier":
                        return "identifier";
                    case "occurrence":
                        return "occurrence";
                    case "subject.where(resolve() is Patient)":
                        return "patient";
                    case "performer.actor":
                        return "performer-actor";
                    case "performer.function":
                        return "performer-function";
                    case "performingOrganization":
                        return "performing-organization";
                    case "priceOverride":
                        return "price-override";
                    case "quantity":
                        return "quantity";
                    case "requestingOrganization":
                        return "requesting-organization";
                    case "service":
                        return "service";
                    case "subject":
                        return "subject";
                }
                break;
            case "ChargeItemDefinition":
                switch (path) {
                    case "useContext":
                        return "context-type-quantity";
                    //case "useContext": return "context-type-value";
                    case "useContext.code":
                        return "context-type";
                    case "date":
                        return "date";
                    case "description":
                        return "description";
                    case "effectivePeriod":
                        return "effective";
                    case "identifier":
                        return "identifier";
                    case "jurisdiction":
                        return "jurisdiction";
                    case "publisher":
                        return "publisher";
                    case "status":
                        return "status";
                    case "title":
                        return "title";
                    case "url":
                        return "url";
                    case "version":
                        return "version";
                }
                break;
            case "Claim":
                switch (path) {
                    case "careTeam.provider":
                        return "care-team";
                    case "created":
                        return "created";
                    case "item.detail.udi":
                        return "detail-udi";
                    case "item.encounter":
                        return "encounter";
                    case "enterer":
                        return "enterer";
                    case "facility":
                        return "facility";
                    case "identifier":
                        return "identifier";
                    case "insurer":
                        return "insurer";
                    case "item.udi":
                        return "item-udi";
                    case "patient":
                        return "patient";
                    case "payee.party":
                        return "payee";
                    case "priority":
                        return "priority";
                    case "procedure.udi":
                        return "procedure-udi";
                    case "provider":
                        return "provider";
                    case "status":
                        return "status";
                    case "item.detail.subDetail.udi":
                        return "subdetail-udi";
                    case "use":
                        return "use";
                }
                break;
            case "ClaimResponse":
                switch (path) {
                    case "created":
                        return "created";
                    case "disposition":
                        return "disposition";
                    case "identifier":
                        return "identifier";
                    case "insurer":
                        return "insurer";
                    case "outcome":
                        return "outcome";
                    case "patient":
                        return "patient";
                    case "payment.date":
                        return "payment-date";
                    case "request":
                        return "request";
                    case "requestor":
                        return "requestor";
                    case "status":
                        return "status";
                    case "use":
                        return "use";
                }
                break;
            case "ClinicalImpression":
                switch (path) {
                    case "assessor":
                        return "assessor";
                    case "encounter":
                        return "encounter";
                    case "finding.itemCodeableConcept":
                        return "finding-code";
                    case "finding.itemReference":
                        return "finding-ref";
                    case "identifier":
                        return "identifier";
                    case "investigation.item":
                        return "investigation";
                    case "previous":
                        return "previous";
                    case "problem":
                        return "problem";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                    case "supportingInfo":
                        return "supporting-info";
                }
                break;
            case "CodeSystem":
                switch (path) {
                    case "concept.code":
                        return "code";
                    case "content":
                        return "content-mode";
                    case "concept.designation.language":
                        return "language";
                    case "supplements":
                        return "supplements";
                    case "url":
                        return "system";
                }
                break;
            case "Communication":
                switch (path) {
                    case "basedOn":
                        return "based-on";
                    case "category":
                        return "category";
                    case "encounter":
                        return "encounter";
                    case "identifier":
                        return "identifier";
                    case "instantiatesCanonical":
                        return "instantiates-canonical";
                    case "instantiatesUri":
                        return "instantiates-uri";
                    case "medium":
                        return "medium";
                    case "partOf":
                        return "part-of";
                    case "subject.where(resolve() is Patient)":
                        return "patient";
                    case "received":
                        return "received";
                    case "recipient":
                        return "recipient";
                    case "sender":
                        return "sender";
                    case "sent":
                        return "sent";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "CommunicationRequest":
                switch (path) {
                    case "authoredOn":
                        return "authored";
                    case "basedOn":
                        return "based-on";
                    case "category":
                        return "category";
                    case "encounter":
                        return "encounter";
                    case "groupIdentifier":
                        return "group-identifier";
                    case "identifier":
                        return "identifier";
                    case "medium":
                        return "medium";
                    case "subject.where(resolve() is Patient)":
                        return "patient";
                    case "priority":
                        return "priority";
                    case "recipient":
                        return "recipient";
                    case "replaces":
                        return "replaces";
                    case "requester":
                        return "requester";
                    case "sender":
                        return "sender";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "CompartmentDefinition":
                switch (path) {
                    case "code":
                        return "code";
                    case "resource.code":
                        return "resource";
                }
                break;
            case "Composition":
                switch (path) {
                    case "attester.party":
                        return "attester";
                    case "author":
                        return "author";
                    case "category":
                        return "category";
                    case "confidentiality":
                        return "confidentiality";
                    case "event.code":
                        return "context";
                    case "section.entry":
                        return "entry";
                    case "event.period":
                        return "period";
                    case "section.code":
                        return "section";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                    case "title":
                        return "title";
                }
                break;
            case "ConceptMap":
                switch (path) {
                    case "group.element.target.dependsOn.property":
                        return "dependson";
                    case "group.unmapped.url":
                        return "other";
                    case "group.element.target.product.property":
                        return "product";
                    case "group.element.code":
                        return "source-code";
                    case "group.source":
                        return "source-system";
                    case "group.element.target.code":
                        return "target-code";
                    case "group.target":
                        return "target-system";
                }
                break;
            case "Condition":
                switch (path) {
                    case "abatement.as(Age) | Condition.abatement.as(Range)":
                        return "abatement-age";
                    case "abatement.as(dateTime) | Condition.abatement.as(Period)":
                        return "abatement-date";
                    case "abatement.as(string)":
                        return "abatement-string";
                    case "asserter":
                        return "asserter";
                    case "bodySite":
                        return "body-site";
                    case "category":
                        return "category";
                    case "clinicalStatus":
                        return "clinical-status";
                    case "encounter":
                        return "encounter";
                    case "evidence.detail":
                        return "evidence-detail";
                    case "evidence.code":
                        return "evidence";
                    case "onset.as(Age) | Condition.onset.as(Range)":
                        return "onset-age";
                    case "onset.as(dateTime) | Condition.onset.as(Period)":
                        return "onset-date";
                    case "onset.as(string)":
                        return "onset-info";
                    case "recordedDate":
                        return "recorded-date";
                    case "severity":
                        return "severity";
                    case "stage.summary":
                        return "stage";
                    case "subject":
                        return "subject";
                    case "verificationStatus":
                        return "verification-status";
                }
                break;
            case "Consent":
                switch (path) {
                    case "provision.action":
                        return "action";
                    case "provision.actor.reference":
                        return "actor";
                    case "category":
                        return "category";
                    case "performer":
                        return "consentor";
                    case "provision.data.reference":
                        return "data";
                    case "organization":
                        return "organization";
                    case "provision.period":
                        return "period";
                    case "provision.purpose":
                        return "purpose";
                    case "scope":
                        return "scope";
                    case "provision.securityLabel":
                        return "security-label";
                    case "source":
                        return "source-reference";
                    case "status":
                        return "status";
                }
                break;
            case "Contract":
                switch (path) {
                    case "authority":
                        return "authority";
                    case "domain":
                        return "domain";
                    case "identifier":
                        return "identifier";
                    case "instantiatesUri":
                        return "instantiates";
                    case "issued":
                        return "issued";
                    case "subject.where(resolve() is Patient)":
                        return "patient";
                    case "signer.party":
                        return "signer";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                    case "url":
                        return "url";
                }
                break;
            case "Coverage":
                switch (path) {
                    case "beneficiary":
                        return "beneficiary";
                    case "class.type":
                        return "class-type";
                    case "class.value":
                        return "class-value";
                    case "dependent":
                        return "dependent";
                    case "identifier":
                        return "identifier";
                    //case "beneficiary": return "patient";
                    case "payor":
                        return "payor";
                    case "policyHolder":
                        return "policy-holder";
                    case "status":
                        return "status";
                    case "subscriber":
                        return "subscriber";
                    case "type":
                        return "type";
                }
                break;
            case "CoverageEligibilityRequest":
                switch (path) {
                    case "created":
                        return "created";
                    case "enterer":
                        return "enterer";
                    case "facility":
                        return "facility";
                    case "identifier":
                        return "identifier";
                    case "patient":
                        return "patient";
                    case "provider":
                        return "provider";
                    case "status":
                        return "status";
                }
                break;
            case "CoverageEligibilityResponse":
                switch (path) {
                    case "created":
                        return "created";
                    case "disposition":
                        return "disposition";
                    case "identifier":
                        return "identifier";
                    case "insurer":
                        return "insurer";
                    case "outcome":
                        return "outcome";
                    case "patient":
                        return "patient";
                    case "request":
                        return "request";
                    case "requestor":
                        return "requestor";
                    case "status":
                        return "status";
                }
                break;
            case "DetectedIssue":
                switch (path) {
                    case "author":
                        return "author";
                    case "code":
                        return "code";
                    case "identified":
                        return "identified";
                    case "implicated":
                        return "implicated";
                }
                break;
            case "Device":
                switch (path) {
                    case "deviceName.name | Device.type.coding.display | Device.type.text":
                        return "device-name";
                    case "identifier":
                        return "identifier";
                    case "location":
                        return "location";
                    case "manufacturer":
                        return "manufacturer";
                    case "modelNumber":
                        return "model";
                    case "owner":
                        return "organization";
                    case "patient":
                        return "patient";
                    case "status":
                        return "status";
                    case "type":
                        return "type";
                    case "udiCarrier.carrierHRF":
                        return "udi-carrier";
                    case "udiCarrier.deviceIdentifier":
                        return "udi-di";
                    case "url":
                        return "url";
                }
                break;
            case "DeviceDefinition":
                switch (path) {
                    case "identifier":
                        return "identifier";
                    case "parentDevice":
                        return "parent";
                    case "type":
                        return "type";
                }
                break;
            case "DeviceMetric":
                switch (path) {
                    case "category":
                        return "category";
                    case "identifier":
                        return "identifier";
                    case "parent":
                        return "parent";
                    case "source":
                        return "source";
                    case "type":
                        return "type";
                }
                break;
            case "DeviceRequest":
                switch (path) {
                    case "authoredOn":
                        return "authored-on";
                    case "basedOn":
                        return "based-on";
                    case "groupIdentifier":
                        return "group-identifier";
                    case "instantiatesCanonical":
                        return "instantiates-canonical";
                    case "instantiatesUri":
                        return "instantiates-uri";
                    case "insurance":
                        return "insurance";
                    case "intent":
                        return "intent";
                    case "performer":
                        return "performer";
                    case "priorRequest":
                        return "prior-request";
                    case "requester":
                        return "requester";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "DeviceUseStatement":
                switch (path) {
                    case "device":
                        return "device";
                    case "identifier":
                        return "identifier";
                    case "subject":
                        return "subject";
                }
                break;
            case "DiagnosticReport":
                switch (path) {
                    case "basedOn":
                        return "based-on";
                    case "category":
                        return "category";
                    case "conclusionCode":
                        return "conclusion";
                    case "issued":
                        return "issued";
                    case "media.link":
                        return "media";
                    case "performer":
                        return "performer";
                    case "result":
                        return "result";
                    case "resultsInterpreter":
                        return "results-interpreter";
                    case "specimen":
                        return "specimen";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "DocumentManifest":
                switch (path) {
                    case "author":
                        return "author";
                    case "created":
                        return "created";
                    case "description":
                        return "description";
                    case "content":
                        return "item";
                    case "recipient":
                        return "recipient";
                    case "related.identifier":
                        return "related-id";
                    case "related.ref":
                        return "related-ref";
                    case "source":
                        return "source";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "DocumentReference":
                switch (path) {
                    case "authenticator":
                        return "authenticator";
                    case "author":
                        return "author";
                    case "category":
                        return "category";
                    case "content.attachment.contentType":
                        return "contenttype";
                    case "custodian":
                        return "custodian";
                    case "date":
                        return "date";
                    case "description":
                        return "description";
                    case "context.event":
                        return "event";
                    case "context.facilityType":
                        return "facility";
                    case "content.format":
                        return "format";
                    case "content.attachment.language":
                        return "language";
                    case "content.attachment.url":
                        return "location";
                    case "context.period":
                        return "period";
                    case "context.related":
                        return "related";
                    case "relatesTo.target":
                        return "relatesto";
                    case "relatesTo.code":
                        return "relation";
                    case "relatesTo":
                        return "relationship";
                    case "securityLabel":
                        return "security-label";
                    case "context.practiceSetting":
                        return "setting";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "DomainResource":
                switch (path) {
                }
                break;
            case "EffectEvidenceSynthesis":
                switch (path) {
                    case "useContext":
                        return "context-type-quantity";
                    //case "useContext": return "context-type-value";
                    case "useContext.code":
                        return "context-type";
                    case "date":
                        return "date";
                    case "description":
                        return "description";
                    case "effectivePeriod":
                        return "effective";
                    case "identifier":
                        return "identifier";
                    case "jurisdiction":
                        return "jurisdiction";
                    case "name":
                        return "name";
                    case "publisher":
                        return "publisher";
                    case "status":
                        return "status";
                    case "title":
                        return "title";
                    case "url":
                        return "url";
                    case "version":
                        return "version";
                }
                break;
            case "Encounter":
                switch (path) {
                    case "account":
                        return "account";
                    case "appointment":
                        return "appointment";
                    case "basedOn":
                        return "based-on";
                    case "class":
                        return "class";
                    case "diagnosis.condition":
                        return "diagnosis";
                    case "episodeOfCare":
                        return "episode-of-care";
                    case "length":
                        return "length";
                    case "location.period":
                        return "location-period";
                    case "location.location":
                        return "location";
                    case "partOf":
                        return "part-of";
                    case "participant.type":
                        return "participant-type";
                    case "participant.individual":
                        return "participant";
                    case "participant.individual.where(resolve() is Practitioner)":
                        return "practitioner";
                    case "reasonCode":
                        return "reason-code";
                    case "reasonReference":
                        return "reason-reference";
                    case "serviceProvider":
                        return "service-provider";
                    case "hospitalization.specialArrangement":
                        return "special-arrangement";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "Endpoint":
                switch (path) {
                    case "connectionType":
                        return "connection-type";
                    case "identifier":
                        return "identifier";
                    case "name":
                        return "name";
                    case "managingOrganization":
                        return "organization";
                    case "payloadType":
                        return "payload-type";
                    case "status":
                        return "status";
                }
                break;
            case "EnrollmentRequest":
                switch (path) {
                    case "identifier":
                        return "identifier";
                    case "candidate":
                        return "patient";
                    case "status":
                        return "status";
                    //case "candidate": return "subject";
                }
                break;
            case "EnrollmentResponse":
                switch (path) {
                    case "identifier":
                        return "identifier";
                    case "request":
                        return "request";
                    case "status":
                        return "status";
                }
                break;
            case "EpisodeOfCare":
                switch (path) {
                    case "careManager.where(resolve() is Practitioner)":
                        return "care-manager";
                    case "diagnosis.condition":
                        return "condition";
                    case "referralRequest":
                        return "incoming-referral";
                    case "managingOrganization":
                        return "organization";
                    case "status":
                        return "status";
                }
                break;
            case "EventDefinition":
                switch (path) {
                    case "relatedArtifact.where(type='composed-of').resource":
                        return "composed-of";
                    case "useContext":
                        return "context-type-quantity";
                    //case "useContext": return "context-type-value";
                    case "useContext.code":
                        return "context-type";
                    case "date":
                        return "date";
                    case "relatedArtifact.where(type='depends-on').resource":
                        return "depends-on";
                    case "relatedArtifact.where(type='derived-from').resource":
                        return "derived-from";
                    case "description":
                        return "description";
                    case "effectivePeriod":
                        return "effective";
                    case "identifier":
                        return "identifier";
                    case "jurisdiction":
                        return "jurisdiction";
                    case "name":
                        return "name";
                    case "relatedArtifact.where(type='predecessor').resource":
                        return "predecessor";
                    case "publisher":
                        return "publisher";
                    case "status":
                        return "status";
                    case "relatedArtifact.where(type='successor').resource":
                        return "successor";
                    case "title":
                        return "title";
                    case "topic":
                        return "topic";
                    case "url":
                        return "url";
                    case "version":
                        return "version";
                }
                break;
            case "Evidence":
                switch (path) {
                    case "relatedArtifact.where(type='composed-of').resource":
                        return "composed-of";
                    case "useContext":
                        return "context-type-quantity";
                    //case "useContext": return "context-type-value";
                    case "useContext.code":
                        return "context-type";
                    case "date":
                        return "date";
                    case "relatedArtifact.where(type='depends-on').resource":
                        return "depends-on";
                    case "relatedArtifact.where(type='derived-from').resource":
                        return "derived-from";
                    case "description":
                        return "description";
                    case "effectivePeriod":
                        return "effective";
                    case "identifier":
                        return "identifier";
                    case "jurisdiction":
                        return "jurisdiction";
                    case "name":
                        return "name";
                    case "relatedArtifact.where(type='predecessor').resource":
                        return "predecessor";
                    case "publisher":
                        return "publisher";
                    case "status":
                        return "status";
                    case "relatedArtifact.where(type='successor').resource":
                        return "successor";
                    case "title":
                        return "title";
                    case "topic":
                        return "topic";
                    case "url":
                        return "url";
                    case "version":
                        return "version";
                }
                break;
            case "EvidenceVariable":
                switch (path) {
                    case "relatedArtifact.where(type='composed-of').resource":
                        return "composed-of";
                    case "useContext":
                        return "context-type-quantity";
                    //case "useContext": return "context-type-value";
                    case "useContext.code":
                        return "context-type";
                    case "date":
                        return "date";
                    case "relatedArtifact.where(type='depends-on').resource":
                        return "depends-on";
                    case "relatedArtifact.where(type='derived-from').resource":
                        return "derived-from";
                    case "description":
                        return "description";
                    case "effectivePeriod":
                        return "effective";
                    case "identifier":
                        return "identifier";
                    case "jurisdiction":
                        return "jurisdiction";
                    case "name":
                        return "name";
                    case "relatedArtifact.where(type='predecessor').resource":
                        return "predecessor";
                    case "publisher":
                        return "publisher";
                    case "status":
                        return "status";
                    case "relatedArtifact.where(type='successor').resource":
                        return "successor";
                    case "title":
                        return "title";
                    case "topic":
                        return "topic";
                    case "url":
                        return "url";
                    case "version":
                        return "version";
                }
                break;
            case "ExampleScenario":
                switch (path) {
                    case "useContext":
                        return "context-type-quantity";
                    //case "useContext": return "context-type-value";
                    case "useContext.code":
                        return "context-type";
                    case "date":
                        return "date";
                    case "identifier":
                        return "identifier";
                    case "jurisdiction":
                        return "jurisdiction";
                    case "name":
                        return "name";
                    case "publisher":
                        return "publisher";
                    case "status":
                        return "status";
                    case "url":
                        return "url";
                    case "version":
                        return "version";
                }
                break;
            case "ExplanationOfBenefit":
                switch (path) {
                    case "careTeam.provider":
                        return "care-team";
                    case "claim":
                        return "claim";
                    case "insurance.coverage":
                        return "coverage";
                    case "created":
                        return "created";
                    case "item.detail.udi":
                        return "detail-udi";
                    case "disposition":
                        return "disposition";
                    case "item.encounter":
                        return "encounter";
                    case "enterer":
                        return "enterer";
                    case "facility":
                        return "facility";
                    case "identifier":
                        return "identifier";
                    case "item.udi":
                        return "item-udi";
                    case "patient":
                        return "patient";
                    case "payee.party":
                        return "payee";
                    case "procedure.udi":
                        return "procedure-udi";
                    case "provider":
                        return "provider";
                    case "status":
                        return "status";
                    case "item.detail.subDetail.udi":
                        return "subdetail-udi";
                }
                break;
            case "FamilyMemberHistory":
                switch (path) {
                    case "instantiatesCanonical":
                        return "instantiates-canonical";
                    case "instantiatesUri":
                        return "instantiates-uri";
                    case "relationship":
                        return "relationship";
                    case "sex":
                        return "sex";
                    case "status":
                        return "status";
                }
                break;
            case "Flag":
                switch (path) {
                    case "author":
                        return "author";
                    case "identifier":
                        return "identifier";
                    case "subject":
                        return "subject";
                }
                break;
            case "Goal":
                switch (path) {
                    case "achievementStatus":
                        return "achievement-status";
                    case "category":
                        return "category";
                    case "lifecycleStatus":
                        return "lifecycle-status";
                    case "subject":
                        return "subject";
                }
                break;
            case "GraphDefinition":
                switch (path) {
                    case "start":
                        return "start";
                }
                break;
            case "Group":
                switch (path) {
                    case "actual":
                        return "actual";
                    case "characteristic":
                        return "characteristic-value";
                    case "characteristic.code":
                        return "characteristic";
                    case "code":
                        return "code";
                    case "characteristic.exclude":
                        return "exclude";
                    case "identifier":
                        return "identifier";
                    case "managingEntity":
                        return "managing-entity";
                    case "member.entity":
                        return "member";
                    case "type":
                        return "type";
                }
                break;
            case "GuidanceResponse":
                switch (path) {
                    case "identifier":
                        return "identifier";
                    case "subject.where(resolve() is Patient)":
                        return "patient";
                    case "requestIdentifier":
                        return "request";
                    case "subject":
                        return "subject";
                }
                break;
            case "HealthcareService":
                switch (path) {
                    case "active":
                        return "active";
                    case "characteristic":
                        return "characteristic";
                    case "coverageArea":
                        return "coverage-area";
                    case "endpoint":
                        return "endpoint";
                    case "identifier":
                        return "identifier";
                    case "location":
                        return "location";
                    case "name":
                        return "name";
                    case "providedBy":
                        return "organization";
                    case "program":
                        return "program";
                    case "category":
                        return "service-category";
                    case "type":
                        return "service-type";
                    case "specialty":
                        return "specialty";
                }
                break;
            case "ImagingStudy":
                switch (path) {
                    case "basedOn":
                        return "basedon";
                    case "series.bodySite":
                        return "bodysite";
                    case "series.instance.sopClass":
                        return "dicom-class";
                    case "encounter":
                        return "encounter";
                    case "endpoint | ImagingStudy.series.endpoint":
                        return "endpoint";
                    case "series.instance.uid":
                        return "instance";
                    case "interpreter":
                        return "interpreter";
                    case "series.modality":
                        return "modality";
                    case "series.performer.actor":
                        return "performer";
                    case "reasonCode":
                        return "reason";
                    case "referrer":
                        return "referrer";
                    case "series.uid":
                        return "series";
                    case "started":
                        return "started";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "Immunization":
                switch (path) {
                    case "location":
                        return "location";
                    case "lotNumber":
                        return "lot-number";
                    case "manufacturer":
                        return "manufacturer";
                    case "performer.actor":
                        return "performer";
                    case "reaction.date":
                        return "reaction-date";
                    case "reaction.detail":
                        return "reaction";
                    case "reasonCode":
                        return "reason-code";
                    case "reasonReference":
                        return "reason-reference";
                    case "protocolApplied.series":
                        return "series";
                    case "statusReason":
                        return "status-reason";
                    case "status":
                        return "status";
                    case "protocolApplied.targetDisease":
                        return "target-disease";
                    case "vaccineCode":
                        return "vaccine-code";
                }
                break;
            case "ImmunizationEvaluation":
                switch (path) {
                    case "date":
                        return "date";
                    case "doseStatus":
                        return "dose-status";
                    case "identifier":
                        return "identifier";
                    case "immunizationEvent":
                        return "immunization-event";
                    case "patient":
                        return "patient";
                    case "status":
                        return "status";
                    case "targetDisease":
                        return "target-disease";
                }
                break;
            case "ImmunizationRecommendation":
                switch (path) {
                    case "date":
                        return "date";
                    case "identifier":
                        return "identifier";
                    case "recommendation.supportingPatientInformation":
                        return "information";
                    case "patient":
                        return "patient";
                    case "recommendation.forecastStatus":
                        return "status";
                    case "recommendation.supportingImmunization":
                        return "support";
                    case "recommendation.targetDisease":
                        return "target-disease";
                    case "recommendation.vaccineCode":
                        return "vaccine-type";
                }
                break;
            case "ImplementationGuide":
                switch (path) {
                    case "dependsOn.uri":
                        return "depends-on";
                    case "experimental":
                        return "experimental";
                    case "global.profile":
                        return "global";
                    case "definition.resource.reference":
                        return "resource";
                }
                break;
            case "InsurancePlan":
                switch (path) {
                    case "contact.address.city":
                        return "address-city";
                    case "contact.address.country":
                        return "address-country";
                    case "contact.address.postalCode":
                        return "address-postalcode";
                    case "contact.address.state":
                        return "address-state";
                    case "contact.address.use":
                        return "address-use";
                    case "contact.address":
                        return "address";
                    case "administeredBy":
                        return "administered-by";
                    case "endpoint":
                        return "endpoint";
                    case "identifier":
                        return "identifier";
                    case "ownedBy":
                        return "owned-by";
                    case "name":
                        return "phonetic";
                    case "status":
                        return "status";
                    case "type":
                        return "type";
                }
                break;
            case "Invoice":
                switch (path) {
                    case "account":
                        return "account";
                    case "date":
                        return "date";
                    case "identifier":
                        return "identifier";
                    case "issuer":
                        return "issuer";
                    case "participant.role":
                        return "participant-role";
                    case "participant.actor":
                        return "participant";
                    case "subject.where(resolve() is Patient)":
                        return "patient";
                    case "recipient":
                        return "recipient";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                    case "totalGross":
                        return "totalgross";
                    case "totalNet":
                        return "totalnet";
                    case "type":
                        return "type";
                }
                break;
            case "Library":
                switch (path) {
                    case "relatedArtifact.where(type='composed-of').resource":
                        return "composed-of";
                    case "content.contentType":
                        return "content-type";
                    case "useContext":
                        return "context-type-quantity";
                    //case "useContext": return "context-type-value";
                    case "useContext.code":
                        return "context-type";
                    case "date":
                        return "date";
                    case "relatedArtifact.where(type='depends-on').resource":
                        return "depends-on";
                    case "relatedArtifact.where(type='derived-from').resource":
                        return "derived-from";
                    case "description":
                        return "description";
                    case "effectivePeriod":
                        return "effective";
                    case "identifier":
                        return "identifier";
                    case "jurisdiction":
                        return "jurisdiction";
                    case "name":
                        return "name";
                    case "relatedArtifact.where(type='predecessor').resource":
                        return "predecessor";
                    case "publisher":
                        return "publisher";
                    case "status":
                        return "status";
                    case "relatedArtifact.where(type='successor').resource":
                        return "successor";
                    case "title":
                        return "title";
                    case "topic":
                        return "topic";
                    case "type":
                        return "type";
                    case "url":
                        return "url";
                    case "version":
                        return "version";
                }
                break;
            case "Linkage":
                switch (path) {
                    case "author":
                        return "author";
                    case "item.resource":
                        return "item";
                    //case "item.resource": return "source";
                }
                break;
            case "List":
                switch (path) {
                    case "emptyReason":
                        return "empty-reason";
                    case "entry.item":
                        return "item";
                    case "note.text":
                        return "notes";
                    case "source":
                        return "source";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                    case "title":
                        return "title";
                }
                break;
            case "Location":
                switch (path) {
                    case "address.city":
                        return "address-city";
                    case "address.country":
                        return "address-country";
                    case "address.postalCode":
                        return "address-postalcode";
                    case "address.state":
                        return "address-state";
                    case "address.use":
                        return "address-use";
                    case "address":
                        return "address";
                    case "endpoint":
                        return "endpoint";
                    case "identifier":
                        return "identifier";
                    case "name | Location.alias":
                        return "name";
                    case "position":
                        return "near";
                    case "operationalStatus":
                        return "operational-status";
                    case "managingOrganization":
                        return "organization";
                    case "partOf":
                        return "partof";
                    case "status":
                        return "status";
                    case "type":
                        return "type";
                }
                break;
            case "Measure":
                switch (path) {
                    case "relatedArtifact.where(type='composed-of').resource":
                        return "composed-of";
                    case "useContext":
                        return "context-type-quantity";
                    //case "useContext": return "context-type-value";
                    case "useContext.code":
                        return "context-type";
                    case "date":
                        return "date";
                    case "relatedArtifact.where(type='depends-on').resource | Measure.library":
                        return "depends-on";
                    case "relatedArtifact.where(type='derived-from').resource":
                        return "derived-from";
                    case "description":
                        return "description";
                    case "effectivePeriod":
                        return "effective";
                    case "identifier":
                        return "identifier";
                    case "jurisdiction":
                        return "jurisdiction";
                    case "name":
                        return "name";
                    case "relatedArtifact.where(type='predecessor').resource":
                        return "predecessor";
                    case "publisher":
                        return "publisher";
                    case "status":
                        return "status";
                    case "relatedArtifact.where(type='successor').resource":
                        return "successor";
                    case "title":
                        return "title";
                    case "topic":
                        return "topic";
                    case "url":
                        return "url";
                    case "version":
                        return "version";
                }
                break;
            case "MeasureReport":
                switch (path) {
                    case "date":
                        return "date";
                    case "evaluatedResource":
                        return "evaluated-resource";
                    case "identifier":
                        return "identifier";
                    case "measure":
                        return "measure";
                    case "subject.where(resolve() is Patient)":
                        return "patient";
                    case "period":
                        return "period";
                    case "reporter":
                        return "reporter";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "Media":
                switch (path) {
                    case "basedOn":
                        return "based-on";
                    case "created":
                        return "created";
                    case "device":
                        return "device";
                    case "encounter":
                        return "encounter";
                    case "identifier":
                        return "identifier";
                    case "modality":
                        return "modality";
                    case "operator":
                        return "operator";
                    case "subject.where(resolve() is Patient)":
                        return "patient";
                    case "bodySite":
                        return "site";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                    case "type":
                        return "type";
                    case "view":
                        return "view";
                }
                break;
            case "Medication":
                switch (path) {
                    case "batch.expirationDate":
                        return "expiration-date";
                    case "form":
                        return "form";
                    case "identifier":
                        return "identifier";
                    case "batch.lotNumber":
                        return "lot-number";
                    case "manufacturer":
                        return "manufacturer";
                    case "status":
                        return "status";
                }
                break;
            case "MedicationAdministration":
                switch (path) {
                    case "context":
                        return "context";
                    case "device":
                        return "device";
                    case "effective":
                        return "effective-time";
                    case "performer.actor":
                        return "performer";
                    case "reasonCode":
                        return "reason-given";
                    case "statusReason":
                        return "reason-not-given";
                    case "request":
                        return "request";
                    case "subject":
                        return "subject";
                }
                break;
            case "MedicationDispense":
                switch (path) {
                    case "context":
                        return "context";
                    case "destination":
                        return "destination";
                    case "performer.actor":
                        return "performer";
                    case "receiver":
                        return "receiver";
                    case "substitution.responsibleParty":
                        return "responsibleparty";
                    case "subject":
                        return "subject";
                    case "type":
                        return "type";
                    case "whenHandedOver":
                        return "whenhandedover";
                    case "whenPrepared":
                        return "whenprepared";
                }
                break;
            case "MedicationKnowledge":
                switch (path) {
                    case "medicineClassification.type":
                        return "classification-type";
                    case "medicineClassification.classification":
                        return "classification";
                    case "code":
                        return "code";
                    case "doseForm":
                        return "doseform";
                    case "manufacturer":
                        return "manufacturer";
                    case "monitoringProgram.name":
                        return "monitoring-program-name";
                    case "monitoringProgram.type":
                        return "monitoring-program-type";
                    case "monograph.type":
                        return "monograph-type";
                    case "monograph.source":
                        return "monograph";
                    case "cost.source":
                        return "source-cost";
                    case "status":
                        return "status";
                }
                break;
            case "MedicationRequest":
                switch (path) {
                    case "authoredOn":
                        return "authoredon";
                    case "category":
                        return "category";
                    case "dispenseRequest.performer":
                        return "intended-dispenser";
                    case "performer":
                        return "intended-performer";
                    case "performerType":
                        return "intended-performertype";
                    case "intent":
                        return "intent";
                    case "priority":
                        return "priority";
                    case "requester":
                        return "requester";
                    case "subject":
                        return "subject";
                }
                break;
            case "MedicationStatement":
                switch (path) {
                    case "category":
                        return "category";
                    case "context":
                        return "context";
                    case "effective":
                        return "effective";
                    case "partOf":
                        return "part-of";
                    case "informationSource":
                        return "source";
                    case "subject":
                        return "subject";
                }
                break;
            case "MedicinalProduct":
                switch (path) {
                    case "identifier":
                        return "identifier";
                    case "name.countryLanguage.language":
                        return "name-language";
                    case "name.productName":
                        return "name";
                }
                break;
            case "MedicinalProductAuthorization":
                switch (path) {
                    case "country":
                        return "country";
                    case "holder":
                        return "holder";
                    case "identifier":
                        return "identifier";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "MedicinalProductContraindication":
                switch (path) {
                    case "subject":
                        return "subject";
                }
                break;
            case "MedicinalProductIndication":
                switch (path) {
                    case "subject":
                        return "subject";
                }
                break;
            case "MedicinalProductInteraction":
                switch (path) {
                    case "subject":
                        return "subject";
                }
                break;
            case "MedicinalProductPackaged":
                switch (path) {
                    case "identifier":
                        return "identifier";
                    case "subject":
                        return "subject";
                }
                break;
            case "MedicinalProductPharmaceutical":
                switch (path) {
                    case "identifier":
                        return "identifier";
                    case "routeOfAdministration.code":
                        return "route";
                    case "routeOfAdministration.targetSpecies.code":
                        return "target-species";
                }
                break;
            case "MedicinalProductUndesirableEffect":
                switch (path) {
                    case "subject":
                        return "subject";
                }
                break;
            case "MessageDefinition":
                switch (path) {
                    case "category":
                        return "category";
                    case "event":
                        return "event";
                    case "focus.code":
                        return "focus";
                    case "parent":
                        return "parent";
                }
                break;
            case "MessageHeader":
                switch (path) {
                    case "author":
                        return "author";
                    case "response.code":
                        return "code";
                    case "destination.endpoint":
                        return "destination-uri";
                    case "destination.name":
                        return "destination";
                    case "enterer":
                        return "enterer";
                    case "event":
                        return "event";
                    case "focus":
                        return "focus";
                    case "destination.receiver":
                        return "receiver";
                    case "response.identifier":
                        return "response-id";
                    case "responsible":
                        return "responsible";
                    case "sender":
                        return "sender";
                    case "source.endpoint":
                        return "source-uri";
                    case "source.name":
                        return "source";
                    case "destination.target":
                        return "target";
                }
                break;
            case "MolecularSequence":
                switch (path) {
                    case "variant":
                        return "chromosome-variant-coordinate";
                    case "referenceSeq":
                        return "chromosome-window-coordinate";
                    case "referenceSeq.chromosome":
                        return "chromosome";
                    case "identifier":
                        return "identifier";
                    case "patient":
                        return "patient";
                    //case "variant": return "referenceseqid-variant-coordinate";
                    //case "referenceSeq": return "referenceseqid-window-coordinate";
                    case "referenceSeq.referenceSeqId":
                        return "referenceseqid";
                    case "type":
                        return "type";
                    case "variant.end":
                        return "variant-end";
                    case "variant.start":
                        return "variant-start";
                    case "referenceSeq.windowEnd":
                        return "window-end";
                    case "referenceSeq.windowStart":
                        return "window-start";
                }
                break;
            case "NamingSystem":
                switch (path) {
                    case "contact.name":
                        return "contact";
                    case "uniqueId.type":
                        return "id-type";
                    case "kind":
                        return "kind";
                    case "uniqueId.period":
                        return "period";
                    case "responsible":
                        return "responsible";
                    case "contact.telecom":
                        return "telecom";
                    case "type":
                        return "type";
                    case "uniqueId.value":
                        return "value";
                }
                break;
            case "NutritionOrder":
                switch (path) {
                    case "enteralFormula.additiveType":
                        return "additive";
                    case "dateTime":
                        return "datetime";
                    case "enteralFormula.baseFormulaType":
                        return "formula";
                    case "instantiatesCanonical":
                        return "instantiates-canonical";
                    case "instantiatesUri":
                        return "instantiates-uri";
                    case "oralDiet.type":
                        return "oraldiet";
                    case "orderer":
                        return "provider";
                    case "status":
                        return "status";
                    case "supplement.type":
                        return "supplement";
                }
                break;
            case "Observation":
                switch (path) {
                    case "basedOn":
                        return "based-on";
                    case "category":
                        return "category";
                    case "code | Observation.component.code":
                        return "combo-code";
                    case "dataAbsentReason | Observation.component.dataAbsentReason":
                        return "combo-data-absent-reason";
                    case "component":
                        return "component-code-value-concept";
                    //case "component": return "component-code-value-quantity";
                    case "component.code":
                        return "component-code";
                    case "component.dataAbsentReason":
                        return "component-data-absent-reason";
                    case "dataAbsentReason":
                        return "data-absent-reason";
                    case "derivedFrom":
                        return "derived-from";
                    case "device":
                        return "device";
                    case "focus":
                        return "focus";
                    case "hasMember":
                        return "has-member";
                    case "method":
                        return "method";
                    case "partOf":
                        return "part-of";
                    case "performer":
                        return "performer";
                    case "specimen":
                        return "specimen";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "OperationDefinition":
                switch (path) {
                    case "base":
                        return "base";
                    case "code":
                        return "code";
                    case "inputProfile":
                        return "input-profile";
                    case "instance":
                        return "instance";
                    case "kind":
                        return "kind";
                    case "outputProfile":
                        return "output-profile";
                    case "system":
                        return "system";
                    case "type":
                        return "type";
                }
                break;
            case "Organization":
                switch (path) {
                    case "active":
                        return "active";
                    case "address.city":
                        return "address-city";
                    case "address.country":
                        return "address-country";
                    case "address.postalCode":
                        return "address-postalcode";
                    case "address.state":
                        return "address-state";
                    case "address.use":
                        return "address-use";
                    case "address":
                        return "address";
                    case "endpoint":
                        return "endpoint";
                    case "identifier":
                        return "identifier";
                    case "name | Organization.alias":
                        return "name";
                    case "partOf":
                        return "partof";
                    case "name":
                        return "phonetic";
                    case "type":
                        return "type";
                }
                break;
            case "OrganizationAffiliation":
                switch (path) {
                    case "active":
                        return "active";
                    case "period":
                        return "date";
                    case "telecom.where(system='email')":
                        return "email";
                    case "endpoint":
                        return "endpoint";
                    case "identifier":
                        return "identifier";
                    case "location":
                        return "location";
                    case "network":
                        return "network";
                    case "participatingOrganization":
                        return "participating-organization";
                    case "telecom.where(system='phone')":
                        return "phone";
                    case "organization":
                        return "primary-organization";
                    case "code":
                        return "role";
                    case "healthcareService":
                        return "service";
                    case "specialty":
                        return "specialty";
                    case "telecom":
                        return "telecom";
                }
                break;
            case "Patient":
                switch (path) {
                    case "active":
                        return "active";
                    case "deceased.exists() and Patient.deceased != false":
                        return "deceased";
                    case "generalPractitioner":
                        return "general-practitioner";
                    case "identifier":
                        return "identifier";
                    case "communication.language":
                        return "language";
                    case "link.other":
                        return "link";
                    case "name":
                        return "name";
                    case "managingOrganization":
                        return "organization";
                }
                break;
            case "PaymentNotice":
                switch (path) {
                    case "created":
                        return "created";
                    case "identifier":
                        return "identifier";
                    case "paymentStatus":
                        return "payment-status";
                    case "provider":
                        return "provider";
                    case "request":
                        return "request";
                    case "response":
                        return "response";
                    case "status":
                        return "status";
                }
                break;
            case "PaymentReconciliation":
                switch (path) {
                    case "created":
                        return "created";
                    case "disposition":
                        return "disposition";
                    case "identifier":
                        return "identifier";
                    case "outcome":
                        return "outcome";
                    case "paymentIssuer":
                        return "payment-issuer";
                    case "request":
                        return "request";
                    case "requestor":
                        return "requestor";
                    case "status":
                        return "status";
                }
                break;
            case "Person":
                switch (path) {
                    case "identifier":
                        return "identifier";
                    case "link.target":
                        return "link";
                    case "name":
                        return "name";
                    case "managingOrganization":
                        return "organization";
                    case "link.target.where(resolve() is Patient)":
                        return "patient";
                    case "link.target.where(resolve() is Practitioner)":
                        return "practitioner";
                    case "link.target.where(resolve() is RelatedPerson)":
                        return "relatedperson";
                }
                break;
            case "PlanDefinition":
                switch (path) {
                    case "relatedArtifact.where(type='composed-of').resource":
                        return "composed-of";
                    case "useContext":
                        return "context-type-quantity";
                    //case "useContext": return "context-type-value";
                    case "useContext.code":
                        return "context-type";
                    case "date":
                        return "date";
                    case "action.definition":
                        return "definition";
                    case "relatedArtifact.where(type='depends-on').resource | PlanDefinition.library":
                        return "depends-on";
                    case "relatedArtifact.where(type='derived-from').resource":
                        return "derived-from";
                    case "description":
                        return "description";
                    case "effectivePeriod":
                        return "effective";
                    case "identifier":
                        return "identifier";
                    case "jurisdiction":
                        return "jurisdiction";
                    case "name":
                        return "name";
                    case "relatedArtifact.where(type='predecessor').resource":
                        return "predecessor";
                    case "publisher":
                        return "publisher";
                    case "status":
                        return "status";
                    case "relatedArtifact.where(type='successor').resource":
                        return "successor";
                    case "title":
                        return "title";
                    case "topic":
                        return "topic";
                    case "type":
                        return "type";
                    case "url":
                        return "url";
                    case "version":
                        return "version";
                }
                break;
            case "Practitioner":
                switch (path) {
                    case "active":
                        return "active";
                    case "communication":
                        return "communication";
                    case "identifier":
                        return "identifier";
                    case "name":
                        return "name";
                }
                break;
            case "PractitionerRole":
                switch (path) {
                    case "active":
                        return "active";
                    case "period":
                        return "date";
                    case "endpoint":
                        return "endpoint";
                    case "identifier":
                        return "identifier";
                    case "location":
                        return "location";
                    case "organization":
                        return "organization";
                    case "practitioner":
                        return "practitioner";
                    case "code":
                        return "role";
                    case "healthcareService":
                        return "service";
                    case "specialty":
                        return "specialty";
                }
                break;
            case "Procedure":
                switch (path) {
                    case "basedOn":
                        return "based-on";
                    case "category":
                        return "category";
                    case "instantiatesCanonical":
                        return "instantiates-canonical";
                    case "instantiatesUri":
                        return "instantiates-uri";
                    case "location":
                        return "location";
                    case "partOf":
                        return "part-of";
                    case "performer.actor":
                        return "performer";
                    case "reasonCode":
                        return "reason-code";
                    case "reasonReference":
                        return "reason-reference";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "Provenance":
                switch (path) {
                    case "agent.role":
                        return "agent-role";
                    case "agent.type":
                        return "agent-type";
                    case "agent.who":
                        return "agent";
                    case "entity.what":
                        return "entity";
                    case "location":
                        return "location";
                    case "target.where(resolve() is Patient)":
                        return "patient";
                    case "recorded":
                        return "recorded";
                    case "signature.type":
                        return "signature-type";
                    case "target":
                        return "target";
                }
                break;
            case "Questionnaire":
                switch (path) {
                    case "item.code":
                        return "code";
                    case "useContext":
                        return "context-type-quantity";
                    //case "useContext": return "context-type-value";
                    case "useContext.code":
                        return "context-type";
                    case "date":
                        return "date";
                    case "item.definition":
                        return "definition";
                    case "description":
                        return "description";
                    case "effectivePeriod":
                        return "effective";
                    case "identifier":
                        return "identifier";
                    case "jurisdiction":
                        return "jurisdiction";
                    case "name":
                        return "name";
                    case "publisher":
                        return "publisher";
                    case "status":
                        return "status";
                    case "subjectType":
                        return "subject-type";
                    case "title":
                        return "title";
                    case "url":
                        return "url";
                    case "version":
                        return "version";
                }
                break;
            case "QuestionnaireResponse":
                switch (path) {
                    case "author":
                        return "author";
                    case "authored":
                        return "authored";
                    case "basedOn":
                        return "based-on";
                    case "encounter":
                        return "encounter";
                    case "identifier":
                        return "identifier";
                    case "partOf":
                        return "part-of";
                    case "subject.where(resolve() is Patient)":
                        return "patient";
                    case "questionnaire":
                        return "questionnaire";
                    case "source":
                        return "source";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "RelatedPerson":
                switch (path) {
                    case "active":
                        return "active";
                    case "identifier":
                        return "identifier";
                    case "name":
                        return "name";
                    case "patient":
                        return "patient";
                    case "relationship":
                        return "relationship";
                }
                break;
            case "RequestGroup":
                switch (path) {
                    case "author":
                        return "author";
                    case "authoredOn":
                        return "authored";
                    case "code":
                        return "code";
                    case "encounter":
                        return "encounter";
                    case "groupIdentifier":
                        return "group-identifier";
                    case "identifier":
                        return "identifier";
                    case "instantiatesCanonical":
                        return "instantiates-canonical";
                    case "instantiatesUri":
                        return "instantiates-uri";
                    case "intent":
                        return "intent";
                    case "action.participant":
                        return "participant";
                    case "subject.where(resolve() is Patient)":
                        return "patient";
                    case "priority":
                        return "priority";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "ResearchDefinition":
                switch (path) {
                    case "relatedArtifact.where(type='composed-of').resource":
                        return "composed-of";
                    case "useContext":
                        return "context-type-quantity";
                    //case "useContext": return "context-type-value";
                    case "useContext.code":
                        return "context-type";
                    case "date":
                        return "date";
                    case "relatedArtifact.where(type='depends-on').resource | ResearchDefinition.library":
                        return "depends-on";
                    case "relatedArtifact.where(type='derived-from').resource":
                        return "derived-from";
                    case "description":
                        return "description";
                    case "effectivePeriod":
                        return "effective";
                    case "identifier":
                        return "identifier";
                    case "jurisdiction":
                        return "jurisdiction";
                    case "name":
                        return "name";
                    case "relatedArtifact.where(type='predecessor').resource":
                        return "predecessor";
                    case "publisher":
                        return "publisher";
                    case "status":
                        return "status";
                    case "relatedArtifact.where(type='successor').resource":
                        return "successor";
                    case "title":
                        return "title";
                    case "topic":
                        return "topic";
                    case "url":
                        return "url";
                    case "version":
                        return "version";
                }
                break;
            case "ResearchElementDefinition":
                switch (path) {
                    case "relatedArtifact.where(type='composed-of').resource":
                        return "composed-of";
                    case "useContext":
                        return "context-type-quantity";
                    //case "useContext": return "context-type-value";
                    case "useContext.code":
                        return "context-type";
                    case "date":
                        return "date";
                    case "relatedArtifact.where(type='depends-on').resource | ResearchElementDefinition.library":
                        return "depends-on";
                    case "relatedArtifact.where(type='derived-from').resource":
                        return "derived-from";
                    case "description":
                        return "description";
                    case "effectivePeriod":
                        return "effective";
                    case "identifier":
                        return "identifier";
                    case "jurisdiction":
                        return "jurisdiction";
                    case "name":
                        return "name";
                    case "relatedArtifact.where(type='predecessor').resource":
                        return "predecessor";
                    case "publisher":
                        return "publisher";
                    case "status":
                        return "status";
                    case "relatedArtifact.where(type='successor').resource":
                        return "successor";
                    case "title":
                        return "title";
                    case "topic":
                        return "topic";
                    case "url":
                        return "url";
                    case "version":
                        return "version";
                }
                break;
            case "ResearchStudy":
                switch (path) {
                    case "category":
                        return "category";
                    case "period":
                        return "date";
                    case "focus":
                        return "focus";
                    case "identifier":
                        return "identifier";
                    case "keyword":
                        return "keyword";
                    case "location":
                        return "location";
                    case "partOf":
                        return "partof";
                    case "principalInvestigator":
                        return "principalinvestigator";
                    case "protocol":
                        return "protocol";
                    case "site":
                        return "site";
                    case "sponsor":
                        return "sponsor";
                    case "status":
                        return "status";
                    case "title":
                        return "title";
                }
                break;
            case "ResearchSubject":
                switch (path) {
                    case "period":
                        return "date";
                    case "identifier":
                        return "identifier";
                    case "individual":
                        return "individual";
                    //case "individual": return "patient";
                    case "status":
                        return "status";
                    case "study":
                        return "study";
                }
                break;
            case "Resource":
                switch (path) {
                    case "id":
                        return "_id";
                    case "meta.lastUpdated":
                        return "_lastUpdated";
                    case "meta.profile":
                        return "_profile";
                    case "meta.security":
                        return "_security";
                    case "meta.source":
                        return "_source";
                    case "meta.tag":
                        return "_tag";
                }
                break;
            case "RiskAssessment":
                switch (path) {
                    case "condition":
                        return "condition";
                    case "method":
                        return "method";
                    case "performer":
                        return "performer";
                    case "prediction.probability":
                        return "probability";
                    case "prediction.qualitativeRisk":
                        return "risk";
                    case "subject":
                        return "subject";
                }
                break;
            case "RiskEvidenceSynthesis":
                switch (path) {
                    case "useContext":
                        return "context-type-quantity";
                    //case "useContext": return "context-type-value";
                    case "useContext.code":
                        return "context-type";
                    case "date":
                        return "date";
                    case "description":
                        return "description";
                    case "effectivePeriod":
                        return "effective";
                    case "identifier":
                        return "identifier";
                    case "jurisdiction":
                        return "jurisdiction";
                    case "name":
                        return "name";
                    case "publisher":
                        return "publisher";
                    case "status":
                        return "status";
                    case "title":
                        return "title";
                    case "url":
                        return "url";
                    case "version":
                        return "version";
                }
                break;
            case "Schedule":
                switch (path) {
                    case "active":
                        return "active";
                    case "actor":
                        return "actor";
                    case "planningHorizon":
                        return "date";
                    case "identifier":
                        return "identifier";
                    case "serviceCategory":
                        return "service-category";
                    case "serviceType":
                        return "service-type";
                    case "specialty":
                        return "specialty";
                }
                break;
            case "SearchParameter":
                switch (path) {
                    case "base":
                        return "base";
                    case "code":
                        return "code";
                    case "component.definition":
                        return "component";
                    case "derivedFrom":
                        return "derived-from";
                    case "target":
                        return "target";
                    case "type":
                        return "type";
                }
                break;
            case "ServiceRequest":
                switch (path) {
                    case "authoredOn":
                        return "authored";
                    case "basedOn":
                        return "based-on";
                    case "bodySite":
                        return "body-site";
                    case "category":
                        return "category";
                    case "instantiatesCanonical":
                        return "instantiates-canonical";
                    case "instantiatesUri":
                        return "instantiates-uri";
                    case "intent":
                        return "intent";
                    case "occurrence":
                        return "occurrence";
                    case "performerType":
                        return "performer-type";
                    case "performer":
                        return "performer";
                    case "priority":
                        return "priority";
                    case "replaces":
                        return "replaces";
                    case "requester":
                        return "requester";
                    case "requisition":
                        return "requisition";
                    case "specimen":
                        return "specimen";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                }
                break;
            case "Slot":
                switch (path) {
                    case "appointmentType":
                        return "appointment-type";
                    case "identifier":
                        return "identifier";
                    case "schedule":
                        return "schedule";
                    case "serviceCategory":
                        return "service-category";
                    case "serviceType":
                        return "service-type";
                    case "specialty":
                        return "specialty";
                    case "start":
                        return "start";
                    case "status":
                        return "status";
                }
                break;
            case "Specimen":
                switch (path) {
                    case "accessionIdentifier":
                        return "accession";
                    case "collection.bodySite":
                        return "bodysite";
                    case "collection.collected":
                        return "collected";
                    case "collection.collector":
                        return "collector";
                    case "container.identifier":
                        return "container-id";
                    case "container.type":
                        return "container";
                    case "identifier":
                        return "identifier";
                    case "parent":
                        return "parent";
                    case "subject.where(resolve() is Patient)":
                        return "patient";
                    case "status":
                        return "status";
                    case "subject":
                        return "subject";
                    case "type":
                        return "type";
                }
                break;
            case "SpecimenDefinition":
                switch (path) {
                    case "typeTested.container.type":
                        return "container";
                    case "identifier":
                        return "identifier";
                    case "typeCollected":
                        return "type";
                }
                break;
            case "StructureDefinition":
                switch (path) {
                    case "abstract":
                        return "abstract";
                    case "snapshot.element.base.path | StructureDefinition.differential.element.base.path":
                        return "base-path";
                    case "baseDefinition":
                        return "base";
                    case "derivation":
                        return "derivation";
                    case "experimental":
                        return "experimental";
                    case "context":
                        return "ext-context";
                    case "keyword":
                        return "keyword";
                    case "kind":
                        return "kind";
                    case "snapshot.element.path | StructureDefinition.differential.element.path":
                        return "path";
                    case "type":
                        return "type";
                    case "snapshot.element.binding.valueSet":
                        return "valueset";
                }
                break;
            case "Subscription":
                switch (path) {
                    case "contact":
                        return "contact";
                    case "criteria":
                        return "criteria";
                    case "channel.payload":
                        return "payload";
                    case "status":
                        return "status";
                    case "channel.type":
                        return "type";
                    case "channel.endpoint":
                        return "url";
                }
                break;
            case "Substance":
                switch (path) {
                    case "category":
                        return "category";
                    case "code | (Substance.ingredient.substance as CodeableConcept)":
                        return "code";
                    case "instance.identifier":
                        return "container-identifier";
                    case "instance.expiry":
                        return "expiry";
                    case "identifier":
                        return "identifier";
                    case "instance.quantity":
                        return "quantity";
                    case "status":
                        return "status";
                }
                break;
            case "SubstanceSpecification":
                switch (path) {
                    case "code":
                        return "code";
                }
                break;
            case "SupplyDelivery":
                switch (path) {
                    case "receiver":
                        return "receiver";
                    case "status":
                        return "status";
                    case "supplier":
                        return "supplier";
                }
                break;
            case "SupplyRequest":
                switch (path) {
                    case "category":
                        return "category";
                    case "requester":
                        return "requester";
                    case "status":
                        return "status";
                    case "deliverTo":
                        return "subject";
                    case "supplier":
                        return "supplier";
                }
                break;
            case "Task":
                switch (path) {
                    case "authoredOn":
                        return "authored-on";
                    case "basedOn":
                        return "based-on";
                    case "businessStatus":
                        return "business-status";
                    case "code":
                        return "code";
                    case "encounter":
                        return "encounter";
                    case "focus":
                        return "focus";
                    case "groupIdentifier":
                        return "group-identifier";
                    case "identifier":
                        return "identifier";
                    case "intent":
                        return "intent";
                    case "lastModified":
                        return "modified";
                    case "owner":
                        return "owner";
                    case "partOf":
                        return "part-of";
                    case "for.where(resolve() is Patient)":
                        return "patient";
                    case "performerType":
                        return "performer";
                    case "executionPeriod":
                        return "period";
                    case "priority":
                        return "priority";
                    case "requester":
                        return "requester";
                    case "status":
                        return "status";
                    case "for":
                        return "subject";
                }
                break;
            case "TestReport":
                switch (path) {
                    case "identifier":
                        return "identifier";
                    case "issued":
                        return "issued";
                    case "participant.uri":
                        return "participant";
                    case "result":
                        return "result";
                    case "tester":
                        return "tester";
                    case "testScript":
                        return "testscript";
                }
                break;
            case "TestScript":
                switch (path) {
                    case "useContext":
                        return "context-type-quantity";
                    //case "useContext": return "context-type-value";
                    case "useContext.code":
                        return "context-type";
                    case "date":
                        return "date";
                    case "description":
                        return "description";
                    case "identifier":
                        return "identifier";
                    case "jurisdiction":
                        return "jurisdiction";
                    case "name":
                        return "name";
                    case "publisher":
                        return "publisher";
                    case "status":
                        return "status";
                    case "metadata.capability.description":
                        return "testscript-capability";
                    case "title":
                        return "title";
                    case "url":
                        return "url";
                    case "version":
                        return "version";
                }
                break;
            case "ValueSet":
                switch (path) {
                    case "expansion.contains.code | ValueSet.compose.include.concept.code":
                        return "code";
                    case "expansion.identifier":
                        return "expansion";
                    case "compose.include.system":
                        return "reference";
                }
                break;
            case "VerificationResult":
                switch (path) {
                    case "target":
                        return "target";
                }
                break;
            case "VisionPrescription":
                switch (path) {
                    case "dateWritten":
                        return "datewritten";
                    case "prescriber":
                        return "prescriber";
                    case "status":
                        return "status";
                }
                break;
        }

        return path.replace('.', '-').toLowerCase();
    }
}
