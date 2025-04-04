package fred.crm.models.dtos;

public record CreateLocationDTO(
        String address1,
        String address2,
        String city,
        String zipcode,
        String state,
        String country,
        Long company
) {
}