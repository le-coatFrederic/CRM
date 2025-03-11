package fred.crm.models.dtos;

import fred.crm.models.values.RelationState;
import fred.crm.models.values.SocialMedia;

import java.sql.Date;

public record CreateContactDTO(
        String firstname,
        String lastname,
        String job,
        String department,
        Date dateJoinedCompany,
        String email,
        String phone,
        String linkedinLink,
        String youtubeLink,
        SocialMedia meetingCanal,
        RelationState relationState,
        String language,
        SocialMedia canalPreferred,
        String contactHours,
        String notes,
        CompanyDTO company
) {
}