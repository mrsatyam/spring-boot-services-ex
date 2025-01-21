package com.axisbank.limit.Utility;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class AESKeyGenerator {
    public static void main(String[] args) {
        generateAES256Key();
    }

    private static void generateAES256Key() {
        try {
            // Create a KeyGenerator object for AES
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");

            // Initialize the KeyGenerator with a key size of 256 bits
            keyGen.init(256);

            // Generate a secret key
            SecretKey secretKey = keyGen.generateKey();

            // Convert the secret key to bytes
            byte[] keyBytes = secretKey.getEncoded();

            // Print the key in hexadecimal format
            System.out.println("Generated AES Key (Hex): ");
            for (byte b : keyBytes) {
                System.out.printf("%02X", b);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
