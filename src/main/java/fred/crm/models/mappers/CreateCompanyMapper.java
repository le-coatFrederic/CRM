package fred.crm.models.mappers;

import fred.crm.models.Company;
import fred.crm.models.Contact;
import fred.crm.models.Location;
import fred.crm.models.dtos.ContactDTO;
import fred.crm.models.dtos.CreateCompanyDTO;
import fred.crm.models.dtos.LocationDTO;
import fred.crm.repositories.ContactRepository;
import fred.crm.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateCompanyMapper {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private LocationRepository locationRepository;

    public Company companyDTOToCompany(CreateCompanyDTO companyDTO) {
        List<Contact> contacts = new ArrayList<>();
        List<Location> locations = new ArrayList<>();

        for (Long contactId: companyDTO.contacts()) {
            contacts.add(contactRepository.findById(contactId).orElse(null));
        }

        for (Long locationId: companyDTO.locations()) {
            locations.add(locationRepository.findById(locationId).orElse(null));
        }

        return new Company(
                companyDTO.name(),
                companyDTO.SIRET(),
                companyDTO.tvaNumber(),
                companyDTO.juridicalStructure(),
                companyDTO.creationDate(),
                companyDTO.capital(),
                companyDTO.activitySector(),
                companyDTO.secondarySector(),
                companyDTO.activityDescription(),
                companyDTO.keywords(),
                companyDTO.marketTarget(),
                companyDTO.importance(),
                companyDTO.region(),
                companyDTO.maturity(),
                companyDTO.email(),
                companyDTO.phone(),
                companyDTO.website(),
                companyDTO.linkedin(),
                companyDTO.twitter(),
                companyDTO.facebook(),
                companyDTO.comments(),
                contacts,
                locations,
                companyDTO.mainColor(),
                companyDTO.secondaryColor()
        );
    }
}
