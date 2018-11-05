package com.sharan.encryptionAlgorithms;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AES128Encyrption {

    private static byte[] encodedKey={};
//    public AES128Encyrption() {
//        try{
//
//        }catch(NoSuchAlgorithmException exception) {
//            System.out.println(exception.getMessage());
//        }
//    }

    public static String encrypt(String text) {
        try {
            Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(encodedKey, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cipherText = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
            String encryptedString = new String(Base64.getEncoder().encode(cipherText),StandardCharsets.UTF_8);
            return encryptedString;

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String decrypt(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            SecretKeySpec secretKey = new SecretKeySpec(encodedKey, "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] cipherText = Base64.getDecoder().decode(encryptedText.getBytes(StandardCharsets.UTF_8));
            String decryptedString = new String(cipher.doFinal(cipherText),StandardCharsets.UTF_8);
            return decryptedString;
        } catch (Exception e) {
            System.out.println(e.getMessage());        }
        return null;

    }





}
