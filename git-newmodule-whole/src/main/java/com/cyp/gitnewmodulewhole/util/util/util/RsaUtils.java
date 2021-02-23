package com.cyp.gitnewmodulewhole.util.util.util;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


/**
 * @author changshengee
 */
public class RsaUtils {
    private static final Logger logger = LoggerFactory.getLogger(RsaUtils.class);


    public static final String SIGNATURE_ALGORITHM = "SHA256WithRSA";
    public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCUBXoFJ3io06nRGuT9Hx+Z/piL0MpvO6MhNyH89Yy9DMOXuO2CvX7Fj9t+Gn5VDA92G82gLWW5taLcSELsU8L1ogextImNLWtfxlpXfoUed1TQVhuFhb4D8REHPRuW+KdWM1XLQYFMSi2a2OK1oisMsexYqZiQ6Ew1TK0XX4j13QIDAQAB";
    public static final String PRIVATE_KEY_PKCS1 = "MIICWwIBAAKBgQCUBXoFJ3io06nRGuT9Hx+Z/piL0MpvO6MhNyH89Yy9DMOXuO2CvX7Fj9t+Gn5VDA92G82gLWW5taLcSELsU8L1ogextImNLWtfxlpXfoUed1TQVhuFhb4D8REHPRuW+KdWM1XLQYFMSi2a2OK1oisMsexYqZiQ6Ew1TK0XX4j13QIDAQABAoGABrISuW32JsjgSx2o0wxX3RrnopdwuMRdVjDMwEkJMzoDFPdgAwR4Wg5uUs92/HjdsC2EySSUj+h38/fu0wrc7DbLlhYFQHTQWs2OghB285MMFZUz2LHWPcdD14iYFIWfaIMvqZsPm0ULnsg8D88lAebiJTlo3i6cFjsZBhFJ9v8CQQCtQ0HelJscEO34ctOeOevvjMtVrve7EG5nMhvFkgtv14Wkw/D9zmREfIPbseHvrqpzfjWVq43KbWYcbjFzvaGXAkEA2rSOyO5idBLYkxzfSRWcUM1y3Sdvdxd9JIXGgy93cHcz23Q1Ik3ip7QgizcgiRgqH1aYjzCe0SnosMNwaGbqqwJAJHD48a+f0A9ffdno2GamUQPz4FmkkRurnNjVLoDBFwzldvofPcKjJCRsN1D6jEbYYuIwswIaGHFaALDMheNkkQJAOnW1DQSbkIdRGNHI5ZI/PGIOaAsYgm7m5pJTo9FWTduvIuQHJ+pFwaomYNAVhE/PQp01HmFSsnpPVqCHNYD9DQJATr5xHYFhVnzMJSX4+bKjVPic/CBQ2Wzf3NqeBae8aVubfzGS327mOZR2EpRJnfuch9LSzONqGjGWMLLYVrhjoQ==";
    public static final String PRIVATE_KEY_PKCS8 = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJQFegUneKjTqdEa\n" +
            "5P0fH5n+mIvQym87oyE3Ifz1jL0Mw5e47YK9fsWP234aflUMD3YbzaAtZbm1otxI\n" +
            "QuxTwvWiB7G0iY0ta1/GWld+hR53VNBWG4WFvgPxEQc9G5b4p1YzVctBgUxKLZrY\n" +
            "4rWiKwyx7FipmJDoTDVMrRdfiPXdAgMBAAECgYAGshK5bfYmyOBLHajTDFfdGuei\n" +
            "l3C4xF1WMMzASQkzOgMU92ADBHhaDm5Sz3b8eN2wLYTJJJSP6Hfz9+7TCtzsNsuW\n" +
            "FgVAdNBazY6CEHbzkwwVlTPYsdY9x0PXiJgUhZ9ogy+pmw+bRQueyDwPzyUB5uIl\n" +
            "OWjeLpwWOxkGEUn2/wJBAK1DQd6UmxwQ7fhy05456++My1Wu97sQbmcyG8WSC2/X\n" +
            "haTD8P3OZER8g9ux4e+uqnN+NZWrjcptZhxuMXO9oZcCQQDatI7I7mJ0EtiTHN9J\n" +
            "FZxQzXLdJ293F30khcaDL3dwdzPbdDUiTeKntCCLNyCJGCofVpiPMJ7RKeiww3Bo\n" +
            "ZuqrAkAkcPjxr5/QD1992ejYZqZRA/PgWaSRG6uc2NUugMEXDOV2+h89wqMkJGw3\n" +
            "UPqMRthi4jCzAhoYcVoAsMyF42SRAkA6dbUNBJuQh1EY0cjlkj88Yg5oCxiCbubm\n" +
            "klOj0VZN268i5Acn6kXBqiZg0BWET89CnTUeYVKyek9WoIc1gP0NAkBOvnEdgWFW\n" +
            "fMwlJfj5sqNU+Jz8IFDZbN/c2p4Fp7xpW5t/MZLfbuY5lHYSlEmd+5yH0tLM42oa\n" +
            "MZYwsthWuGOh";

