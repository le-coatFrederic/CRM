package fred.crm.models.mappers;

import fred.crm.models.Interaction;
import fred.crm.models.dtos.InteractionDTO;
import fred.crm.services.InteractionCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InteractionMapper {
    @Autowired
    private ContactMapper contactMapper;
    @Autowired
    private InteractionCRUDService interactionCRUDService;

    public InteractionDTO interactionToInteractionDTO(Interaction interaction) {
        if (interaction == null) {
            return null;
        }

        Long nextInteractionId = interaction.getNextInteraction() != null ? interaction.getNextInteraction().getId() : null;
        Long previousInteractionId = interaction.getPreviousInteraction() != null ? interaction.getPreviousInteraction().getId() : null;

        return new InteractionDTO(
                interaction.getId(),
                interaction.getStatus(),
                interaction.getStartTime(),
                interaction.getEndTime(),
                interaction.getType(),
                interaction.getSubject(),
                interaction.getObjectives(),
                interaction.getPrivateNotes(),
                interaction.getConclusion(),
                nextInteractionId,
                previousInteractionId,
                this.contactMapper.contactToContactDTO(interaction.getContact())
        );
    }

    public Interaction interactionDTOToInteraction(InteractionDTO interactionDTO) {
        if (interactionDTO == null) {
            return null;
        }

        return new Interaction(
                interactionDTO.id(),
                interactionDTO.status(),
                interactionDTO.startTime(),
                interactionDTO.endTime(),
                interactionDTO.type(),
                interactionDTO.subject(),
                interactionDTO.objectives(),
                interactionDTO.privateNotes(),
                interactionDTO.conclusion(),
                this.interactionCRUDService.findById(interactionDTO.nextInteraction()),
                this.interactionCRUDService.findById(interactionDTO.previousInteraction()),
                this.contactMapper.contactDTOToContact(interactionDTO.contact())
        );
    }
}
