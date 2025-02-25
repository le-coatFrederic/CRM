package fred.crm.models.dtos;

import fred.crm.models.Company;
import fred.crm.models.CompanyContactsInformations;
import fred.crm.models.values.Importance;
import fred.crm.models.values.Maturity;
import fred.crm.models.values.Region;
import jakarta.persistence.Enumerated;

import java.sql.Date;
import java.util.List;

public record CompanyDTO(
        Long id,
        String name,
        String siret,
        String tvaNumber,
        String juridicalStructure,
        Date creationDate,
        double capital,
        String activitySector,
        String secondarySector,
        String activityDescription,
        String keywords,
        String marketTarget,
        Importance importance,
        Region region,
        Maturity maturity,
        String comments,
        CompanyContactsInformationsDTO contactsInformations,
        List<ContactDTO> contacts
) {
    public static CompanyDTO fromEntity(Company company) {
        CompanyContactsInformationsDTO companyContactsInformationsDTO = null;
        if (company.getCompanyContactsInformations() != null) {
            companyContactsInformationsDTO = CompanyContactsInformationsDTO.fromEntity(company.getCompanyContactsInformations());
        }

        return new CompanyDTO(
                company.getId(),
                company.getName(),
                company.getSIRET(),
                company.getTvaNumber(),
                company.getJuridicalStructure(),
                company.getCreationDate(),
                company.getCapital(),
                company.getActivitySector(),
                company.getSecondarySector(),
                company.getActivityDescription(),
                company.getKeywords(),
                company.getMarketTarget(),
                company.getImportance(),
                company.getRegion(),
                company.getMaturity(),
                company.getComments(),
                companyContactsInformationsDTO,
                company.getContacts() != null
                    ? company.getContacts().stream()
                        .map(ContactDTO::fromEntity)
                        .toList()
                    : List.of()
        );
    }
}
