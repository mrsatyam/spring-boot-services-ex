package com.axisbank.limit.Utility;

import java.security.SecureRandom;
import java.util.Arrays;

public class IVGenerator {
    public static void main(String[] args) {
        String hexaStr = generateByteToHeXa();
        byte[] iv=hexStringToByteArray(hexaStr);
        System.out.println("back to byte...");
        System.out.println(Arrays.toString(iv));
    }

    private static String generateByteToHeXa() {
        StringBuilder hexaStr=new StringBuilder();
        try {
            // Generate a random IV
            byte[] iv = generateIV(16); // 16 bytes for AES

            // Print the IV in hexadecimal format
            System.out.println(Arrays.toString(iv));
            System.out.println("Generated IV (Hex): ");

            for (byte b : iv) {
                System.out.printf("%02X", b);
                hexaStr.append(String.format("%02X", b));
            }
            System.out.println();
            System.out.println(hexaStr.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hexaStr.toString();
    }

    public static byte[] generateIV(int length) throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[length];
        random.nextBytes(iv);
        return iv;
    }
    public static byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] byteArray = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            byteArray[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return byteArray;
    }
}
