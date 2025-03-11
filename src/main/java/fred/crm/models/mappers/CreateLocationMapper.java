package fred.crm.models.mappers;

import fred.crm.models.Location;
import fred.crm.models.dtos.CreateLocationDTO;
import fred.crm.models.dtos.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateLocationMapper {
    @Autowired
    private CompanyMapper companyMapper;

    public CreateLocationDTO locationToLocationDTO(Location location) {
        return new CreateLocationDTO(
                location.getAddress1(),
                location.getAddress2(),
                location.getCity(),
                location.getZipCode(),
                location.getState(),
                location.getCountry(),
                this.companyMapper.companyToCompanyDTO(location.getCompany())
        );
    }

    public Location locationDTOToLocation(CreateLocationDTO locationDTO) {
        return new Location(
                locationDTO.address1(),
                locationDTO.address2(),
                locationDTO.city(),
                locationDTO.zipcode(),
                locationDTO.state(),
                locationDTO.country(),
                this.companyMapper.companyDTOToCompany(locationDTO.company())
        );
    }
}
