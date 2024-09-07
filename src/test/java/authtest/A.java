package authtest;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Utility class for AES encryption and decryption.
 */
public class A {

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
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
        IvParameterSpec ivps = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivps);
        byte[] encryptedText = cipher.doFinal(input.getBytes("UTF-8"));
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
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
        IvParameterSpec ivps = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivps);
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        byte[] decryptedText = cipher.doFinal(decodedBytes);
        return new String(decryptedText, "UTF-8");
    }

    public static void main(String[] args) {
        try {
            A util = new A();
            String privateKey = "Ac03tEam@j!tu_#1"; // 16-byte key for AES

            String data = "{\"name\":\"Akshay\",\"id\":\"1\"}";
            System.out.println("Plaintext: " + data);

            String encrypted = util.encrypt(data, privateKey);
            System.out.println("Encrypted: " + encrypted);

            String decrypted = util.decrypt(encrypted, privateKey);
            System.out.println("Decrypted: " + decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
