package fred.crm.models.mappers;

import fred.crm.models.Company;
import fred.crm.models.dtos.CompanyDTO;
import fred.crm.models.values.Importance;
import fred.crm.models.values.Maturity;
import fred.crm.models.values.Region;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyMapperTest {
    @Autowired
    private CompanyMapper companyMapper;

    @Test
    public void testMapping() {
        Company company = new Company(
                "Company Test",
                "SIRET Test",
                "TvaNumber Test",
                "Juridical Test",
                new Date(12344),
                1211122,
                "Activity Test",
                "Secondary activity Test",
                "Description Test",
                "KeyWord Test",
                "Market Test",
                Importance.LOW,
                Region.REGIONAL,
                Maturity.COLD,
                "test@mail.com",
                "phone test",
                "website test",
                "linkedin test",
                "twitter test",
                "facebook test",
                "comments test",
                null,
                null,
                "main color test",
                "secondary color test"
        );

        company.setId(1L);
        CompanyDTO companyDTO = companyMapper.companyToCompanyDTO(company);

        assertNotNull(companyDTO);
        assertEquals(company.getId(), companyDTO.id());
        assertEquals(company.getName(), companyDTO.name());
        assertEquals(company.getSIRET(), companyDTO.SIRET());
        assertEquals(company.getTvaNumber(), companyDTO.tvaNumber());
        assertEquals(company.getJuridicalStructure(), companyDTO.juridicalStructure());
        assertEquals(company.getCreationDate(), companyDTO.creationDate());
        assertEquals(company.getCapital(), companyDTO.capital());
        assertEquals(company.getActivitySector(), companyDTO.activitySector());
        assertEquals(company.getSecondarySector(), companyDTO.secondarySector());
        assertEquals(company.getActivityDescription(), companyDTO.activityDescription());
        assertEquals(company.getKeywords(), companyDTO.keywords());
        assertEquals(company.getMarketTarget(), companyDTO.marketTarget());
        assertEquals(company.getImportance(), companyDTO.importance());
        assertEquals(company.getRegion(), companyDTO.region());
        assertEquals(company.getMaturity(), companyDTO.maturity());
        assertEquals(company.getWebsite(), companyDTO.website());
        assertEquals(company.getLinkedin(), companyDTO.linkedin());
        assertEquals(company.getTwitter(), companyDTO.twitter());
        assertEquals(company.getFacebook(), companyDTO.facebook());
        assertEquals(company.getComments(), companyDTO.comments());
        assertEquals(company.getMainColor(), companyDTO.mainColor());
        assertEquals(company.getSecondaryColor(), companyDTO.secondaryColor());
    }
}