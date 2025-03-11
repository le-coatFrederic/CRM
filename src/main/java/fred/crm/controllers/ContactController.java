package fred.crm.controllers;

import fred.crm.models.Contact;
import fred.crm.models.dtos.ContactDTO;
import fred.crm.models.dtos.CreateContactDTO;
import fred.crm.models.mappers.ContactMapper;
import fred.crm.models.mappers.CreateContactMapper;
import fred.crm.services.ContactCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private ContactCRUDService contactCRUDService;
    private ContactMapper contactMapper;
    private CreateContactMapper createContactMapper;

    @GetMapping
    public ResponseEntity<List<ContactDTO>> getAllContacts() {
        List<Contact> contacts = contactCRUDService.findAll();
        List<ContactDTO> contactDTO = new ArrayList<>();

        for (Contact contact : contacts) {
            contactDTO.add(contactMapper.contactToContactDTO(contact));
        }

        return ResponseEntity.ok(contactDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable Long id) {
        Contact contact = contactCRUDService.findById(id);
        return ResponseEntity.ok(contactMapper.contactToContactDTO(contact));
    }

    @PostMapping
    public ResponseEntity<ContactDTO> createContact(@RequestBody CreateContactDTO contactDTO) {
        Contact contact = contactCRUDService.save(createContactMapper.contactDTOToContact(contactDTO));
        return ResponseEntity.ok(contactMapper.contactToContactDTO(contact));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable Long id, @RequestBody CreateContactDTO contactDTO) {
        Contact contact = contactCRUDService.save(createContactMapper.contactDTOToContact(contactDTO));
        return ResponseEntity.ok(contactMapper.contactToContactDTO(contact));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactCRUDService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
