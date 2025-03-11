package fred.crm.models.mappers;

import fred.crm.models.Company;
import fred.crm.models.dtos.CreateCompanyDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateCompanyMapper {
    public CreateCompanyDTO companyToCompanyDTO(Company company) {
        return new CreateCompanyDTO(
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
                company.getEmail(),
                company.getPhone(),
                company.getWebsite(),
                company.getLinkedin(),
                company.getTwitter(),
                company.getFacebook(),
                company.getComments(),
                company.getMainColor(),
                company.getSecondaryColor()
        );
    }

    public Company companyDTOToCompany(CreateCompanyDTO companyDTO) {
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
                null,
                null,
                companyDTO.mainColor(),
                companyDTO.secondaryColor()
        );
    }
}
