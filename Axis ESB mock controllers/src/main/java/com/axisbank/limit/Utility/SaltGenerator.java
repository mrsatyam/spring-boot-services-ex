package com.axisbank.limit.Utility;

import java.security.SecureRandom;

public class SaltGenerator {
    public static void main(String[] args) {
        try {
            // Generate a random salt
            byte[] salt = generateSalt(16); // 16 bytes for a typical salt length

            // Print the salt in hexadecimal format
            System.out.println("Generated Salt (Hex): ");
            for (byte b : salt) {
                System.out.printf("%02X", b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] generateSalt(int length) throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[length];
        random.nextBytes(salt);
        return salt;
    }
}
