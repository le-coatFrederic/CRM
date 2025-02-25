package fred.crm.models;

import fred.crm.models.values.InteractionConclusion;
import fred.crm.models.values.InteractionStatus;
import fred.crm.models.values.InteractionType;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Objects;

@Entity
public class Interaction {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InteractionStatus status;

    @Column(nullable = false)
    private Time startTime;

    @Column(nullable = false)
    private Time endTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InteractionType type;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String objectives;

    @Column(nullable = false, length = 1000)
    private String privateNotes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InteractionConclusion conclusion;

    @Column(nullable = true)
    private Time nextDate;

    public Interaction() {
    }

    public Interaction(Contact contact, InteractionStatus status, Time startTime, Time endTime, InteractionType type, String subject, String objectives, String privateNotes, InteractionConclusion conclusion, Time nextDate) {
        this.contact = contact;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.subject = subject;
        this.objectives = objectives;
        this.privateNotes = privateNotes;
        this.conclusion = conclusion;
        this.nextDate = nextDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public InteractionStatus getStatus() {
        return status;
    }

    public void setStatus(InteractionStatus status) {
        this.status = status;
    }

    public Time getstartTime() {
        return startTime;
    }

    public void setstartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public InteractionType getType() {
        return type;
    }

    public void setType(InteractionType type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getPrivateNotes() {
        return privateNotes;
    }

    public void setPrivateNotes(String privateNotes) {
        this.privateNotes = privateNotes;
    }

    public InteractionConclusion getConclusion() {
        return conclusion;
    }

    public void setConclusion(InteractionConclusion conclusion) {
        this.conclusion = conclusion;
    }

    public Time getNextDate() {
        return nextDate;
    }

    public void setNextDate(Time nextDate) {
        this.nextDate = nextDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interaction that = (Interaction) o;
        return Objects.equals(contact, that.contact) && status == that.status && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && type == that.type && Objects.equals(subject, that.subject) && Objects.equals(objectives, that.objectives) && Objects.equals(privateNotes, that.privateNotes) && conclusion == that.conclusion && Objects.equals(nextDate, that.nextDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact, status, startTime, endTime, type, subject, objectives, privateNotes, conclusion, nextDate);
    }

    @Override
    public String toString() {
        return "Interaction{" +
                "id=" + id +
                ", contact=" + contact +
                ", status=" + status +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", type=" + type +
                ", subject='" + subject + '\'' +
                ", objectives='" + objectives + '\'' +
                ", privateNotes='" + privateNotes + '\'' +
                ", conclusion=" + conclusion +
                ", nextDate=" + nextDate +
                '}';
    }
}
