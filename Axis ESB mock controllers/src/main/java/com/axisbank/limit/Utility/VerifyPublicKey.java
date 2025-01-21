package com.axisbank.limit.Utility;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class VerifyPublicKey {
    public static boolean verifyPublicKey(String publicKeyPEM) {
        try {
            // Remove the first and last lines
            publicKeyPEM = publicKeyPEM.replace("-----BEGIN PUBLIC KEY-----", "")
                    .replace("-----END PUBLIC KEY-----", "")
                    .replaceAll("\\s+", "");

            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyPEM);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            /*System.out.println(Base64.getEncoder().encodeToString(publicKey.getEncoded()));
            System.out.println("222");
            System.out.println(publicKey.getFormat());
            System.out.println("33");
            System.out.println(publicKey.toString());*/
            return true; // If no exception, the key is valid
        } catch (Exception e) {
            System.out.println("Invalid Public Key: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        String publicKeyPEM = "-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxp41snGkhjNsMMyzyY8wImBa3YHgVIxVgRtv3Gyw80PMIwAqr7uisnS4nzolfrnmeLd3/hQGJnPWt6hcNl1MwRb+ioZgzSfiEfUGt1sU6/ptLYPEaLmgzB9+p8sXjC\n" +
                "          HEi6+h2jYt9Du/Nx1Kr0j9lf3qGO7uk1xPOROoi2HjQXhRGe0GSJms4o2MQW6iQscl3EajoqG4F3dXns8/5CGXi2VpzQ8t0H2sXqzo6V/Sm+L/UND2bSmsFTgUjTomEBeIg5eaRdApBD/M+rqBUasAuzviOOM5e0OqF6UjHL9R\n" +
                "          /24qM8hOHv/LYCG0j9N4XHftUNbMasOG0ZUWOvO8mQI5/wIDAQAB\n-----END PUBLIC KEY-----";

        String pubKey="-----BEGIN RSA PUBLIC KEY-----\n" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxp41snGkhjNsMMyzyY8wImBa3YHgVIxVgRtv3Gyw80PMIwAqr7uisnS4nzolfrnmeLd3/hQGJnPWt6hcNl1MwRb+ioZgzSfiEfUGt1sU6/ptLYPEaLmgzB9+p8sXjC\n" +
                "HEi6+h2jYt9Du/Nx1Kr0j9lf3qGO7uk1xPOROoi2HjQXhRGe0GSJms4o2MQW6iQscl3EajoqG4F3dXns8/5CGXi2VpzQ8t0H2sXqzo6V/Sm+L/UND2bSmsFTgUjTomEBeIg5eaRdApBD/M+rqBUasAuzviOOM5e0OqF6UjHL9R\n" +
                "/24qM8hOHv/LYCG0j9N4XHftUNbMasOG0ZUWOvO8mQI5/wIDAQAB\n" +
                "-----END RSA PUBLIC KEY-----";
       // System.out.println(pubKey);
        System.out.println("============-------");
        boolean isValid = verifyPublicKey(publicKeyPEM);
        System.out.println("Is the public key valid? " + isValid);
    }
}
