package org.opencds.cqf.cds.discovery;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.*;
import org.opencds.cqf.cds.helpers.CanonicalHelper;

import java.util.ArrayList;
import java.util.List;

public class DiscoveryResolutionR4 {

    private final String PATIENT_ID_CONTEXT = "{{context.patientId}}";
    private final int URI_MAX_LENGTH = 8000;

    private IGenericClient client;

    public DiscoveryResolutionR4(IGenericClient client) {
        this.client = client;
    }

    public PlanDefinition resolvePlanDefinition(Bundle.BundleEntryComponent component) {
        if (component.hasResource() && (component.getResource() instanceof PlanDefinition)) {
            return (PlanDefinition) component.getResource();
        }
        return null;
    }

    public boolean isEca(PlanDefinition planDefinition) {
        if (planDefinition.hasType() && planDefinition.getType().hasCoding()) {
            for (Coding coding : planDefinition.getType().getCoding()) {
                if (coding.getCode().equals("eca-rule")) {
                    return true;
                }
            }
        }
        return false;
    }

    public Library resolvePrimaryLibrary(PlanDefinition planDefinition) {
        // Assuming 1 library
        // TODO: enhance to handle multiple libraries - need a way to identify primary library
        if (planDefinition.hasLibrary() && !planDefinition.getLibrary().isEmpty()) {
            return (Library) client.read()
                    .resource("Library")
                    .withId(new IdType(CanonicalHelper.getId(planDefinition.getLibrary().get(0))))
                    .execute();
        }
        return null;
    }

    public List<String> resolveValueSetCodes(String valueSetId) {
        Bundle bundle = (Bundle) client.search().forResource("ValueSet").where(ValueSet.URL.matches().value(valueSetId)).execute();
        if (bundle == null) {
            // TODO: report missing terminology
            return null;
        }
        List<String> ret = new ArrayList<>();
        StringBuilder codes = new StringBuilder();
        if (bundle.hasEntry() && bundle.getEntry().size() == 1) {
            if (bundle.getEntry().get(0).hasResource() && bundle.getEntry().get(0).getResource() instanceof ValueSet) {
                ValueSet valueSet = (ValueSet) bundle.getEntry().get(0).getResource();
                if (valueSet.hasCompose() && valueSet.getCompose().hasInclude()) {
                    for (ValueSet.ConceptSetComponent concepts : valueSet.getCompose().getInclude()) {
                        String system = concepts.getSystem();
                        if (concepts.hasConcept()) {
                            for (ValueSet.ConceptReferenceComponent concept : concepts.getConcept()) {
                                String codeToken = system + "|" + concept.getCode();
                                if (codes.length() > 0) {
                                    codes.append(",");
                                }
                                else if ((codes.length() + codeToken.length()) > URI_MAX_LENGTH) {
                                    ret.add(codes.toString());
                                    codes = new StringBuilder();
                                }
                                codes.append(codeToken);
                            }
                        }
                    }
                }
            }
        }
        ret.add(codes.toString());
        return ret;
    }

    public List<String> createRequestUrl(DataRequirement dataRequirement) {
        if (!isPatientCompartment(dataRequirement.getType())) return null;
        String patientRelatedResource = dataRequirement.getType() + "?" + getPatientSearchParam(dataRequirement.getType()) + "=" + PATIENT_ID_CONTEXT;
        List<String> ret = new ArrayList<>();
        if (dataRequirement.hasCodeFilter()) {
            for (DataRequirement.DataRequirementCodeFilterComponent codeFilterComponent : dataRequirement.getCodeFilter()) {
                if (!codeFilterComponent.hasPath()) continue;
                String path = mapCodePathToSearchParam(dataRequirement.getType(), codeFilterComponent.getPath());
                if (codeFilterComponent.hasValueSetElement()) {
                    for (String codes : resolveValueSetCodes(codeFilterComponent.getValueSetElement().getId())) {
                        ret.add(patientRelatedResource + "&" + path + "=" + codes);
                    }
                }
            }
            return ret;
        }
        else {
            ret.add(patientRelatedResource);
            return ret;
        }
    }

    public PrefetchUrlList getPrefetchUrlList(PlanDefinition planDefinition) {
        PrefetchUrlList prefetchList = new PrefetchUrlList();
        if (planDefinition == null) return null;
        if (!isEca(planDefinition)) return null;
        Library library = resolvePrimaryLibrary(planDefinition);
        // TODO: resolve data requirements
        if (!library.hasDataRequirement()) return null;
        for (DataRequirement dataRequirement : library.getDataRequirement()) {
            List<String> requestUrls = createRequestUrl(dataRequirement);
            if (requestUrls != null) {
                prefetchList.addAll(requestUrls);
            }
        }
        return prefetchList;
    }

    public DiscoveryResponse resolve() {
        Bundle bundle = (Bundle) client.search().forResource("PlanDefinition").execute();
        DiscoveryResponse response = new DiscoveryResponse();
        if (bundle.hasEntry() && bundle.getEntry().size() > 0) {
            for (Bundle.BundleEntryComponent component : bundle.getEntry()) {
                PlanDefinition planDefinition = resolvePlanDefinition(component);
                response.addElement(
                        new DiscoveryElementR4(planDefinition, getPrefetchUrlList(planDefinition))
                );
            }
        }

        return response;
    }

