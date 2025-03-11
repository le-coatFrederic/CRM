package fred.crm.models.mappers;

import fred.crm.models.Contact;
import fred.crm.models.dtos.ContactDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactMapper {
    @Autowired
    private CompanyMapper companyMapper;

    public ContactDTO contactToContactDTO(Contact contact) {
        if (contact == null) {
            return null;
        }

        return new ContactDTO(
                contact.getId(),
                contact.getFirstname(),
                contact.getLastname(),
                contact.getJob(),
                contact.getDepartment(),
                contact.getDateJoinedCompany(),
                contact.getEmail(),
                contact.getPhone(),
                contact.getLinkedinLink(),
                contact.getYoutubeLink(),
                contact.getMeetingCanal(),
                contact.getRelationState(),
                contact.getLanguage(),
                contact.getCanalPreferred(),
                contact.getContactHours(),
                contact.getNotes(),
                companyMapper.companyToCompanyDTO(contact.getCompany())
        );
    }

    public Contact contactDTOToContact(ContactDTO contactDTO) {
        if (contactDTO == null) {
            return null;
        }

        return new Contact(
                contactDTO.id(),
                contactDTO.firstname(),
                contactDTO.lastname(),
                contactDTO.job(),
                contactDTO.department(),
                contactDTO.dateJoinedCompany(),
                contactDTO.email(),
                contactDTO.phone(),
                contactDTO.linkedinLink(),
                contactDTO.youtubeLink(),
                contactDTO.meetingCanal(),
                contactDTO.relationState(),
                contactDTO.language(),
                contactDTO.canalPreferred(),
                contactDTO.contactHours(),
                contactDTO.notes(),
                companyMapper.companyDTOToCompany(contactDTO.company()),
                null
        );
    }
}
