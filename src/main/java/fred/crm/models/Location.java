package fred.crm.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String address1;

    @Column(nullable = true)
    private String address2;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = true)
    private String state;

    @Column(nullable = false)
    private String country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "company_contacts_informations_id")
    private CompanyContactsInformations companyContactsInformations;

    public Location() {}

    public Location(String address1, String address2, String city, String zipCode, String state, String country) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CompanyContactsInformations getCompanyContactsInformations() {
        return companyContactsInformations;
    }

    public void setCompanyContactsInformations(CompanyContactsInformations companyContactsInformations) {
        this.companyContactsInformations = companyContactsInformations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(address1, location.address1) && Objects.equals(address2, location.address2) && Objects.equals(city, location.city) && Objects.equals(zipCode, location.zipCode) && Objects.equals(state, location.state) && Objects.equals(country, location.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address1, address2, city, zipCode, state, country);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