    private String mapCodePathToSearchParam(String dataType, String path) {
        switch (dataType) {
            case "MedicationAdministration":
                if (path.equals("medication")) return "code";
                break;
            case "MedicationDispense":
                if (path.equals("medication")) return "code";
                break;
            case "MedicationRequest":
                if (path.equals("medication")) return "code";
                break;
            case "MedicationStatement":
                if (path.equals("medication")) return "code";
                break;
            case "ProcedureRequest":
                if (path.equals("bodySite")) return "body-site";
                break;
            default:
                if (path.equals("vaccineCode")) return "vaccine-code";
                break;
        }
        return path.replace('.', '-').toLowerCase();
    }

    public static boolean isPatientCompartment(String dataType) {
        switch (dataType) {
            case "Account":
            case "AdverseEvent":
            case "AllergyIntolerance":
            case "Appointment":
            case "AppointmentResponse":
            case "AuditEvent":
            case "Basic":
            case "BodySite":
            case "CarePlan":
            case "CareTeam":
            case "ChargeItem":
            case "Claim":
            case "ClaimResponse":
            case "ClinicalImpression":
            case "Communication":
            case "CommunicationRequest":
            case "Composition":
            case "Condition":
            case "Consent":
            case "Coverage":
            case "DetectedIssue":
            case "DeviceRequest":
            case "DeviceUseStatement":
            case "DiagnosticReport":
            case "DocumentManifest":
            case "EligibilityRequest":
            case "Encounter":
            case "EnrollmentRequest":
            case "EpisodeOfCare":
            case "ExplanationOfBenefit":
            case "FamilyMemberHistory":
            case "Flag":
            case "Goal":
            case "Group":
            case "ImagingManifest":
            case "ImagingStudy":
            case "Immunization":
            case "ImmunizationRecommendation":
            case "List":
            case "MeasureReport":
            case "Media":
            case "MedicationAdministration":
            case "MedicationDispense":
            case "MedicationRequest":
            case "MedicationStatement":
            case "NutritionOrder":
            case "Observation":
            case "Patient":
            case "Person":
            case "Procedure":
            case "ProcedureRequest":
            case "Provenance":
            case "QuestionnaireResponse":
            case "ReferralRequest":
            case "RelatedPerson":
            case "RequestGroup":
            case "ResearchSubject":
            case "RiskAssessment":
            case "Schedule":
            case "Specimen":
            case "SupplyDelivery":
            case "SupplyRequest":
            case "VisionPrescription": return true;
            default: return false;
        }
    }

    public String getPatientSearchParam(String dataType) {
        switch (dataType) {
            case "Account":
                return "subject";
            case "AdverseEvent":
                return "subject";
            case "AllergyIntolerance":
                return "patient";
            case "Appointment":
                return "actor";
            case "AppointmentResponse":
                return "actor";
            case "AuditEvent":
                return "patient";
            case "Basic":
                return "patient";
            case "BodySite":
                return "patient";
            case "CarePlan":
                return "patient";
            case "CareTeam":
                return "patient";
            case "ChargeItem":
                return "subject";
            case "Claim":
                return "patient";
            case "ClaimResponse":
                return "patient";
            case "ClinicalImpression":
                return "subject";
            case "Communication":
                return "subject";
            case "CommunicationRequest":
                return "subject";
            case "Composition":
                return "subject";
            case "Condition":
                return "patient";
            case "Consent":
                return "patient";
            case "Coverage":
                return "patient";
            case "DetectedIssue":
                return "patient";
            case "DeviceRequest":
                return "subject";
            case "DeviceUseStatement":
                return "subject";
            case "DiagnosticReport":
                return "subject";
            case "DocumentManifest":
                return "subject";
            case "DocumentReference":
                return "subject";
            case "EligibilityRequest":
                return "patient";
            case "Encounter":
                return "patient";
            case "EnrollmentRequest":
                return "subject";
            case "EpisodeOfCare":
                return "patient";
            case "ExplanationOfBenefit":
                return "patient";
            case "FamilyMemberHistory":
                return "patient";
            case "Flag":
                return "patient";
            case "Goal":
                return "patient";
            case "Group":
                return "member";
            case "ImagingManifest":
                return "patient";
            case "ImagingStudy":
                return "patient";
            case "Immunization":
                return "patient";
            case "ImmunizationRecommendation":
                return "patient";
            case "List":
                return "subject";
            case "MeasureReport":
                return "patient";
            case "Media":
                return "subject";
            case "MedicationAdministration":
                return "patient";
            case "MedicationDispense":
                return "patient";
            case "MedicationRequest":
                return "subject";
            case "MedicationStatement":
                return "subject";
            case "NutritionOrder":
                return "patient";
            case "Observation":
                return "subject";
            case "Patient":
                return "_id";
            case "Person":
                return "patient";
            case "Procedure":
                return "patient";
            case "ProcedureRequest":
                return "patient";
            case "Provenance":
                return "patient";
            case "QuestionnaireResponse":
                return "subject";
            case "ReferralRequest":
                return "patient";
            case "RelatedPerson":
                return "patient";
            case "RequestGroup":
                return "subject";
            case "ResearchSubject":
                return "individual";
            case "RiskAssessment":
                return "subject";
            case "Schedule":
                return "actor";
            case "ServiceRequest":
                return "patient";
            case "Specimen":
                return "subject";
            case "SupplyDelivery":
                return "patient";
            case "SupplyRequest":
                return "subject";
            case "VisionPrescription":
                return "patient";
        }

        return null;
    }
}
