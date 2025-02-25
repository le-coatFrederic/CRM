package fred.crm.helpers;

import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.stereotype.Component;

@Component
public class CryptoHelper {
    private final TextEncryptor encryptor = Encryptors.text("secret", "deadbeef");


}
