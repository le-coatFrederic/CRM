package fred.crm.services;

import fred.crm.models.Contact;
import fred.crm.repositories.ContactRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ContactCRUDService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }
    public Contact findById(Long id) { return contactRepository.findById(id).get(); }
    public void delete(Contact contact) { contactRepository.delete(contact); }
    public void deleteById(Long id) { contactRepository.deleteById(id); }
}