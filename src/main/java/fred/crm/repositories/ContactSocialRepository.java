package fred.crm.repositories;

import fred.crm.models.ContactSocial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactSocialRepository extends JpaRepository<ContactSocial, Long> {
}
