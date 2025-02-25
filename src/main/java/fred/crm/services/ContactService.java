package fred.crm.services;

import fred.crm.repositories.ContactRepository;
import fred.crm.repositories.ContactSocialRepository;
import fred.crm.repositories.ContactTastesRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactSocialRepository contactSocialRepository;
    private final ContactTastesRepository contactTastesRepository;

    public ContactService(ContactRepository contactRepository, ContactSocialRepository contactSocialRepository, ContactTastesRepository contactTastesRepository) {
        this.contactRepository = contactRepository;
        this.contactSocialRepository = contactSocialRepository;
        this.contactTastesRepository = contactTastesRepository;
    }


}
