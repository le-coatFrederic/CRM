package fred.crm.models.dtos;

import fred.crm.models.ContactSocial;
import fred.crm.models.values.RelationState;
import fred.crm.models.values.SocialMedia;

public record ContactSocialDTO(
        Long id,
        String email,
        String phone,
        String linkedinLink,
        String youtubeLink,
        SocialMedia meetingCanal,
        RelationState relationState,
        String notes,
        Long contactId
) {
    public static ContactSocialDTO fromEntity(ContactSocial contactSocial) {
        return new ContactSocialDTO(
                contactSocial.getId(),
                contactSocial.getEmail(),
                contactSocial.getPhone(),
                contactSocial.getLinkedinLink(),
                contactSocial.getYoutubeLink(),
                contactSocial.getMeetingCanal(),
                contactSocial.getRelationState(),
                contactSocial.getNotes(),
                contactSocial.getContact().getId()
        );
    }
}
