package fred.crm.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String address1;

    @Column(nullable = true)
    private String address2;

    @NonNull
    @Column(nullable = false)
    private String city;

    @NonNull
    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = true)
    private String state;

    @NonNull
    @Column(nullable = false)
    private String country;

    @NonNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "company_id")
    private Company company;

    public Location(String address1, String address2, String city, String zipCode, String state, String country, Company company) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
        this.company = company;
    }
}
