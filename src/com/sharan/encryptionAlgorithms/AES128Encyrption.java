package com.sharan.encryptionAlgorithms;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AES128Encyrption {

    private static byte[] encodedKey={0x2d, 0x2a, 0x2d, 0x42, 0x55, 0x49, 0x4c, 0x44, 0x41, 0x43, 0x4f, 0x44, 0x45, 0x2d, 0x2a, 0x2d};
//45,42,45,66,85,73,76,68,65,67,79,68,69,45,42,45

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
