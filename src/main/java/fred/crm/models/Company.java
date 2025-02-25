package fred.crm.models;

import fred.crm.models.values.Importance;
import fred.crm.models.values.Maturity;
import fred.crm.models.values.Region;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(indexes = {
        @Index(columnList = "name"),
        @Index(columnList = "activitySector, secondarySector"),
        @Index(columnList = "importance, region, maturity")
})
public class Company {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true, unique = true)
    private String SIRET;

    @Column(nullable = true)
    private String TvaNumber;

    @Column(nullable = true)
    private String juridicalStructure;

    @Column(nullable = true)
    private Date creationDate;

    @Column(nullable = true)
    private double capital;

    @Column(nullable = false)
    private String activitySector;

    @Column(nullable = true)
    private String secondarySector;

    @Column(nullable = false, length = 1000)
    private String activityDescription;

    @Column(nullable = false)
    private String keywords;

    @Column(nullable = true)
    private String marketTarget;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Importance importance;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Region region;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Maturity maturity;

    @Column(nullable = true, length = 1000)
    private String comments;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CompanyContactsInformations companyContactsInformations;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Contact> contacts = new ArrayList<>();

    public Company() {
    }

    public Company(String name, String SIRET, String tvaNumber, String juridicalStructure, Date creationDate, double capital, String activitySector, String secondarySector, String activityDescription, String keywords, String marketTarget, Importance importance, Region region, Maturity maturity, String comments, CompanyContactsInformations companyContactsInformations) {
        this.name = name;
        this.SIRET = SIRET;
        TvaNumber = tvaNumber;
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
        this.comments = comments;
        this.companyContactsInformations = companyContactsInformations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSIRET() {
        return SIRET;
    }

    public void setSIRET(String SIRET) {
        this.SIRET = SIRET;
    }

    public String getTvaNumber() {
        return TvaNumber;
    }

    public void setTvaNumber(String tvaNumber) {
        TvaNumber = tvaNumber;
    }

    public String getJuridicalStructure() {
        return juridicalStructure;
    }

    public void setJuridicalStructure(String juridicalStructure) {
        this.juridicalStructure = juridicalStructure;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public String getActivitySector() {
        return activitySector;
    }

    public void setActivitySector(String activitySector) {
        this.activitySector = activitySector;
    }

    public String getSecondarySector() {
        return secondarySector;
    }

    public void setSecondarySector(String secondarySector) {
        this.secondarySector = secondarySector;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getMarketTarget() {
        return marketTarget;
    }

    public void setMarketTarget(String marketTarget) {
        this.marketTarget = marketTarget;
    }

    public Importance getImportance() {
        return importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Maturity getMaturity() {
        return maturity;
    }

    public void setMaturity(Maturity maturity) {
        this.maturity = maturity;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
        contact.setCompany(this);
    }

    public void removeContact(Contact contact) {
        this.contacts.remove(contact);
        contact.setCompany(null);
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
        Company company = (Company) o;
        return Double.compare(capital, company.capital) == 0 && Objects.equals(name, company.name) && Objects.equals(SIRET, company.SIRET) && Objects.equals(TvaNumber, company.TvaNumber) && Objects.equals(juridicalStructure, company.juridicalStructure) && Objects.equals(creationDate, company.creationDate) && Objects.equals(activitySector, company.activitySector) && Objects.equals(secondarySector, company.secondarySector) && Objects.equals(activityDescription, company.activityDescription) && Objects.equals(keywords, company.keywords) && Objects.equals(marketTarget, company.marketTarget) && importance == company.importance && region == company.region && maturity == company.maturity && Objects.equals(comments, company.comments) && Objects.equals(contacts, company.contacts) && Objects.equals(companyContactsInformations, company.companyContactsInformations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, SIRET, TvaNumber, juridicalStructure, creationDate, capital, activitySector, secondarySector, activityDescription, keywords, marketTarget, importance, region, maturity, comments, contacts, companyContactsInformations);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", SIRET='" + SIRET + '\'' +
                ", TvaNumber='" + TvaNumber + '\'' +
                ", juridicalStructure='" + juridicalStructure + '\'' +
                ", creationDate=" + creationDate +
                ", capital=" + capital +
                ", activitySector='" + activitySector + '\'' +
                ", secondarySector='" + secondarySector + '\'' +
                ", activityDescription='" + activityDescription + '\'' +
                ", keywords='" + keywords + '\'' +
                ", marketTarget='" + marketTarget + '\'' +
                ", importance=" + importance +
                ", region=" + region +
                ", maturity=" + maturity +
                ", comments='" + comments + '\'' +
                ", contacts=" + contacts +
                ", company contacts informations=" + companyContactsInformations +
                '}';
    }
}
