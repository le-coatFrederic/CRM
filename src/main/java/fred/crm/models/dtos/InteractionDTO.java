package fred.crm.models.dtos;


import fred.crm.models.values.InteractionConclusion;
import fred.crm.models.values.InteractionStatus;
import fred.crm.models.values.InteractionType;

import java.sql.Time;
import java.sql.Timestamp;

public record InteractionDTO(
        Long id,
        InteractionStatus status,
        Timestamp startTime,
        Timestamp endTime,
        InteractionType type,
        String subject,
        String objectives,
        String privateNotes,
        InteractionConclusion conclusion,
        Long nextInteraction,
        Long previousInteraction,
        ContactDTO contact
) {
}