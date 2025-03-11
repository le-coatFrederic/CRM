package fred.crm.models.dtos;


import fred.crm.models.values.InteractionConclusion;
import fred.crm.models.values.InteractionStatus;
import fred.crm.models.values.InteractionType;

import java.sql.Time;

public record CreateInteractionDTO(
        InteractionStatus status,
        Time startTime,
        Time endTime,
        InteractionType type,
        String subject,
        String objectives,
        String privateNotes,
        InteractionConclusion conclusion,
        CreateInteractionDTO nextInteraction,
        CreateInteractionDTO previousInteraction,
        ContactDTO contact
) {
}