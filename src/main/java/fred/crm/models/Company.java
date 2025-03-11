package fred.crm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fred.crm.models.values.Importance;
import fred.crm.models.values.Maturity;
import fred.crm.models.values.Region;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(indexes = {
        @Index(columnList = "name"),
        @Index(columnList = "activitySector, secondarySector"),
        @Index(columnList = "importance, region, maturity")
})
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true, unique = true)
    private String SIRET;

    @Column(nullable = true)
    private String tvaNumber;

    @Column(nullable = true)
    private String juridicalStructure;

    @Column(nullable = true)
    private Date creationDate;

    @Column(nullable = true)
    private double capital;

    @NonNull
    @Column(nullable = false)
    private String activitySector;

    @Column(nullable = true)
    private String secondarySector;

    @NonNull
    @Column(nullable = false, length = 1000)
    private String activityDescription;

    @NonNull
    @Column(nullable = false)
    private String keywords;

    @Column(nullable = true)
    private String marketTarget;

    @NonNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Importance importance;

    @NonNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Region region;

    @NonNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Maturity maturity;

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

    @Column(nullable = true, length = 1000)
    private String comments;

    @Column(nullable = true, unique = false)
    private String mainColor;

    @Column(nullable = true, unique = false)
    private String secondaryColor;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Contact> contacts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Location> locations = new ArrayList<>();

    public void addContact(Contact contact) {
        this.contacts.add(contact);
        contact.setCompany(this);
    }

    public void removeContact(Contact contact) {
        this.contacts.remove(contact);
        contact.setCompany(null);
    }

    public void addLocation(Location location) {
        this.locations.add(location);
        location.setCompany(this);
    }

    public void removeLocation(Location location) {
        this.locations.remove(location);
        location.setCompany(null);
    }

    public Company(@NonNull String name, String SIRET, String tvaNumber, String juridicalStructure, Date creationDate, double capital, @NonNull String activitySector, String secondarySector, @NonNull String activityDescription, @NonNull String keywords, String marketTarget, @NonNull Importance importance, @NonNull Region region, @NonNull Maturity maturity, String email, String phone, String website, String linkedin, String twitter, String facebook, String comments, List<Contact> contacts, List<Location> locations, String mainColor, String secondaryColor) {
        this.name = name;
        this.SIRET = SIRET;
        this.tvaNumber = tvaNumber;
        this.juridicalStructure = juridicalStructure;
        this.creationDate = creationDate;
        this.capital = capital;
        this.activitySector = activitySector;
        this.secondarySector = secondarySector;
        this.activityDescription = activityDescription;
        this.keywords = keywords;
        this.marketTarget = marketTarget;
        this.importance = importance;
        this.region = region;
        this.maturity = maturity;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.linkedin = linkedin;
        this.twitter = twitter;
        this.facebook = facebook;
        this.comments = comments;
        this.mainColor = mainColor;
        this.secondaryColor = secondaryColor;
        this.contacts = contacts;
        this.locations = locations;
    }
}
