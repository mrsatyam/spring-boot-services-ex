package com.axisbank.limit.encryption;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class PwdVerifier {

    //TEST@1@12

    //will be provided by CITI
    private static final String SALT = "D56C3E965DD5261819F78F91D73650D2";

    //will be provided by CITI
    private static final String HASHED_PASSWORD = "c0bcca4b556e4e4c9b1dbb0ab8e50fdcb36215138bb938029b95da758dc56b72";
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);

        for (int attempts = 1; attempts <= MAX_ATTEMPTS; attempts++) {
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            String concatenatedPassword = password.toUpperCase() + SALT;

            String hashedPassword = toHexString(getSHA(concatenatedPassword));

            if (hashedPassword.equals(HASHED_PASSWORD)) {
                System.out.println("Login successful!");
                break;
            } else {
                System.out.println("Login failed! Remaining attempts: " + (MAX_ATTEMPTS - attempts));
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Maximum number of attempts reached. Login locked.");
            }
        }
    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
}
