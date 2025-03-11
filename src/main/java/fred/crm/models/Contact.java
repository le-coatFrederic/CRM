package fred.crm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fred.crm.models.values.RelationState;
import fred.crm.models.values.SocialMedia;
import fred.crm.helpers.CryptoConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    @Convert(converter = CryptoConverter.class)
    private String firstname;

    @NonNull
    @Column(nullable = false)
    @Convert(converter = CryptoConverter.class)
    private String lastname;

    @NonNull
    @Column(nullable = false)
    @Convert(converter = CryptoConverter.class)
    private String job;

    @Column(nullable = true)
    @Convert(converter = CryptoConverter.class)
    private String department;

    @Column(nullable = true)
    @Convert(converter = CryptoConverter.class)
    private Date dateJoinedCompany;

    @Column(nullable = true)
    @Convert(converter = CryptoConverter.class)
    private String email;

    @Column(nullable = true)
    @Convert(converter = CryptoConverter.class)
    private String phone;

    @Column(nullable = true)
    @Convert(converter = CryptoConverter.class)
    private String linkedinLink;

    @Column(nullable = true)
    @Convert(converter = CryptoConverter.class)
    private String youtubeLink;

    @NonNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SocialMedia meetingCanal;

    @NonNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RelationState relationState;

    @Column(nullable = true)
    private String language;

    @Column(nullable = true)
    private SocialMedia canalPreferred;

    @Column(nullable = true)
    @Convert(converter = CryptoConverter.class)
    private String contactHours;

    @Column(nullable = true, length = 1000)
    @Convert(converter = CryptoConverter.class)
    private String notes;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @JsonIgnore
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Interaction> interactions = new ArrayList<>();

    public Contact(@NonNull String firstname, @NonNull String lastname, @NonNull String job, String department, Date dateJoinedCompany, String email, String phone, String linkedinLink, String youtubeLink, @NonNull SocialMedia meetingCanal, @NonNull RelationState relationState, String language, SocialMedia canalPreferred, String contactHours, String notes, Company company, List<Interaction> interactions) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.job = job;
        this.department = department;
        this.dateJoinedCompany = dateJoinedCompany;
        this.email = email;
        this.phone = phone;
        this.linkedinLink = linkedinLink;
        this.youtubeLink = youtubeLink;
        this.meetingCanal = meetingCanal;
        this.relationState = relationState;
        this.language = language;
        this.canalPreferred = canalPreferred;
        this.contactHours = contactHours;
        this.notes = notes;
        this.company = company;
        this.interactions = interactions;
    }
}
