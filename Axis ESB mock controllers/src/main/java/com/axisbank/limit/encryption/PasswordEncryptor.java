package com.axisbank.limit.encryption;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptor {



    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        BigInteger number = new BigInteger(1,hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while(hexString.length()<64)
        {
            hexString.insert(0,'0');
        }
        return hexString.toString();
    }
    public static void main(String[] args) {

        BufferedReader buf1=null;
        BufferedReader buf2=null;
        String input1= null;
        String input2= null;

        try
        {
            System.out.println("Enter Clear Password :");
            buf1 = new BufferedReader(new InputStreamReader(System.in));
            input1 = buf1.readLine().trim();
        }
        catch (Exception e1)
        {
            System.out.println("\nInput1 ENTER EXCEPTION -" + e1);
        }
        try
        {
            System.out.println("\nEnter Salt :");
            buf2 = new BufferedReader(new InputStreamReader(System.in));
            input2 = buf2.readLine().trim();
        }
        catch (Exception e2)
        {
            System.out.println("\nInput2 ENTER EXCEPTION -" + e2);
        }
        try {



            if((input1 != null && input1.length()>0) && (input2 != null && input2.length()>0)) {
                String s3=input1+input2;
                System.out.println("\nHashed Password Generated For : "+ s3.toUpperCase() );
                System.out.println("\nHashed Password : " + toHexString(getSHA(s3.toUpperCase())));
            }else {

                System.out.println("\n Input values should not empty:");
            }

        }
        catch(NoSuchAlgorithmException e) {

            System.out.println("Exception in SHA algorithm:"+e);
        }
    }

}


