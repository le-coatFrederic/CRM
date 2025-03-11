package fred.crm.repositories;

import fred.crm.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByCity(String city);
    List<Location> findByCountry(String country);
    List<Location> findByCompanyName(String companyName);
}
