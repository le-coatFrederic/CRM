package fred.crm.models.dtos;

import fred.crm.models.Contact;

import java.sql.Date;
import java.util.List;

public record ContactDTO (
    Long id,
    String firstname,
    String lastname,
    String job,
    String department,
    Date dateJoinedCompany,
    ContactSocialDTO contactSocial,
    ContactTastesDTO contactTastes,
    CompanyDTO company,
    List<InteractionDTO> interactions
) {
    public static ContactDTO fromEntity(Contact contact) {
        ContactSocialDTO contactSocial = null;
        ContactTastesDTO contactTastes = null;
        CompanyDTO company = null;

        if (contact.getContactSocial() != null) {
            contactSocial = ContactSocialDTO.fromEntity(contact.getContactSocial());
        }

        if (contact.getContactTastes() != null) {
            contactTastes = ContactTastesDTO.fromEntity(contact.getContactTastes());
        }

        if (contact.getCompany() != null) {
            company = CompanyDTO.fromEntity(contact.getCompany());
        }

        return new ContactDTO(
                contact.getId(),
                contact.getFirstname(),
                contact.getLastname(),
                contact.getJob(),
                contact.getDepartment(),
                contact.getDateJoinedCompany(),
                contactSocial,
                contactTastes,
                company,
                contact.getInteractions() != null
                    ? contact.getInteractions().stream()
                    .map(InteractionDTO::fromEntity)
                    .toList()
                    : List.of()
        );
    }
}
