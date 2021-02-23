//package com.cyp.gitnewmodulewhole.util.util;
//
//import com.alibaba.fastjson.JSONObject;
//import com.asiainfo.openplatform.common.util.Base64Utils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.io.ClassPathResource;
//
//import javax.crypto.Cipher;
//import java.io.*;
//import java.security.*;
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//import java.util.HashMap;
//import java.util.Map;
//
//
///**
// * RSA解密工具类
// */
//public class RSAUtil {
//    private static final Logger logger = LoggerFactory.getLogger(RSAUtil.class);
////    public static final String PUBLICKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCPYIUTUYq9IHnnQGXOCOmrJLh4nJ0/0Oa9E1OmkAVNeWMRIQpojmh1zGq/kd0Mygc200PgpPpdyqWO/GpukNSS9JrdILQJB52AgqekSsMJhGhrCLek31OxEy3q3Z440+jj+6/4L+TXklWEI7yQfLGroMrEt4l0tX0WhEP54f7CjwIDAQAB";
////    public static final String PRIVATEKEY= "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMq1J234czfBO7QrJFUK+6VigVJBLgQr/fUM0RCv4nlPIrjCjflql1N1hadeLBGNQts/j/5DMiuTNm4WCJ++ni5hsNZr3/9yBPg+5RSJOeQmkjy71l82zHsHfCMh4kVRRW3ztAK+KH0Wm1aLQcaUvlqyQZk7pTWes1cXE5H0sUg9AgMBAAECgYAbnhzWJdCE2yXoQSx9DbcFbGtUKp87YEcEeQ+O53fCsV54r8EqJzSg4VUpXXJBne5q8rkKmlsehrsWupfIM+9XAkWfk8d5cLkQizlcqzbWkoA33/+YZf9iZ3FIIZSGa/m5IjuxNlo5aUKvyfOXTgL5OpWpWilXoSbIAUwd8frx3QJBAO2B9IxP4VhuVBQmuCf9Qg6y7SpuBWnszTOcEhOw3WKUDGov3kvrbezBn9eoiTpVYloBqNBtYy2mETVH94hxTRcCQQDafY8PnQqvLWI+s3gWel39pQqUjEOBl0YwNCQgF+OaZaikPgBR6gkvo5xdFqM7NVsoB2cIxZqxFxo+OdW1/nHLAkABqsPYqEbgpAWbDpqETVbFW6QmhBctoyfdkN7fnIIxSvC7XhKlXcWrv8Ard1dfPXIvR4uzytDDZUMBqLuoDYOJAkEAqYC9KvS/ZDXGQTSEVpPqNSwD8Eh82p2cQytAV3GRDqgNVBYRs3roU4APf5xfWEDFjmFnysNahkaRAnNl28IhTwJAGGRFkcNixVzI0KQorQw6bomKJBZRPY8ZQmFgtPvU6BCBqejbeQXx9THW4ZbA3rIR8FO+NlN+bR1h05qyP3E+fw==";
//  //测试环境
//   // public static final String PUBLICKEY =  "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCOVCi7eo5IgIbmKSAVXPvzP172mOELzxWnnHs2mkvR5s7keM6ZmcUOWG6nwrmI4LCSgdtEVKv0AVnbvtasdJQHE0BF2rCVt5tyotLogADPUHw17p8dj/4iaAN62VnuFl3eApsnplH93vcZ5FUI1IpxhgzCr8qxxunSjdGFgfVXPQIDAQAB";
//   // public static final String PRIVATEKEY= "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAI5UKLt6jkiAhuYpIBVc+/M/XvaY4QvPFaecezaaS9HmzuR4zpmZxQ5YbqfCuYjgsJKB20RUq/QBWdu+1qx0lAcTQEXasJW3m3Ki0uiAAM9QfDXunx2P/iJoA3rZWe4WXd4CmyemUf3e9xnkVQjUinGGDMKvyrHG6dKN0YWB9Vc9AgMBAAECgYAjhDjN391Vlk0TbjvFWPi+UJf/7VJrQffjZZcRnxtAe9oxBTx48/hKhiLG1j66O2eUh7cRrBdkwlmMDmk/i6/MXOY5+ktwg9eIQQ0xs7vVhw2KRaVdUsHEQzpVyiU9+eL7hB5M0sbGYsBmSKnyAXq2k8eQr5hPVbFhbNDuf/TFAQJBAMLIlQLz40caea2ovJis+zlvnmcLjb0Jly6NWTU6/Wvth8S/xQZnzn3tbrStADAbrmhNDnUVNLzoSdAv3CQWhl0CQQC7D0xmkfsteV0BukRvHVWAKZfS+FsxzKRxTeq4dFg2diNZmR/MSJb7fu4Cug5pcDuUPq3jGG+zvjy5Nim2e0ZhAkB9Xqk6e0vACjRjKAYrprsUXtlvraoPEEs0dVoDvvI6M2p9oojn9Iyd1OK6e9dxH4AENgSmK34EUOahjwx8VdspAkBGgkK7GuWBw5BSOWLYO0diMsteo2zEfa2yY7tI4dnqVWeHu1coCmiWzcZrUrRh/AMJIwMqaaiZKOj8qzTX6umhAkBCyY1CtPyQlCGllIucyoPz+0CDbi/711vS+FvmQB4OC589PifcdbD9R6FpUbUIlSmUxb44O4jgaD0L2lzoM7/T";
//
// //正式环境
// //   public static final String PUBLICKEY =  "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnGUFh4f/bCyIZj19Z2TsGilfVKjj24RQqfdIs3D4KS3S1HTTyLSbUQVGe7f0RflKJwJqdvG1cEfZimS3AxrD5mkjiWqsa474uNDqzxlBY2gAQSTzqBvEzvYpaGT77y/f7ApOm4tFb5w4gDn55uZmY4jyfiEEhT3eEfyzhFjxvjwIDAQAB";
//
//    public static final String PUBLICKEY ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCW975Kc1/joQTmOvXWdXrW9wwxslFus6xnMl+mPTyu1GzRK9Q3vgjob36CSmizRV/BW/gfXV2raPT7vf9mI+sBNIEflMYzv80Ihk9P7ZPDSlmNpvGJ1Y0hhPS21OolNkh66sC3EjU6GjU3CS/+aqQKmrCoZGpyaJfpvFYEwDw03QIDAQAB";
//    public static final String PRIVATEKEY= "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKcZQWHh/9sLIhmPX1nZOwaKV9UqOPbhFCp90izcPgpLdLUdNPItJtRBUZ7t/RF+UonAmp28bVwR9mKZLcDGsPmaSOJaqxrjvi40OrPGUFjaABBJPOoG8TO9iloZPvvL9/sCk6bi0VvnDiAOfnm5mZjiPJ+IQSFPd4R/LOEWPG+PAgMBAAECgYAm9tqqKnrw5u2yrB3944vCAKxuhoP1/ZIoPmKuF0VYPTQfr4nTFvhA8mJH/xLN63jvqjvjoDaYC5A6eaGTnEFT8k7xocUBHMvNNJjIhI/U6wykw2zWqCWRFMQXT1RLPqFXekmKYyEL44FTZB95cYiTiAJossgpGPvtoWcuc9uVYQJBANKX+WqYVULNqYsm1AtZI2PWaEn8nh4UQ29ZUuYrzCpkh+TdedmPDxNvIa2UYYVxo9RLXW6vhHjMp81m0Vn4JxcCQQDLIILOqOLhaxt8hKlU6IJwEoq/VU1ESk6UIIsLnU+tscS8mfz7IUg6OMsG6Ny3255WceZQXbfBk5my3Z3oH0ZJAkEAoWdTBOyt5B5mRD1FJVFzO1CX66TOtvUG3i+SxtBokVEtii5o9mKbxmRVZokj2TfIvavpdyzUlhUcwuN7rr3vjwJAIPAFpgMmvwzCKT/NwXHubMPk8b+gRtmRwl1AjsKUgALadwa1SfeMobxB1738xGd9VmEjypZXzLDldGaRS2l+2QJAQgmt0FjNoGQhCY8VPUjS1KAFI8WU2jG74ey/R6JnKNWLV7KjAmJ0hsZZmmJacDXBtzMpJNV9TA6rlWFDriQEYg==";
////    //	static{
////		try {
////			Map<String, Object> keyMap = genKeyPair();
////			publicKey = getPublicKey(keyMap);
////			privateKey = getPrivateKey(keyMap);
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////	}
//
//    /**
//     * 加密算法RSA
//     */
//    public static final String KEY_ALGORITHM = "RSA";
//
//    /**
//     * 签名算法
//     */
//    public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
//
//    /**
//     * 获取公钥的key
//     */
//    private static final String PUBLIC_KEY = "RSAPublicKey";
//
//    /**
//     * 获取私钥的key
//     */
//    private static final String PRIVATE_KEY = "RSAPrivateKey";
//
//    /**
//     * RSA最大加密明文大小
//     */
//    private static final int MAX_ENCRYPT_BLOCK = 117;
//
//    /**
//     * RSA最大解密密文大小
//     */
//    private static final int MAX_DECRYPT_BLOCK = 256;
//
//    /** *//**
//     * <p>
//     * 生成密钥对(公钥和私钥)
//     * </p>
//     *
//     * @return
//     * @throws Exception
//     */
//    public static Map<String, Object> genKeyPair() throws Exception {
//        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
//        keyPairGen.initialize(1024);
//        KeyPair keyPair = keyPairGen.generateKeyPair();
//        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//        Map<String, Object> keyMap = new HashMap<String, Object>(2);
//        keyMap.put(PUBLIC_KEY, publicKey);
//        keyMap.put(PRIVATE_KEY, privateKey);
//        return keyMap;
//    }
//
//    /** *//**
//     * <p>
//     * 用私钥对信息生成数字签名
//     * </p>
//     *
//     * @param data 已加密数据
//     *
//     * @return
//     * @throws Exception
//     */
//    public static String sign(byte[] data,String privateKey) throws Exception {
//
//        byte[] keyBytes = Base64Utils.decode(privateKey);
//        System.out.println("加签私匙--------------:"+privateKey);
//        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
//        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
//        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
//        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
//        signature.initSign(privateK);
//        signature.update(data);
//        return Base64Utils.encode(signature.sign());
//    }
//
//    /** *//**
//     * <p>
//     * 校验数字签名
//     * </p>
//     *
//     * @param data 已加密数据
//     * @param sign 数字签名
//     *
//     * @return
//     * @throws Exception
//     *
//     */
//    public static boolean verify(byte[] data, String sign,String publicKey)
//            throws Exception {
////        String publicKey="MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBANYwRXG6GFbdJLnk42oW/gt7C9lUitez/3LI4zGqe3lkfBDsh0l0ybNHSHKs6Tx+sNEqvhiyEFaJK/ay6RUk2p9YKCZwqDMgUkYbEZTti3Sn3NfAijuhPhtJC2zWTrZBmC86XKBhC7ds9HJt9xx+F9bgI/JThDO+QaNJU/F6KhVlAgMBAAECgYAWMcRQZ480GRBALwadrKpAeEyfBZKpjV5P/58DO3418wKkIk5Wf0KTUDSipWY5vYsG8Z3nIzRsMySaGKnsZfg9UAaVtjCPDJ/SFV5WHnuz8rzz4kG/FlTIv7QBERN9+H6S3NZGqIffgSEsaRJkSV9oU4HNuo14Z6Id2OohxAy14QJBAP+5o4ZDVv+3LbOBqSSwIj3Y9Qo3YgObS2KLEQ+86oie7mheYsbjwE3+PrTJiYDmo+gLGhyrSga3golRJd27wW0CQQDWazQ2fnJ0tm/HaOLlGTQ9bGVTAY/9ngWGWIWAzyCA5dNogwdAHaKRC3r/wRGfOaeRq2bFS+2O4fGXCP1dO6DZAkBRpzbdohbfY+AF1zro6gyk7uefMXvsZuO1PW5fNhU1NnotfSXRF9vJi4r+MvPi4sInT5Qw30ityF639d8/Y7opAkBIJQwNZeBW+ueDXfwx/5f/LtCs7DKpsBjFylUpMQgLtsi6OpQe85m2WfmJwkmOnJSQQ+6xZcnJsKZcHk85po2JAkBvUMECrktlJopDwXOLPKo1FNHZTH/nU3eI4C6U2JY+I9snjDERfDlZxtM4PKAAQE3ovbU8RZH6VTXpiDV7gOz9";
//        byte[] keyBytes = Base64Utils.decode(publicKey);
//        System.out.println("publicKey----"+publicKey);
////        byte[] keyBytes = Base64Utils.decode(publicKey);
//        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
//        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
//        PublicKey publicK = keyFactory.generatePublic(keySpec);
//        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
//        signature.initVerify(publicK);
//        signature.update(data);
//        return signature.verify(Base64Utils.decode(sign));
//    }
//
//
//    /**
//     * <P>
//     * 私钥解密
//     * </p>
//     *
//     * @param encryptData 已加密数据
//     * @param privateKey 私钥(BASE64编码)
//     * @return
//     * @throws Exception
//     */
//    public static String decryptByPrivateKey(String privateKey, String encryptData, Provider provider) {
//        try{
//            logger.info("私钥解密开始，privateKey：" + privateKey + "/n ------ encryptData:" + encryptData);
//            byte[] encryptedData = Base64Utils.decode(encryptData);
//            byte[] keyBytes = Base64Utils.decode(privateKey);
//            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
//            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
//            Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
//            Cipher cipher = provider == null ? Cipher.getInstance(keyFactory.getAlgorithm()) :
//                    Cipher.getInstance(keyFactory.getAlgorithm(), provider);
//            cipher.init(Cipher.DECRYPT_MODE, privateK);
//            int inputLen = encryptedData.length;
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            int offSet = 0;
//            byte[] cache;
//            int i = 0;
//            // 对数据分段解密
//            while (inputLen - offSet > 0) {
//                if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
//                    cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
//                } else {
//                    cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
//                }
//                out.write(cache, 0, cache.length);
//                i++;
//                offSet = i * MAX_DECRYPT_BLOCK;
//            }
//            byte[] decryptedData = out.toByteArray();
//            out.close();
//            logger.info("私钥解密结束！");
//            return new String(decryptedData, "utf-8");
//        } catch(Exception e) {
//            logger.info("私钥解密异常：" + e.getMessage());
//            logger.error(e.getMessage());
//            return "";
//        }
//    }
//
//
//
//    /**
//     * <p>
//     * 公钥解密
//     * </p>
//     *
//
//     * @param publicKey 公钥(BASE64编码)
//     * @return
//     * @throws Exception
//     */
//    public static String decryptByPublicKey(String publicKey, String encryptData, Provider provider){
//        try{
//            logger.info("公钥解密开始，publicKey：" + publicKey);
//            byte[] encryptedData = Base64Utils.decode(encryptData);
//            byte[] keyBytes = Base64Utils.decode(publicKey);
//            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
//            KeyFactory keyFactory = provider == null ? KeyFactory.getInstance(KEY_ALGORITHM) :
//                    KeyFactory.getInstance(KEY_ALGORITHM, provider);
//            Key publicK = keyFactory.generatePublic(x509KeySpec);
//            Cipher cipher = provider == null ? Cipher.getInstance(keyFactory.getAlgorithm()) :
//                    Cipher.getInstance(keyFactory.getAlgorithm(), provider);
//            cipher.init(Cipher.DECRYPT_MODE, publicK);
//            int inputLen = encryptedData.length;
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            int offSet = 0;
//            byte[] cache;
//            int i = 0;
//            // 对数据分段解密
//            while (inputLen - offSet > 0) {
//                if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
//                    cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
//                } else {
//                    cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
//                }
//                out.write(cache, 0, cache.length);
//                i++;
//                offSet = i * MAX_DECRYPT_BLOCK;
//            }
//            byte[] decryptedData = out.toByteArray();
//            out.close();
//            logger.info("公钥解密结束！");
//            return new String(decryptedData, "utf-8");
//        } catch(Exception e) {
//            logger.info("公钥解密异常：" + e.getMessage());
//            logger.error(e.getMessage());
//            return "";
//        }
//
//    }
//
//
//
//    /**
//     * <p>
//     * 公钥加密
//     * </p>
//     * @param publicKey 公钥(BASE64编码)
//     * @return
//     * @throws Exception
//     */
//    public static String encryptByPublicKey(String publicKey, String encryptData, Provider provider) {
//        try{
//            logger.info("公钥加密开始，publicKey：" + publicKey);
//            byte[] data = encryptData.getBytes();
//            byte[] keyBytes = Base64Utils.decode(publicKey);
//            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
//            KeyFactory keyFactory = provider == null ? KeyFactory.getInstance(KEY_ALGORITHM) :
//                    KeyFactory.getInstance(KEY_ALGORITHM, provider);
//            Key publicK = keyFactory.generatePublic(x509KeySpec);
//            // 对数据加密
//            Cipher cipher = provider == null ? Cipher.getInstance(keyFactory.getAlgorithm()) :
//                    Cipher.getInstance(keyFactory.getAlgorithm(), provider);
//            cipher.init(Cipher.ENCRYPT_MODE, publicK);
//            int inputLen = data.length;
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            int offSet = 0;
//            byte[] cache;
//            int i = 0;
//            // 对数据分段加密
//            while (inputLen - offSet > 0) {
//                if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
//                    cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
//                } else {
//                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
//                }
//                out.write(cache, 0, cache.length);
//                i++;
//                offSet = i * MAX_ENCRYPT_BLOCK;
//            }
//            byte[] encryptedData = out.toByteArray();
//            out.close();
//            logger.info("公钥加密结束！");
//            return Base64Utils.encode(encryptedData);
//        } catch(Exception e) {
//            logger.info("公钥加密异常：" + e.getMessage());
//            logger.error(e.getMessage());
//            return "";
//        }
//
//    }/**
//
//
//    /**
//     * <p>
//     * 私钥加密
//     * </p>
//     *
//     * @param privateKey 私钥(BASE64编码)
//     * @return
//     * @throws Exception
//     */
//    public static String encryptByPrivateKey(String privateKey, String encryptData, Provider provider) {
//        try{
//            logger.info("私钥加密开始，privateKey：" + privateKey);
//            byte[] data = encryptData.getBytes();
//            byte[] keyBytes = Base64Utils.decode(privateKey);
//            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
//            KeyFactory keyFactory = provider == null ? KeyFactory.getInstance(KEY_ALGORITHM) :
//                    KeyFactory.getInstance(KEY_ALGORITHM, provider);
//            Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
//            Cipher cipher = provider == null ? Cipher.getInstance(keyFactory.getAlgorithm()) :
//                    Cipher.getInstance(keyFactory.getAlgorithm(), provider);
//            cipher.init(Cipher.ENCRYPT_MODE, privateK);
//            int inputLen = data.length;
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            int offSet = 0;
//            byte[] cache;
//            int i = 0;
//            // 对数据分段加密
//            while (inputLen - offSet > 0) {
//                if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
//                    cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
//                } else {
//                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
//                }
//                out.write(cache, 0, cache.length);
//                i++;
//                offSet = i * MAX_ENCRYPT_BLOCK;
//            }
//            byte[] encryptedData = out.toByteArray();
//            out.close();
//            logger.info("私钥加密结束！");
//            return Base64Utils.encode(encryptedData);
//        } catch(Exception e) {
//            logger.info("私钥加密异常：" + e.getMessage());
//            logger.error(e.getMessage());
//            return "";
//        }
//    }
//
//    /** *//**
//     * <p>
//     * 获取私钥
//     * </p>
//     *
//     * @param keyMap 密钥对
//     * @return
//     * @throws Exception
//     */
//    public static String getPrivateKey(Map<String, Object> keyMap)
//            throws Exception {
//        Key key = (Key) keyMap.get(PRIVATE_KEY);
//        return Base64Utils.encode(key.getEncoded());
//    }
//
//    /** *//**
//     * <p>
//     * 获取公钥
//     * </p>
//     *
//     * @param keyMap 密钥对
//     * @return
//     * @throws Exception
//     */
//    public static String getPublicKey(Map<String, Object> keyMap)
//            throws Exception {
//        Key key = (Key) keyMap.get(PUBLIC_KEY);
//        return Base64Utils.encode(key.getEncoded());
//    }
//
//    /**
//     * 从密钥文件中加载密钥
//     * @param path 文件路径
//     * @return 密钥
//     */
//    public static String loadKeyFromFile(String path) {
//        StringBuilder sb = new StringBuilder();
//
//        InputStream input = null;
//        Reader reader=null;
//        BufferedReader br=null;
//        try {
//            if (path.startsWith("pafarsc:")) {
//                // 从组件资源中读取密钥文件
//                input = RSAUtil.class.getClassLoader().getResourceAsStream(path);
//            }
//            else {
//                input = new ClassPathResource(path).getInputStream();
//            }
//            reader = new InputStreamReader(input);
//            br = new BufferedReader(reader);
//
//            String readLine = null;
//            while ((readLine = br.readLine()) != null) {
//                if (readLine.charAt(0) == '-') {
//                    continue;
//                }
//
//                sb.append(readLine);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException("加载密钥失败, 文件：" + path, e);
//        } finally {
//            if (null!=input) {
//                try {
//                    input.close();
//                } catch (IOException e) {
//                    logger.error("loadKeyFromFile中input流关闭异常：",e);
//                }
//            }
//            if(null!=reader) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    logger.error("loadKeyFromFile中reader流关闭异常：",e);
//                }
//            }
//            if(null!=br) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    logger.error("loadKeyFromFile中br流关闭异常：",e);
//                }
//            }
//        }
//
//        return sb.toString();
//    }
//
//    public static void main(String[] args) throws Exception {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("","");
//        Map<String, Object> keyMap =  RSAUtil.genKeyPair();
//        //   	System.out.println(keyMap.get(PUBLIC_KEY));
//        //   	System.out.println(keyMap.get(PRIVATE_KEY));
////
////        System.out.println(getPrivateKey(keyMap));
////        System.out.println(getPublicKey(keyMap));
//        String test="Y93VGvtml1ujTEiTkqi9kQ==";
//
//        String sign="";// sign(test.getBytes("utf-8"),PRIVATEKEY);
//
//        sign="DKfIIpvVtbNt9nK9hqsDvbMBt/Ps78En1Do++gAQwCJC5n+QSaPi5kubvs+BZHqwDwjOpgGBbP3sFP+t8S/jjr80OTBK8YcpGCoKJotybjzT6tlZsQYtIDnSBCjTryqkZOn32JMwPIpnRQTkaMo4O0WPqVQ/RRZNC80/Sj95zaQ=";
//        boolean result = verify(test.getBytes("utf-8"),sign,PUBLICKEY);
//        System.out.println("sign ="+sign );
//        System.out.println("验签结果"+result );
//    }
//
//}
//
//
