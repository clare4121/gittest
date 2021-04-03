package com.cyp.gitnewmodulewhole.util.util;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AESUtil {

    private static final Logger logger = LoggerFactory.getLogger(AESUtil.class);

    /**
     * 生成AES密钥串
     * @return String 密钥
     */
    public static String getKeyStringAES() {
        String key = null;
        try {
            //实例化
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            //设置密钥长度
            kgen.init(128);
            //生成密钥
            SecretKey skey = kgen.generateKey();
            //取得key的二进制编码
            byte[] keys = skey.getEncoded();
            //base64加密key
            key = Base64.encodeBase64String(keys);
            //用MD5编码key
            key = MD5_16(key);
            System.out.println("AES密钥："+key);
        } catch (Exception e) {
            logger.error("AESUtil.getKeyStringAES()异常："+e);
        }
        return key;
    }

    /**
     * AES密钥串转换为密钥
     * @return String 密钥
     */
    public static SecretKey getKeyAES(String key) {
        byte[] raw = Base64.decodeBase64(key);
//        byte[] raw = key.getBytes();
        SecretKey skeyn = new SecretKeySpec(raw,"AES");
        return skeyn;
    }

    /**
     * AES数据加密
     * @param key 密钥
     * @param vector 偏移量
     * @param datas 待加密数据
     * @return
     */
    public static String encodeAES(String key,String vector,String datas){
        String rslt = "";
        //加解密类
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//AES/CBC/NoPadding//AES/ECB/PKCS5Padding
            SecretKey skey =  getKeyAES(key);
            //加密
            IvParameterSpec iv = new IvParameterSpec(new byte[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.ENCRYPT_MODE, skey, iv);
            byte[] enBytes = cipher.doFinal(datas.getBytes("UTF-8"));
            //转化String
            rslt = Base64.encodeBase64String(enBytes);
        } catch (Exception e) {
            logger.error("AESUtil.encodeAES()异常："+e);
        }
        System.out.println("AES加密密匙:"+key);
        System.out.println("AES加密参数:"+datas);
        System.out.println("AES加密密文:"+rslt);
        return rslt;
    }

    /**
     * AES数据解密
     * @param key 密钥
     * @param vector 偏移量
     * @param datas 待解密数据
     * @return
     */
    public static String decodeAES(String key,String vector,String datas){
        String rslt = "";
        //加解密类
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKey skey =  getKeyAES(key);
            //加密
            IvParameterSpec iv = new IvParameterSpec(new byte[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.DECRYPT_MODE, skey,iv);
            byte[] inBytes = Base64.decodeBase64(datas);
            byte[] enBytes = cipher.doFinal(inBytes);
            //转化String
            rslt = new String(enBytes,"UTF-8");
        } catch (Exception e) {
            logger.error("AESUtil.encodeAES()异常："+e);
        }


        return rslt;
    }

    /**
     * 对字符串md5加密
     * @return
     */
    public static String MD5_16(String keyStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(keyStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            System.out.println("MD5(" + keyStr + ",32) = " + result);
            result = buf.toString().substring(8, 24);
            System.out.println("MD5(" + keyStr + ",16) = " + result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String AESkey ="MDEyMzQ1Njc4OWFiY2RlZjAxMjM0NTY3ODlhYmNkZWY=";
        String aaaa = encodeAES("MDEyMzQ1Njc4OWFiY2RlZjAxMjM0NTY3ODlhYmNkZWY=","MDEyMzQ1Njc4OWFiY2RlZjAxMjM0NTY3ODlhYmNkZWY=","asddsad");
        String  aaaaaa="%E8%AF%B7%E6%B1%82%E6%88%90%E5%8A%9F";
        System.out.println("aes加密值"+aaaa);
        System.out.println("111111111111111"+URLDecoder.decode(aaaaaa));;
    }
}
