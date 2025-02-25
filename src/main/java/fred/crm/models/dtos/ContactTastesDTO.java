package fred.crm.models.dtos;

import fred.crm.models.ContactTastes;
import fred.crm.models.values.SocialMedia;

public record ContactTastesDTO(
        Long id,
        String language,
        SocialMedia canalPreferred,
        String contactHours,
        String notes,
        Long contactId
) {
    public static ContactTastesDTO fromEntity(ContactTastes contactTastes) {
        return new ContactTastesDTO(
                contactTastes.getId(),
                contactTastes.getLanguage(),
                contactTastes.getCanalPreferred(),
                contactTastes.getContactHours(),
                contactTastes.getNotes(),
                contactTastes.getContact().getId()
        );
    }
}
