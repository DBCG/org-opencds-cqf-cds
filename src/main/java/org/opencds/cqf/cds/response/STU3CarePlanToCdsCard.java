package org.opencds.cqf.cds.response;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.parser.IParser;
import org.hl7.fhir.dstu3.model.*;

import java.util.ArrayList;
import java.util.List;

public class STU3CarePlanToCdsCard {

    public static List<CdsCard> convert(CarePlan carePlan) {
        List<CdsCard> cards = new ArrayList<>();

        for (CarePlan.CarePlanActivityComponent activity : carePlan.getActivity()) {
            if (activity.getReferenceTarget() != null && activity.getReferenceTarget() instanceof RequestGroup) {
                RequestGroup requestGroup = (RequestGroup) activity.getReferenceTarget();
                cards = convert(requestGroup);
            }
        }

        return cards;
    }

    private static List<CdsCard> convert(RequestGroup requestGroup) {
        List<CdsCard> cards = new ArrayList<>();

        // links
        List<CdsCard.Links> links = new ArrayList<>();
        if (requestGroup.hasExtension()) {
            for (Extension extension : requestGroup.getExtension()) {
                CdsCard.Links link = new CdsCard.Links();

                if (extension.getValue() instanceof Attachment) {
                    Attachment attachment = (Attachment) extension.getValue();
                    if (attachment.hasUrl()) {
                        link.setUrl(attachment.getUrl());
                    }
                    if (attachment.hasTitle()) {
                        link.setLabel(attachment.getTitle());
                    }
                    if (attachment.hasExtension()) {
                        link.setType(attachment.getExtensionFirstRep().getValue().primitiveValue());
                    }
                }

                else {
                    throw new RuntimeException("Invalid link extension type: " + extension.getValue().fhirType());
                }

                links.add(link);
            }
        }

        if (requestGroup.hasAction()) {
            for (RequestGroup.RequestGroupActionComponent action : requestGroup.getAction()) {
                IParser jsonParser = FhirContext.forCached(FhirVersionEnum.DSTU3).newJsonParser().setPrettyPrint(true);
                CdsCard card = new CdsCard(jsonParser);
                // basic
                if (action.hasTitle()) {
                    card.setSummary(action.getTitle());
                }
                if (action.hasDescription()) {
                    card.setDetail(action.getDescription());
                }
                if (action.hasExtension()) {
                    card.setIndicator(action.getExtensionFirstRep().getValue().toString());
                }

                // source
                if (action.hasDocumentation()) {
                    // Assuming first related artifact has everything
                    RelatedArtifact documentation = action.getDocumentationFirstRep();
                    CdsCard.Source source = new CdsCard.Source();
                    if (documentation.hasDisplay()) {
                        source.setLabel(documentation.getDisplay());
                    }
                    if (documentation.hasUrl()) {
                        source.setUrl(documentation.getUrl());
                    }
                    if (documentation.hasDocument() && documentation.getDocument().hasUrl()) {
                        source.setIcon(documentation.getDocument().getUrl());
                    }

                    card.setSource(source);
                }

                if (action.hasSelectionBehavior()) {
                    card.setSelectionBehavior(action.getSelectionBehavior().toCode());
                }

                // suggestions
                // TODO - uuid
                boolean hasSuggestions = false;
                CdsCard.Suggestions suggestions = new CdsCard.Suggestions();
                CdsCard.Suggestions.Action actions = new CdsCard.Suggestions.Action();
                if (action.hasLabel()) {
                    suggestions.setLabel(action.getLabel());
                    hasSuggestions = true;
                    if (action.hasDescription()) {
                        actions.setDescription(action.getDescription());
                    }
                    if (action.hasType() && !action.getType().getCode().equals("fire-event")) {
                        String code = action.getType().getCode();
                        actions.setType(CdsCard.Suggestions.Action.ActionType.valueOf(code.equals("remove") ? "delete" : code));
                    }
                    if (action.hasResource()) {
                        if (actions.getType().name().equalsIgnoreCase("create")) {
                            action.getResourceTarget().setId((String)null);
                        }
                        actions.setResource(action.getResourceTarget());
                    }
                }
                if (hasSuggestions) {
                    suggestions.addAction(actions);
                    card.addSuggestion(suggestions);
                }
                if (!links.isEmpty()) {
                    card.setLinks(links);
                }
                cards.add(card);
            }
        }

        return cards;
    }
}
