package fred.crm;

import fred.crm.models.Contact;
import fred.crm.models.Interaction;
import fred.crm.models.values.*;
import fred.crm.services.ContactCRUDService;
import fred.crm.services.InteractionCRUDService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@SpringBootApplication
public class CrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }
}
