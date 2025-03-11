package fred.crm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fred.crm.models.values.InteractionConclusion;
import fred.crm.models.values.InteractionStatus;
import fred.crm.models.values.InteractionType;
import fred.crm.helpers.CryptoConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Time;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Interaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InteractionStatus status;

    @NonNull
    @Column(nullable = false)
    @Convert(converter = CryptoConverter.class)
    private Time startTime;

    @NonNull
    @Column(nullable = false)
    @Convert(converter = CryptoConverter.class)
    private Time endTime;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InteractionType type;

    @NonNull
    @Column(nullable = false)
    @Convert(converter = CryptoConverter.class)
    private String subject;

    @NonNull
    @Column(nullable = false)
    @Convert(converter = CryptoConverter.class)
    private String objectives;

    @Column(nullable = false, length = 1000)
    @NonNull
    @Convert(converter = CryptoConverter.class)
    private String privateNotes;

    @Enumerated(EnumType.STRING)
    @NonNull
    @Column(nullable = false)
    @Convert(converter = CryptoConverter.class)
    private InteractionConclusion conclusion;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Interaction nextInteraction;

    @JsonIgnore
    @OneToOne(mappedBy = "nextInteraction")
    private Interaction previousInteraction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Interaction(@NonNull InteractionStatus status, @NonNull Time startTime, @NonNull Time endTime, @NonNull InteractionType type, @NonNull String subject, @NonNull String objectives, @NonNull String privateNotes, @NonNull InteractionConclusion conclusion, Interaction nextInteraction, Interaction previousInteraction, Contact contact) {
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.subject = subject;
        this.objectives = objectives;
        this.privateNotes = privateNotes;
        this.conclusion = conclusion;
        this.nextInteraction = nextInteraction;
        this.previousInteraction = previousInteraction;
        this.contact = contact;
    }
}
