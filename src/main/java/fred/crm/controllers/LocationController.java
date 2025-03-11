package fred.crm.controllers;

import fred.crm.models.Location;
import fred.crm.models.dtos.CreateLocationDTO;
import fred.crm.models.dtos.LocationDTO;
import fred.crm.models.mappers.CreateLocationMapper;
import fred.crm.models.mappers.LocationMapper;
import fred.crm.services.LocationCRUDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
    private LocationCRUDService locationCRUDService;
    private LocationMapper locationMapper;
    private CreateLocationMapper createLocationMapper;

    public LocationController(LocationCRUDService locationCRUDService, LocationMapper locationMapper, CreateLocationMapper createLocationMapper) {
        this.locationCRUDService = locationCRUDService;
        this.locationMapper = locationMapper;
        this.createLocationMapper = createLocationMapper;
    }

    @GetMapping
    public ResponseEntity<List<LocationDTO>> getAllLocations() {
        List<Location> locations = locationCRUDService.findAll();
        List<LocationDTO> locationDTO  = new ArrayList<>();

        for (Location location : locations) {
            locationDTO.add(locationMapper.locationToLocationDTO(location));
        }

        return ResponseEntity.ok(locationDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> getLocationById(@PathVariable Long id) {
        Location location = locationCRUDService.findById(id);
        return ResponseEntity.ok(locationMapper.locationToLocationDTO(location));
    }

    @PostMapping
    public ResponseEntity<LocationDTO> createLocation(@RequestBody CreateLocationDTO locationDTO) {
        Location location = locationCRUDService.save(createLocationMapper.locationDTOToLocation(locationDTO));
        return ResponseEntity.ok(locationMapper.locationToLocationDTO(location));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationDTO> updateLocation(@PathVariable Long id, @RequestBody LocationDTO location) {
        Location updatedCompany = locationCRUDService.save(locationMapper.locationDTOToLocation(location));
        return new ResponseEntity<>(locationMapper.locationToLocationDTO(updatedCompany), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        locationCRUDService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
