package fred.crm.models.mappers;

import fred.crm.models.Interaction;
import fred.crm.models.dtos.CreateInteractionDTO;
import fred.crm.models.dtos.InteractionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateInteractionMapper {
    @Autowired
    private ContactMapper contactMapper;

    public CreateInteractionDTO interactionToInteractionDTO(Interaction interaction) {
        return new CreateInteractionDTO(
                interaction.getStatus(),
                interaction.getStartTime(),
                interaction.getEndTime(),
                interaction.getType(),
                interaction.getSubject(),
                interaction.getObjectives(),
                interaction.getPrivateNotes(),
                interaction.getConclusion(),
                this.interactionToInteractionDTO(interaction.getNextInteraction()),
                this.interactionToInteractionDTO(interaction.getPreviousInteraction()),
                this.contactMapper.contactToContactDTO(interaction.getContact())
        );
    }

    public Interaction interactionDTOToInteraction(CreateInteractionDTO interactionDTO) {
        return new Interaction(
                interactionDTO.status(),
                interactionDTO.startTime(),
                interactionDTO.endTime(),
                interactionDTO.type(),
                interactionDTO.subject(),
                interactionDTO.objectives(),
                interactionDTO.privateNotes(),
                interactionDTO.conclusion(),
                this.interactionDTOToInteraction(interactionDTO.nextInteraction()),
                this.interactionDTOToInteraction(interactionDTO.previousInteraction()),
                this.contactMapper.contactDTOToContact(interactionDTO.contact())
        );
    }
}
