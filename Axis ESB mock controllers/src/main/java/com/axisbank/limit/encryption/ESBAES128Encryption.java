package com.axisbank.limit.encryption;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ESBAES128Encryption {
    @SuppressWarnings("null")
    public static String encrypt(final String word, final String password){
        try{
            byte[] ivBytes;
            SecureRandom random = new SecureRandom();
            byte bytes[] = new byte[20];
            random.nextBytes(bytes);
            byte[] saltBytes = bytes;
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2withHmacSHA1");
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, 50, 128);
            SecretKey secretKey = factory.generateSecret(spec);
            SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secret);
            AlgorithmParameters params = cipher.getParameters();
            //Specification for HunterOnlineMatchingService_v2 Integration with Enterprise Service Bus
            //System.out.println("IV PARAMS"+cipher.getParameters().toString());
            ivBytes = params.getParameterSpec(IvParameterSpec.class).getIV();
            //System.out.println("SIZE"+ivBytes.length);
            byte[] encryptedTextBytes = cipher.doFinal(word.getBytes("UTF-8"));
            //prepend salt and vi
            byte[] buffer = new byte[saltBytes.length + ivBytes.length + encryptedTextBytes.length];
            System.arraycopy(saltBytes, 0, buffer, 0, saltBytes.length);
            System.arraycopy(ivBytes, 0, buffer, saltBytes.length, ivBytes.length);
            System.arraycopy(encryptedTextBytes, 0, buffer, saltBytes.length + ivBytes.length,
                    encryptedTextBytes.length);
            String encreptedKeyValue = new Base64().encodeToString(buffer);
            System.out.println("Encrypted value : "+encreptedKeyValue);
            return encreptedKeyValue;
            //return Base64.encodeBase64String(buffer);
        }catch(BadPaddingException | InvalidParameterSpecException |
               NoSuchAlgorithmException |
               InvalidKeySpecException | NoSuchPaddingException |
               InvalidKeyException |
               IllegalBlockSizeException | UnsupportedEncodingException ex2){
            final Exception ex = null;
            final Exception e = ex;
            return "ER001" + e.toString();
        }
    }

    @SuppressWarnings("null")
    public static String decrypt(final String encryptedText, final String password){
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            //strip off the salt and iv
            ByteBuffer buffer = ByteBuffer.wrap(new Base64().decode(encryptedText));
            byte[] saltBytes = new byte[20];
            buffer.get(saltBytes, 0, saltBytes.length);
            byte[] ivBytes1 = new byte[cipher.getBlockSize()];
            buffer.get(ivBytes1, 0, ivBytes1.length);
            byte[] encryptedTextBytes = new byte[buffer.capacity() - saltBytes.length - ivBytes1.length];
            buffer.get(encryptedTextBytes);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, 50, 128);
            SecretKey secretKey = factory.generateSecret(spec);
            SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(ivBytes1));
            byte[] decryptedTextBytes = null;
            try {
                decryptedTextBytes = cipher.doFinal(encryptedTextBytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new String(decryptedTextBytes);
        }catch(NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException
               | InvalidKeyException | InvalidAlgorithmParameterException ex2){
            final Exception ex = null;
            final Exception e = ex;
            return "ER001" + e.toString();
        }
    }

    public static void main(final String[] args) throws Exception {
        String text = "PLAIN TEXT";
        String encryptedText = ESBAES128Encryption.encrypt(text, "DCOM0v987c7b2098fg022e908l4400x0300e000");
        System.out.println("Encrypted Text :" + encryptedText);
        System.out.println("Decrypted Text :" + ESBAES128Encryption.decrypt(encryptedText, "DCOM0v987c7b2098fg022e908l4400x0300e000"));
    }
}
