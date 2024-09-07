package authtest;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Utility class for AES encryption and decryption.
 */
public class EncryptAndDecryptUtility {

    private static final String INIT_VECTOR = "4234567890123456"; // 16-byte IV for AES
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    /**
     * Encrypts the given input string using the specified secret key.
     * 
     * @param input The input string to encrypt.
     * @param secretKey The secret key for encryption.
     * @return The encrypted string encoded in Base64.
     * @throws Exception if an error occurs during encryption.
     */
    public String encrypt(String input, String secretKey) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        IvParameterSpec ivps = new IvParameterSpec(INIT_VECTOR.getBytes());
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivps);
        byte[] encryptedText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(encryptedText);
    }

    /**
     * Decrypts the given encrypted input string using the specified secret key.
     * 
     * @param input The encrypted input string encoded in Base64.
     * @param secretKey The secret key for decryption.
     * @return The decrypted string.
     * @throws Exception if an error occurs during decryption.
     */
    public String decrypt(String input, String secretKey) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        IvParameterSpec ivps = new IvParameterSpec(INIT_VECTOR.getBytes());
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivps);
        byte[] decryptedText = cipher.doFinal(Base64.getDecoder().decode(input));
        return new String(decryptedText);
    }

    public static void main(String[] args) {
        try {
            EncryptAndDecryptUtility util = new EncryptAndDecryptUtility();
            String secretKey = "Ac03tEam@j!tu_#1"; // 16-byte key for AES

            String plaintext = "Hello, this is a secret message!";
            System.out.println("Plaintext: " + plaintext);

            String encrypted = util.encrypt(plaintext, secretKey);
            System.out.println("Encrypted: " + encrypted);

            String decrypted = util.decrypt(encrypted, secretKey);
            System.out.println("Decrypted: " + decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
