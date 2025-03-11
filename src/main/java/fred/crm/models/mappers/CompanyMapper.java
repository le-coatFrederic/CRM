package fred.crm.models.mappers;

import fred.crm.models.Company;
import fred.crm.models.dtos.CompanyDTO;
import fred.crm.models.values.Importance;
import fred.crm.models.values.Maturity;
import fred.crm.models.values.Region;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class CompanyMapper {
    public CompanyDTO companyToCompanyDTO(Company company) {
        if (company == null) {
            return null;
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

    public Company companyDTOToCompany(CompanyDTO companyDTO) {

        if (companyDTO == null) {
            return null;
        }

        return new Company(
                companyDTO.id(),
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
                companyDTO.mainColor(),
                companyDTO.secondaryColor(),
                null,
                null
        );
    }
}
