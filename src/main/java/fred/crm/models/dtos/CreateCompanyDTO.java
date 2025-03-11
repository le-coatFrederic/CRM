package fred.crm.models.dtos;

import fred.crm.models.values.Importance;
import fred.crm.models.values.Maturity;
import fred.crm.models.values.Region;

import java.sql.Date;

public record CreateCompanyDTO(
        String name,
        String SIRET,
        String tvaNumber,
        String juridicalStructure,
        Date creationDate,
        Double capital,
        String activitySector,
        String secondarySector,
        String activityDescription,
        String keywords,
        String marketTarget,
        Importance importance,
        Region region,
        Maturity maturity,
        String email,
        String phone,
        String website,
        String linkedin,
        String twitter,
        String facebook,
        String comments,
        String mainColor,
        String secondaryColor
) {
}