package fred.crm.services;

import fred.crm.models.Location;
import fred.crm.repositories.LocationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LocationCRUDService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findAll() {
        return locationRepository.findAll();
    }
    public Location save(Location location) {
        return locationRepository.save(location);
    }
    public Location findById(Long id) { return locationRepository.findById(id).get(); }
    public void delete(Location location) { locationRepository.delete(location); }
    public void deleteById(Long id) { locationRepository.deleteById(id); }
    public List<Location> findByCompanyName(String companyName) { return locationRepository.findByCompanyName(companyName); }
}