    /**
     * BASE64解码
     *
     * @param bytes
     * @return
     */
    public static byte[] decodeBase64(byte[] bytes) {
        byte[] result = null;
        try {
            result = Base64.decodeBase64(bytes);
        } catch (Exception e) {
            return null;
        }
        return result;
    }


    /**
     * 使用getPublicKey得到公钥,返回类型为PublicKey
     *
     * @param key String to PublicKey
     * @throws Exception e
     */
    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    /**
     * 转换私钥
     *
     * @param key String to PrivateKey
     * @throws Exception e
     */
    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(key);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(keyBytes));
    }


    /**
     * 签名
     *
     * @param data str
     * @return byte[]
     * @throws Exception e
     */
    public static byte[] sign(byte[] data) throws Exception {
        PrivateKey privateKey = getPrivateKey(PRIVATE_KEY_PKCS8);
        Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
        sig.initSign(privateKey);
        sig.update(data);
        return sig.sign();
    }

    /**
     * 签名
     *
     * @param str str
     * @return byte[]
     */
    public static String sign(String str) {
        try {
            byte[] data = str.getBytes(StandardCharsets.UTF_8);
            PrivateKey privateKey = getPrivateKey(PRIVATE_KEY_PKCS8);
            Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
            sig.initSign(privateKey);
            sig.update(data);
            return toHexString(sig.sign());
        } catch (Exception e) {
            logger.error("生成签名错误:[{}]", str);
            return "";
        }
    }


    /**
     * 验证
     *
     * @param data str
     * @param sign 签名
     * @return boolean
     * @throws Exception e
     */
    public static boolean verify(byte[] data, byte[] sign) throws Exception {
        PublicKey publicKey = getPublicKey(PUBLIC_KEY);
        Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
        sig.initVerify(publicKey);
        sig.update(data);
        return sig.verify(sign);
    }

    /**
     * 加密
     *
     * @param min 明文
     * @return 16进制 密文
     * @throws Exception e
     */
    public static String encrypt(String min) throws Exception {
        return toHexString(encrypt(min.getBytes()));
    }

    /**
     * 加密
     *
     * @param mi 密文
     * @return 16进制 密文
     * @throws Exception e
     */
    public static String decrypt(String mi) throws Exception {
        return new String(decrypt(toByteArray(mi)));
    }


    private static byte[] encrypt(byte[] btPlaintext) throws Exception {
        PublicKey publicKey = getPublicKey(PUBLIC_KEY);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(btPlaintext);
    }


    private static byte[] decrypt(byte[] btEncrypted) throws Exception {
        PrivateKey privateKey = getPrivateKey(PRIVATE_KEY_PKCS8);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(btEncrypted);
    }

    /**
     * 16进制的字符串表示转成字节数组
     *
     * @param hexString 16进制格式的字符串
     * @return 转换后的字节数组
     **/
    public static byte[] toByteArray(String hexString) {
        if (StringUtils.isEmpty(hexString)) {
            throw new IllegalArgumentException("this hexString must not be empty");
        }
        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() / 2];
        int k = 0;
        //因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
        for (int i = 0; i < byteArray.length; i++) {
            byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
            byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
            byteArray[i] = (byte) (high << 4 | low);
            k += 2;
        }
        return byteArray;
    }

    /**
     * 字节数组转成16进制表示格式的字符串
     *
     * @param b 需要转换的字节数组
     * @return 16进制表示格式的字符串
     **/
    private static String toHexString(byte[] b) {
        StringBuilder result = new StringBuilder();
        String hex;
        for (byte value : b) {
            hex = Integer.toHexString(value & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            result.append(hex.toUpperCase());
        }
        return result.toString();
    }

}