package fred.crm.helpers;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

@Converter(autoApply = true)
public class CryptoConverter implements AttributeConverter<String, String> {
    private static final String ENCRYPTED_PASSWORD = "encryptedPassword";
    private static final String SALT = "deadbeefdeadbeef";

    private final TextEncryptor textEncryptor = Encryptors.text(ENCRYPTED_PASSWORD, SALT);

    public String encrypt(String text) {
        return textEncryptor.encrypt(text);
    }

    public String decrypt(String encryptedText) {
        return textEncryptor.decrypt(encryptedText);
    }

    @Override
    public String convertToDatabaseColumn(String s) {
        if (s == null) {
            return null;
        }

        return textEncryptor.encrypt(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }

        return textEncryptor.decrypt(s);
    }
}