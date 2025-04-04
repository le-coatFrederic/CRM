package fred.crm.models.mappers;

import fred.crm.models.Location;
import fred.crm.models.dtos.CreateLocationDTO;
import fred.crm.models.dtos.LocationDTO;
import fred.crm.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateLocationMapper {
    @Autowired
    private CompanyRepository companyRepository;

    public Location locationDTOToLocation(CreateLocationDTO locationDTO) {
        return new Location(
                locationDTO.address1(),
                locationDTO.address2(),
                locationDTO.city(),
                locationDTO.zipcode(),
                locationDTO.state(),
                locationDTO.country(),
                this.companyRepository.findById(locationDTO.company()).orElse(null)
        );
    }
}
