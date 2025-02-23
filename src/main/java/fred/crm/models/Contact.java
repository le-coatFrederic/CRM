package fred.crm.models;

import jakarta.persistence.*;

import java.sql.Date;

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

    public ContactTastes getContactTastes() {
        return contactTastes;
    }

    public void setContactTastes(ContactTastes contactTastes) {
        this.contactTastes = contactTastes;
    }

    public Contact() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
