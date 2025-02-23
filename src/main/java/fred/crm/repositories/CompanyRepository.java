package fred.crm.repositories;

import fred.crm.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByNameIgnoreCase(String name);
    List<Company> findByNameContainingIgnoreCase(String name);
    Optional<Company> findBySIRET(String SIRET);
    List<Company> findByActivitySector(String activitySector);
}
