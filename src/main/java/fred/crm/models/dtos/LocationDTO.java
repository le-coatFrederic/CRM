package fred.crm.models.dtos;

public record LocationDTO(
        Long id,
        String address1,
        String address2,
        String city,
        String zipcode,
        String state,
        String country,
        CompanyDTO company
) {
}