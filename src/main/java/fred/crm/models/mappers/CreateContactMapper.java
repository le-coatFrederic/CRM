package fred.crm.models.mappers;

import ch.qos.logback.core.net.SyslogOutputStream;
import fred.crm.models.Contact;
import fred.crm.models.Interaction;
import fred.crm.models.dtos.ContactDTO;
import fred.crm.models.dtos.CreateContactDTO;
import fred.crm.models.dtos.CreateInteractionDTO;
import fred.crm.repositories.CompanyRepository;
import fred.crm.repositories.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreateContactMapper {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CreateInteractionMapper createInteractionMapper;
    @Autowired
    private InteractionRepository interactionRepository;

    public Contact contactDTOToContact(CreateContactDTO contactDTO) {
        if (contactDTO == null) {
            return null;
        }

        List<Interaction> interactions = new ArrayList<>();
        for (CreateInteractionDTO createInteractionDTO: contactDTO.interactions()) {
            Interaction interaction = createInteractionMapper.interactionDTOToInteraction(createInteractionDTO);
            interactions.add(interactionRepository.save(interaction));
        }

        return new Contact(
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
                companyRepository.findById(contactDTO.company()).orElse(null),
                interactions
        );
    }
}
