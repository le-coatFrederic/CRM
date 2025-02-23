package fred.crm.models;

import fred.crm.models.values.RelationState;
import fred.crm.models.values.SocialMedia;
import fred.crm.services.CryptoConverter;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class ContactSocial {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = true)
    @Convert(converter = CryptoConverter.class)
    private String email;

    @Column(nullable = true)
    @Convert(converter = CryptoConverter.class)
    private String phone;

    @Column(nullable = true)
    private String linkedinLink;

    @Column(nullable = true)
    private String youtubeLink;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SocialMedia meetingCanal;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RelationState relationState;

    @Column(nullable = true, length = 1000)
    @Convert(converter = CryptoConverter.class)
    private String notes;

    @OneToOne(mappedBy = "contactSocial")
    private Contact contact;

    public ContactSocial() {
    }

    public ContactSocial(String email, String phone, String linkedinLink, String youtubeLink, SocialMedia meetingCanal, RelationState relationState, String notes, Contact contact) {
        this.email = email;
        this.phone = phone;
        this.linkedinLink = linkedinLink;
        this.youtubeLink = youtubeLink;
        this.meetingCanal = meetingCanal;
        this.relationState = relationState;
        this.notes = notes;
        this.contact = contact;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public SocialMedia getMeetingCanal() {
        return meetingCanal;
    }

    public void setMeetingCanal(SocialMedia meetingCanal) {
        this.meetingCanal = meetingCanal;
    }

    public RelationState getRelationState() {
        return relationState;
    }

    public void setRelationState(RelationState relationState) {
        this.relationState = relationState;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactSocial that = (ContactSocial) o;
        return Objects.equals(email, that.email) && Objects.equals(phone, that.phone) && Objects.equals(linkedinLink, that.linkedinLink) && Objects.equals(youtubeLink, that.youtubeLink) && meetingCanal == that.meetingCanal && relationState == that.relationState && Objects.equals(notes, that.notes) && Objects.equals(contact, that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, phone, linkedinLink, youtubeLink, meetingCanal, relationState, notes, contact);
    }

    @Override
    public String toString() {
        return "ContactSocial{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", linkedinLink='" + linkedinLink + '\'' +
                ", youtubeLink='" + youtubeLink + '\'' +
                ", meetingCanal=" + meetingCanal +
                ", relationState=" + relationState +
                ", notes='" + notes + '\'' +
                ", contact=" + contact +
                '}';
    }
}
