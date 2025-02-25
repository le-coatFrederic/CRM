package fred.crm.models.dtos;

import fred.crm.models.Interaction;
import fred.crm.models.values.InteractionConclusion;
import fred.crm.models.values.InteractionStatus;
import fred.crm.models.values.InteractionType;

import java.sql.Time;

public record InteractionDTO(
    Long id,
    Long contactId,
    InteractionStatus status,
    Time startTime,
    Time endTime,
    InteractionType type,
    String subject,
    String objectives,
    String privateNotes,
    InteractionConclusion conclusion,
    Time nextDate
) {
    public static InteractionDTO fromEntity(Interaction interaction) {
        return new InteractionDTO(
                interaction.getId(),
                interaction.getContact().getId(),
                interaction.getStatus(),
                interaction.getstartTime(),
                interaction.getEndTime(),
                interaction.getType(),
                interaction.getSubject(),
                interaction.getObjectives(),
                interaction.getPrivateNotes(),
                interaction.getConclusion(),
                interaction.getNextDate()
        );
    }
}
