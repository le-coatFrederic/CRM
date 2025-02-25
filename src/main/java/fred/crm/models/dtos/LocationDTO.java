package fred.crm.models.dtos;

import fred.crm.models.Location;

public record LocationDTO(
        Long id,
        String address1,
        String address2,
        String city,
        String zipCode,
        String state,
        String country
) {
    public static LocationDTO fromEntity(Location location) {
        return new LocationDTO(
                location.getId(),
                location.getAddress1(),
                location.getAddress2(),
                location.getCity(),
                location.getZipCode(),
                location.getState(),
                location.getCountry()
        );
    }

    public Location toEntity() {
        return new Location(
                this.address1,
                this.address2,
                this.city,
                this.zipCode,
                this.state,
                this.country
        );
    }
}
