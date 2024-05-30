package com.example.finacleservice.enc;


import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

public class AES128 {

    private static final Logger logger = LogManager.getLogger(AES128.class);

    @SuppressWarnings("null")
    public static String encrypt(final String word, final String password) {
        try {
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
            ivBytes = params.getParameterSpec(IvParameterSpec.class).getIV();
            byte[] encryptedTextBytes = cipher.doFinal(word.getBytes("UTF-8"));

            // Prepend salt and iv
            byte[] buffer = new byte[saltBytes.length + ivBytes.length + encryptedTextBytes.length];
            System.arraycopy(saltBytes, 0, buffer, 0, saltBytes.length);
            System.arraycopy(ivBytes, 0, buffer, saltBytes.length, ivBytes.length);
            System.arraycopy(encryptedTextBytes, 0, buffer, saltBytes.length + ivBytes.length, encryptedTextBytes.length);

            return new Base64().encodeToString(buffer);
        } catch (BadPaddingException | InvalidParameterSpecException | NoSuchAlgorithmException |
                 InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException |
                 IllegalBlockSizeException | UnsupportedEncodingException ex2) {
            final Exception ex = null;
            final Exception e = ex;
            return "ER001" + e.toString();
        }
    }

    @SuppressWarnings("null")
    public static String decrypt(final String encryptedText, final String password) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            // Strip off the salt and iv
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
            byte[] decryptedTextBytes = cipher.doFinal(encryptedTextBytes);

