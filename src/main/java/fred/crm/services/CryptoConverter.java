package fred.crm.services;

import jakarta.persistence.AttributeConverter;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

public class CryptoConverter implements AttributeConverter<String, String> {
    private final String password = "AIZUFGUIAHFIQHSJFbufvuzivfqizfvqizfvqii**dzjiuhdiuqgz*";
    private final String salt = "dzqiuhdi";

    private final TextEncryptor textEncryptor = Encryptors.text(password, salt);

    @Override
    public String convertToDatabaseColumn(String s) {
        return s == null ? null : textEncryptor.encrypt(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return s == null ? null : textEncryptor.decrypt(s);
    }
}
