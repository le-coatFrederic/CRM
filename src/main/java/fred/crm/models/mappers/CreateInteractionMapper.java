package fred.crm.models.mappers;

import fred.crm.models.Contact;
import fred.crm.models.Interaction;
import fred.crm.models.dtos.CreateInteractionDTO;
import fred.crm.models.dtos.InteractionDTO;
import fred.crm.repositories.ContactRepository;
import fred.crm.repositories.InteractionRepository;
import fred.crm.services.ContactCRUDService;
import fred.crm.services.InteractionCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateInteractionMapper {
    @Autowired
    private InteractionCRUDService interactionCRUDService;
    @Autowired
    private ContactCRUDService contactCRUDService;

    public Interaction interactionDTOToInteraction(CreateInteractionDTO interactionDTO) {
        Interaction nextInteraction = interactionDTO.nextInteraction() != null ? this.interactionCRUDService.findById(interactionDTO.nextInteraction()) : null;
        Interaction previousInteraction = interactionDTO.previousInteraction() != null ? this.interactionCRUDService.findById(interactionDTO.previousInteraction()) : null;
        Contact contact = interactionDTO.contact() != null ? this.contactCRUDService.findById(interactionDTO.contact()) : null;

        return new Interaction(
                interactionDTO.status(),
                interactionDTO.startTime(),
                interactionDTO.endTime(),
                interactionDTO.type(),
                interactionDTO.subject(),
                interactionDTO.objectives(),
                interactionDTO.privateNotes(),
                interactionDTO.conclusion(),
                nextInteraction,
                previousInteraction,
                contact
        );
    }
}
