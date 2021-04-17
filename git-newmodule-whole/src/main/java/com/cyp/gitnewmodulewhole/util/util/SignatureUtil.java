package com.cyp.gitnewmodulewhole.util.util;


import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class SignatureUtil {
    private final static String SIGN_TYPE_RSA = "RSA";
    private final static String SIGN_ALGORITHMS = "SHA256WithRSA";
    private final static String CHARSETTING = "UTF-8";
    public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCPYIUTUYq9IHnnQGXOCOmrJLh4nJ0/0Oa9E1OmkAVNeWMRIQpojmh1zGq/kd0Mygc200PgpPpdyqWO/GpukNSS9JrdILQJB52AgqekSsMJhGhrCLek31OxEy3q3Z440+jj+6/4L+TXklWEI7yQfLGroMrEt4l0tX0WhEP54f7CjwIDAQAB";
    public static final String PRIVATE_KEY= "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMq1J234czfBO7QrJFUK+6VigVJBLgQr/fUM0RCv4nlPIrjCjflql1N1hadeLBGNQts/j/5DMiuTNm4WCJ++ni5hsNZr3/9yBPg+5RSJOeQmkjy71l82zHsHfCMh4kVRRW3ztAK+KH0Wm1aLQcaUvlqyQZk7pTWes1cXE5H0sUg9AgMBAAECgYAbnhzWJdCE2yXoQSx9DbcFbGtUKp87YEcEeQ+O53fCsV54r8EqJzSg4VUpXXJBne5q8rkKmlsehrsWupfIM+9XAkWfk8d5cLkQizlcqzbWkoA33/+YZf9iZ3FIIZSGa/m5IjuxNlo5aUKvyfOXTgL5OpWpWilXoSbIAUwd8frx3QJBAO2B9IxP4VhuVBQmuCf9Qg6y7SpuBWnszTOcEhOw3WKUDGov3kvrbezBn9eoiTpVYloBqNBtYy2mETVH94hxTRcCQQDafY8PnQqvLWI+s3gWel39pQqUjEOBl0YwNCQgF+OaZaikPgBR6gkvo5xdFqM7NVsoB2cIxZqxFxo+OdW1/nHLAkABqsPYqEbgpAWbDpqETVbFW6QmhBctoyfdkN7fnIIxSvC7XhKlXcWrv8Ard1dfPXIvR4uzytDDZUMBqLuoDYOJAkEAqYC9KvS/ZDXGQTSEVpPqNSwD8Eh82p2cQytAV3GRDqgNVBYRs3roU4APf5xfWEDFjmFnysNahkaRAnNl28IhTwJAGGRFkcNixVzI0KQorQw6bomKJBZRPY8ZQmFgtPvU6BCBqejbeQXx9THW4ZbA3rIR8FO+NlN+bR1h05qyP3E+fw==";
   /**
     * 获取私钥PKCS8格式（需base64）
     * @param algorithm
     * @param priKey
     * @return PrivateKey
     * @throws Exception
     */
    public static PrivateKey getPrivateKeyFromPKCS8(String algorithm, String priKey) throws Exception {
        if (algorithm == null || "".equals(algorithm) || priKey == null || "".equals(priKey))
            return null;
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        byte[] encodedKey = StreamUtil.readText(new ByteArrayInputStream(priKey.getBytes())).getBytes();
        encodedKey = Base64.decodeBase64(priKey.getBytes());

        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
    }

    /**
     * 通过证书获取公钥（需BASE64，X509为通用证书标准）
     * @param algorithm
     * @param pubKey
     * @return PublicKey
     * @throws Exception
     */
    public static PublicKey getPublicKeyFromX509(String algorithm, String pubKey) throws Exception {

        if (algorithm == null || "".equals(algorithm) || pubKey == null || "".equals(pubKey))
            return null;

        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        StringWriter writer = new StringWriter();
        StreamUtil.io(new InputStreamReader(new ByteArrayInputStream(pubKey.getBytes())), writer);

        byte[] encodeByte = writer.toString().getBytes();
        encodeByte = Base64.decodeBase64(pubKey.getBytes());

        return keyFactory.generatePublic(new X509EncodedKeySpec(encodeByte));
    }

    /**
     * 使用私钥对字符进行签名
     * @param plain  内容体
     * @return String
     * @throws Exception
     */
    public static String sign(String plain) throws Exception {
        if (plain == null || "".equals(plain))
            return null;
        PrivateKey privatekey = getPrivateKeyFromPKCS8(SIGN_TYPE_RSA, PRIVATE_KEY);
        Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
        signature.initSign(privatekey);
        signature.update(plain.getBytes(CHARSETTING));
        byte[] signed = signature.sign();
        return new String(Base64.encodeBase64(signed));
    }

    /**
     * 将内容体、签名信息、及对方公钥进行验签
     * @param plain  内容体
     * @param sign   签名信息
     * @param pubkey  对方公钥
     * @return boolean
     * @throws Exception
     */
    public static boolean virefy(String plain, String sign, String pubkey) throws Exception {
        if (plain == null || "".equals(plain) || sign == null || "".equals(sign) || pubkey == null || "".equals(pubkey))
            return false;
        PublicKey publicKey = getPublicKeyFromX509(SIGN_TYPE_RSA, pubkey);
        Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
        signature.initVerify(publicKey);
        signature.update(plain.getBytes(CHARSETTING));

        return signature.verify(Base64.decodeBase64(sign.getBytes()));
    }

    /**
     * 测试
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        //**  私钥密钥此处简单演示，应做成可配置    **/
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMq1J234czfBO7QrJFUK+6VigVJBLgQr/fUM0RCv4nlPIrjCjflql1N1hadeLBGNQts/j/5DMiuTNm4WCJ++ni5hsNZr3/9yBPg+5RSJOeQmkjy71l82zHsHfCMh4kVRRW3ztAK+KH0Wm1aLQcaUvlqyQZk7pTWes1cXE5H0sUg9AgMBAAECgYAbnhzWJdCE2yXoQSx9DbcFbGtUKp87YEcEeQ+O53fCsV54r8EqJzSg4VUpXXJBne5q8rkKmlsehrsWupfIM+9XAkWfk8d5cLkQizlcqzbWkoA33/+YZf9iZ3FIIZSGa/m5IjuxNlo5aUKvyfOXTgL5OpWpWilXoSbIAUwd8frx3QJBAO2B9IxP4VhuVBQmuCf9Qg6y7SpuBWnszTOcEhOw3WKUDGov3kvrbezBn9eoiTpVYloBqNBtYy2mETVH94hxTRcCQQDafY8PnQqvLWI+s3gWel39pQqUjEOBl0YwNCQgF+OaZaikPgBR6gkvo5xdFqM7NVsoB2cIxZqxFxo+OdW1/nHLAkABqsPYqEbgpAWbDpqETVbFW6QmhBctoyfdkN7fnIIxSvC7XhKlXcWrv8Ard1dfPXIvR4uzytDDZUMBqLuoDYOJAkEAqYC9KvS/ZDXGQTSEVpPqNSwD8Eh82p2cQytAV3GRDqgNVBYRs3roU4APf5xfWEDFjmFnysNahkaRAnNl28IhTwJAGGRFkcNixVzI0KQorQw6bomKJBZRPY8ZQmFgtPvU6BCBqejbeQXx9THW4ZbA3rIR8FO+NlN+bR1h05qyP3E+fw==";
        String publickey ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCPYIUTUYq9IHnnQGXOCOmrJLh4nJ0/0Oa9E1OmkAVNeWMRIQpojmh1zGq/kd0Mygc200PgpPpdyqWO/GpukNSS9JrdILQJB52AgqekSsMJhGhrCLek31OxEy3q3Z440+jj+6/4L+TXklWEI7yQfLGroMrEt4l0tX0WhEP54f7CjwIDAQAB";
        String plain="loginId=test03&userName=test03";
        System.out.println(plain);
        String sign = sign(plain);
        //签名信息
        System.out.println(sign);
        //签名信息
        System.out.println(virefy(plain, sign, publickey));
        //生成最终报文（Json）
       // String body = JsonHelper.preparePostData("1", "1", "subOrgId", dataMap);
      //  System.out.println(body);
    }

}

