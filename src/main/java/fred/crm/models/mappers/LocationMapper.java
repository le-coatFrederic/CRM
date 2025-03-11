package fred.crm.models.mappers;

import fred.crm.models.Location;
import fred.crm.models.dtos.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {
    @Autowired
    private CompanyMapper companyMapper;

    public LocationDTO locationToLocationDTO(Location location) {
        return new LocationDTO(
                location.getId(),
                location.getAddress1(),
                location.getAddress2(),
                location.getCity(),
                location.getZipCode(),
                location.getState(),
                location.getCountry(),
                this.companyMapper.companyToCompanyDTO(location.getCompany())
        );
    }

    public Location locationDTOToLocation(LocationDTO locationDTO) {
        return new Location(
                locationDTO.id(),
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