            return new String(decryptedTextBytes);
        } catch (Exception ex) {
            logger.error("Error occurred while decrypting response", ex);
            throw new RuntimeException(ex);
        }
    }

    public static void main(final String[] args) throws Exception {
        //String textToEncrypt = "{\"responseBody\": {\"recordCount\": 1, \"matchFound\": \"TRUE\", \"getAccountStatusRecord\": [{\"accountId\": \"914010008845949\", \"customerId\": \"851736257\", \"status\": \"A\"}]}}";
        String textToEncrypt = "{\"responseBody\":{\"matchFound\":true,\"recordCount\":1,\"basicInfo\":{\"title\":\"MS.\",\"customerFirstName\":null,\"customerMiddleName\":null,\"customerLastName\":\"EIZMARR NWEEBEALEE NG RYIILMTED\",\"motherMaidenName\":null,\"dateOfBirth\":\"2014-09-28\",\"customerName\":\"EIZMARR NWEEBEALEE NG RYIILMTED\",\"customerSex\":null,\"nationality\":null,\"education\":null,\"maritalStatus\":null,\"caste\":null,\"community\":null,\"health\":\"HC01\",\"noOfDependents\":null,\"deleteFlag\":\"N\",\"address\":{\"mailingAddress\":null,\"commonAddress1\":\"NADAOH I ESUM RNAHTILAHKXISIAOR N SDARVAUPGNR\",\"commonAddress2\":\"A\",\"commonAddress3\":\".\"},\"pin\":\"310001\",\"city\":\"AHMEDABAD\",\"state\":\"GUJARAT\",\"country\":\"INDIA\",\"phone1\":\"+01()07020000000\",\"phone2\":\" \",\"mobile\":\" \",\"fax1\":\" \",\"fax2\":\" \",\"emailId\":\" \",\"residentialStatus\":null,\"cKYCReferenceNumber\":null,\"reKycDueDate\":\"2020-07-20 00:00:00\",\"constitutionDescription\":\"PUBLIC LTD COMPANIES\",\"constitutionCode\":\"05\",\"annualIncome\":null,\"sourceOfIncome\":null,\"occupation\":null,\"pan\":\"AANCA4885B\"},\"addressInfo\":[{\"permanentAddress1\":\" \",\"permanentAddress2\":\" \",\"permanentAddress3\":\" \",\"permanentPin\":\" \",\"permanentCity\":\" \",\"permanentState\":\" \",\"permanentCountry\":\" \",\"permanentPhone1\":\" \",\"permanentPhone2\":\" \",\"permanentMobile\":\" \",\"permanentFax1\":\" \",\"permanentFax2\":\" \",\"permanentEmailId\":\" \",\"branch\":\"CONNAUGHT PLACE DEL DL\",\"pan\":\"AANCA4885B\",\"passportNo\":null,\"passportIssueDate\":null,\"passportDet\":null,\"passportExpiryDate\":null,\"visaDetails\":null,\"crmRisksCore\":null,\"cmgriskProfleScore\":1,\"sector\":null,\"companyName\":null,\"tenure\":null,\"workex\":null,\"netIncome\":null,\"department\":null,\"designation\":null,\"occupation\":\"N022\",\"constDescription\":\"PUBLIC LTD COMPANIES\",\"selfEmployee\":null,\"reKycDueDate\":\"2031-07-20 00:00:00\"}],\"officeDetails\":[{\"officeAddress1\":\" \",\"officeAddress2\":\" \",\"officePin\":\" \",\"officeCity\":\" \",\"officeState\":\" \",\"ext\":null,\"std\":null,\"officePhone1\":\" \",\"officeMobile\":\" \",\"officeFax1\":\" \",\"officeEmailId\":\" \",\"formName\":null,\"companyName\":null,\"selfEmpowerShip\":null,\"selfEmpOther\":null,\"grossTourn\":null,\"cadre\":null,\"customerEmployeeId\":null,\"customerEmployeeNo\":null,\"formNo\":null,\"voterId\":null,\"mop\":\"61\",\"accountId\":\"918020041296044\",\"relationshipType\":\"CAA\",\"schemeCode\":\"CAESC\",\"usageFor\":null,\"autoDebitOption\":null,\"autoDebitAccountNo\":null,\"offerId\":null,\"relationAccountId\":\"918020041296044\",\"customerNREFlag\":null,\"reKYCFlag\":\"N\",\"reKYCDate\":null,\"customerVintage\":7,\"customerOpenDate\":\"2015-06-29 12:00:00\",\"riskProfileScore\":1,\"accountStatus\":\"ACTIVE\",\"accountType\":\"CAESC\",\"accountOpenDate\":\"2018-05-02 00:00:00\",\"dateOfIncorporation\":\"2014-07-05 00:00:00\",\"strUserField8\":null,\"lastUnfreezeDate\":\"2018-05-19 17:49:59\",\"balanceAmount\":0,\"customerId\":\"858010554\",\"modeOperation\":\"NON-OPERATIVE, COLLECTION ACCOUNT\",\"label\":\"N.A.\",\"accountCloseDate\":null,\"accountConst\":\"PUBLIC LTD COMPANIES\",\"reKYCVintage\":null,\"constitutionCode\":\"05\",\"customerTypeCode\":null,\"NREFFlag\":null,\"frezCode\":null,\"frezReason\":null,\"frezRemarks\":null,\"reKycDueDate\":\"2031-07-20 00:00:00\"}]}}";
        String encryptedText = AES128.encrypt(textToEncrypt, "key");
        System.out.println("Encrypted Text: " + encryptedText);
        String enc = "HmCzBn67XoiZNZU+8X46gJv7QFoADkCw36/gEjFAQC2CvBqpNv9i3nd264FWpBi9iu/0o6Oz4Rtd8fUmt0a8U4CE9a1bG9A9wCCp761Io8i1icqe";
        //String enc = "R/6W8mROwvWvF+hmTmTK91qNyGahjCb1cQAKCk3YRz2hjle3v/YT9FEHJTqbU3e1yqdMPRHij7/tkc7yNJ+n4imccWmP1Xj/VCHONlt4nP64WO1L";
        System.out.println("Decrypted Text: " + AES128.decrypt(encryptedText, "IBB741345368e9c11e9ae4b0a0950d80000"));
    }
}
