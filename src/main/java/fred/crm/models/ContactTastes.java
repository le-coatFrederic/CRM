package fred.crm.models;

import fred.crm.models.values.SocialMedia;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class ContactTastes {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = true)
    private String language;

    @Column(nullable = true)
    private SocialMedia canalPreferred;

    @Column(nullable = true)
    private String contactHours;

    @Column(nullable = true, length = 1000)
    private String notes;

    @OneToOne(mappedBy = "contactTastes")
    private Contact contact;

    public ContactTastes() {
    }

    public ContactTastes(String language, SocialMedia canalPreferred, String contactHours, String notes, Contact contact) {
        this.language = language;
        this.canalPreferred = canalPreferred;
        this.contactHours = contactHours;
        this.notes = notes;
        this.contact = contact;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public SocialMedia getCanalPreferred() {
        return canalPreferred;
    }

    public void setCanalPreferred(SocialMedia canalPreferred) {
        this.canalPreferred = canalPreferred;
    }

    public String getContactHours() {
        return contactHours;
    }

    public void setContactHours(String contactHours) {
        this.contactHours = contactHours;
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
        ContactTastes that = (ContactTastes) o;
        return Objects.equals(language, that.language) && canalPreferred == that.canalPreferred && Objects.equals(contactHours, that.contactHours) && Objects.equals(notes, that.notes) && Objects.equals(contact, that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, canalPreferred, contactHours, notes, contact);
    }

    @Override
    public String toString() {
        return "ContactTastes{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", canalPreferred=" + canalPreferred +
                ", contactHours='" + contactHours + '\'' +
                ", notes='" + notes + '\'' +
                ", contact=" + contact +
                '}';
    }
}
