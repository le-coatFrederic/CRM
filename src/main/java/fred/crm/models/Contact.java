package fred.crm.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    private Date birthDate;

    @Column(nullable = false)
    private String job;

    @Column(nullable = true)
    private String department;

    @Column(nullable = true)
    private Date dateJoinedCompany;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_social_id", unique = true, nullable = true)
    private ContactSocial contactSocial;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_tastes_id")
    private ContactTastes contactTastes;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Interaction> interactions = new ArrayList<>();

    public Contact() {
    }

    public Contact(String firstname, String lastname, Date birthDate, String job, String department, Date dateJoinedCompany, ContactSocial contactSocial, ContactTastes contactTastes, Company company, List<Interaction> interactions) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.job = job;
        this.department = department;
        this.dateJoinedCompany = dateJoinedCompany;
        this.contactSocial = contactSocial;
        this.contactTastes = contactTastes;
        this.company = company;
        this.interactions = interactions;
    }

    public void addInteraction(Interaction interaction) {
        this.interactions.add(interaction);
        interaction.setContact(this);
    }

    public void removeInteraction(Interaction interaction) {
        this.interactions.remove(interaction);
        interaction.setContact(null);
    }

    public ContactTastes getContactTastes() {
        return contactTastes;
    }

    public void setContactTastes(ContactTastes contactTastes) {
        this.contactTastes = contactTastes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getDateJoinedCompany() {
        return dateJoinedCompany;
    }

    public void setDateJoinedCompany(Date dateJoinedCompany) {
        this.dateJoinedCompany = dateJoinedCompany;
    }

    public ContactSocial getContactSocial() {
        return contactSocial;
    }

    public void setContactSocial(ContactSocial contactSocial) {
        this.contactSocial = contactSocial;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Interaction> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<Interaction> interactions) {
        this.interactions = interactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstname, contact.firstname) && Objects.equals(lastname, contact.lastname) && Objects.equals(birthDate, contact.birthDate) && Objects.equals(job, contact.job) && Objects.equals(department, contact.department) && Objects.equals(dateJoinedCompany, contact.dateJoinedCompany) && Objects.equals(contactSocial, contact.contactSocial) && Objects.equals(contactTastes, contact.contactTastes) && Objects.equals(company, contact.company) && Objects.equals(interactions, contact.interactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, birthDate, job, department, dateJoinedCompany, contactSocial, contactTastes, company, interactions);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDate=" + birthDate +
                ", job='" + job + '\'' +
                ", department='" + department + '\'' +
                ", dateJoinedCompany=" + dateJoinedCompany +
                ", contactSocial=" + contactSocial +
                ", contactTastes=" + contactTastes +
                ", company=" + company +
                ", interactions=" + interactions +
                '}';
    }
}
