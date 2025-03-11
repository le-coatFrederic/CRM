package fred.crm.services;

import fred.crm.models.Company;
import fred.crm.repositories.CompanyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CompanyCRUDService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll() { return companyRepository.findAll(); }
    public Company save(Company company) { return companyRepository.save(company); }
    public Company findById(Long id) { return companyRepository.findById(id).get(); }
    public void delete(Company company) { companyRepository.delete(company); }
    public void deleteById(Long id) { companyRepository.deleteById(id); }
}
