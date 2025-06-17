package cn.beforedark.userservice.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @Description:
 * @Author: yjy
 * @Date: 2025/6/18 0:20
 */
public class PasswordUtil {
    private static final SecureRandom random = new SecureRandom(); // 安全随机数生成器

    public static String getSHA256Hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateRandomString(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("长度必须为正数");
        }
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(string.length());
            sb.append(string.charAt(randomIndex));
        }
        return sb.toString();
    }

}
