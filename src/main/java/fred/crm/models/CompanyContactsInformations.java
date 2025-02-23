package fred.crm.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class CompanyContactsInformations {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "companyContactsInformations", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Location> locations = new ArrayList<>();

    @Column(nullable = true, unique = true)
    private String email;

    @Column(nullable = true, unique = true)
    private String phone;

    @Column(nullable = true, unique = true)
    private String website;

    @Column(nullable = true, unique = true)
    private String linkedin;

    @Column(nullable = true, unique = true)
    private String twitter;

    @Column(nullable = true, unique = true)
    private String facebook;

    public CompanyContactsInformations() {
    }

    public CompanyContactsInformations(List<Location> locations, String email, String phone, String website, String linkedin, String twitter, String facebook) {
        this.locations = locations;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.linkedin = linkedin;
        this.twitter = twitter;
        this.facebook = facebook;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void addLocation(Location location) {
        this.locations.add(location);
        location.setCompanyContactsInformations(this);
    }

    public void removeLocation(Location location) {
        this.locations.remove(location);
        location.setCompanyContactsInformations(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyContactsInformations that = (CompanyContactsInformations) o;
        return Objects.equals(locations, that.locations) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone) && Objects.equals(website, that.website) && Objects.equals(linkedin, that.linkedin) && Objects.equals(twitter, that.twitter) && Objects.equals(facebook, that.facebook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locations, email, phone, website, linkedin, twitter, facebook);
    }

    @Override
    public String toString() {
        return "CompanyContactsInformations{" +
                "id=" + id +
                ", locations=" + locations +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", linkedin='" + linkedin + '\'' +
                ", twitter='" + twitter + '\'' +
                ", facebook='" + facebook + '\'' +
                '}';
    }
}
