package fred.crm.controllers;

import fred.crm.models.Company;
import fred.crm.models.dtos.CompanyDTO;
import fred.crm.models.dtos.CreateCompanyDTO;
import fred.crm.models.mappers.CompanyMapper;
import fred.crm.models.mappers.CreateCompanyMapper;
import fred.crm.services.CompanyCRUDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private CompanyCRUDService companyCRUDService;
    private CompanyMapper companyMapper;
    private CreateCompanyMapper createCompanyMapper;

    public CompanyController(CompanyCRUDService companyCRUDService, CompanyMapper companyMapper, CreateCompanyMapper createCompanyMapper) {
        this.companyCRUDService = companyCRUDService;
        this.companyMapper = companyMapper;
        this.createCompanyMapper = createCompanyMapper;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        List<Company> companies = companyCRUDService.findAll();
        List<CompanyDTO> companiesToSend = new ArrayList<>();

        for (Company company : companies) {
            companiesToSend.add(companyMapper.companyToCompanyDTO(company));
        }

        return new ResponseEntity(companiesToSend, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long id) {
        Company companyToConvert = companyCRUDService.findById(id);
        return new ResponseEntity<>(companyMapper.companyToCompanyDTO(companyToConvert), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CreateCompanyDTO company) {
        Company createdCompany = companyCRUDService.save(createCompanyMapper.companyDTOToCompany(company));
        return new ResponseEntity<>(companyMapper.companyToCompanyDTO(createdCompany), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long id, @RequestBody CompanyDTO company) {
        Company updatedCompany = companyCRUDService.save(companyMapper.companyDTOToCompany(company));
        return new ResponseEntity<>(companyMapper.companyToCompanyDTO(updatedCompany), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyCRUDService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
