package fred.crm.models.dtos;

import fred.crm.models.Company;
import fred.crm.models.CompanyContactsInformations;

import java.util.List;

public record CompanyContactsInformationsDTO(
    Long id,
    List<LocationDTO> locations,
    String email,
    String phone,
    String website,
    String linkedin,
    String twitter,
    String facebook,
    Long companyId
) {
    public static CompanyContactsInformationsDTO fromEntity(CompanyContactsInformations companyContactsInformations) {
        return new CompanyContactsInformationsDTO(
                companyContactsInformations.getId(),
                companyContactsInformations.getLocations() != null
                    ? companyContactsInformations.getLocations().stream()
                        .map(LocationDTO::fromEntity)
                        .toList()
                    : List.of(),
                companyContactsInformations.getEmail(),
                companyContactsInformations.getPhone(),
                companyContactsInformations.getWebsite(),
                companyContactsInformations.getLinkedin(),
                companyContactsInformations.getTwitter(),
                companyContactsInformations.getFacebook(),
                companyContactsInformations.getCompany().getId()
        );
    }

    public Company toEntity() {
        return new Company(
                this.locations.forEach(dto -> dto.toEntity()),
                this.email,
                this.phone,
                this.website,
                this.linkedin,
                this.twitter,
                this.facebook

        );
    }
}
