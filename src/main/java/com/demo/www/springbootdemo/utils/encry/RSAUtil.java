package com.demo.www.springbootdemo.utils.encry;



import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;


/**
 * RSA加解密工具类
 */
public class RSAUtil {

    //用于封装随机产生的公钥与私钥
    private static Map<Integer, String> keyMap = new HashMap<>();

    public static final String privateKey="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJrqPdInBev+ksvBvo+rymL1K0+r5" +
            "a+bq+74tZAHWE2oKVaTSNCbkacXoqPRpzaCqCwyy61zeGExppfZBm8tf6AVAcL+58YF0Fuk+0N4ZaxAi2wx//GqqWQs+Rzt5VPJ+yaulAzs" +
            "Eb0tW9o9Vc9VRxl8k0Fpi5Hj5J/pmLZrIj+FAgMBAAECgYAj+0A8rZ+sfsat2ORgDnDFp1hV+wEwVqIKsW3KdEpIT0S6vR7uhRPBkbXPAwU" +
            "pnhNdoLa6JNXTDWs6XcgmzpSTx32WS3450+h1QNdLL+doiEinWxGijvp+UN7CadoeFBnLml3gGjPpTMeDheialQExwwvVKKe4+0VjO4zPDG" +
            "nrAQJBAM3luGYrweNcFxvVsfQG6cpR/C0DeykyojN0Kbq+3/S+wG1y53Ak1HKz4OHftC4liYNXWy9W1fQ/MSbdVaSka+UCQQDAnJmYwmJ64" +
            "I35T+GmgA0r505BCuYZG9pNyrjdko7n5+DaalRWSXuAwXb2SJbFHvWmVEgZOnVRhPdFgZUGP4shAkAjmG1SrInuhoMwOrdzGqbcZWQVXB60" +
            "tp44CwMT19/b7gZSZaUBTDy2P8bHBeeeerrVTArlmjuO6EXVFDq0JgDJAkBLlCdhHcVu2fZbwdCVeOGyPI0kUJaBe8BpjgaESyHwNbixe8+" +
            "kHCluGHwJn+opZ0CVB7VS0PGAD2DH0VUcooqBAkEAvLBZTnNcM/I2xbV6euw9gpEw7uLkT/94McLQOuZjKPWPHKDQOqa+y+CRPYuxIhQsFK" +
            "mlTze7cR+/4QUANvGAow==";

    public static final String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCa6j3SJwXr/pLLwb6Pq8pi9StPq+Wvm6vu+LWQB1hNqClWk0jQm5GnF6Kj0ac2gqgsMsutc3hhMaaX2QZvLX+gFQHC/ufGBdBbpPtDeGWsQItsMf/xqqlkLPkc7eVTyfsmrpQM7BG9LVvaPVXPVUcZfJNBaYuR4+Sf6Zi2ayI/hQIDAQAB";

    /**
     * 加密方法
     *
     * @param keyString
     * @return
     */
    public static String encrypt(String keyString) throws Exception {
        return encrypt(keyString,publicKey);
    }

    /**
     * 解密方法
     *
     * @param key
     * @return
     */
    public static String decrypt(String key) throws Exception {
        return decrypt(key,privateKey);
    }

    /**
     * 随机生成密钥对
     *
     * @throws NoSuchAlgorithmException
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
        keyMap.put(0, publicKeyString);  //0表示公钥
        keyMap.put(1, privateKeyString);  //1表示私钥
    }

    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

    public static void main(String[] args) throws Exception {
        //生成公钥和私钥
        //genKeyPair();
        keyMap.put(0,publicKey);
        keyMap.put(1,privateKey);
        //加密字符串
        String message = "df723820";
        System.out.println("随机生成的公钥为:" + keyMap.get(0));
        System.out.println("随机生成的私钥为:" + keyMap.get(1));
        String messageEn = encrypt(message, keyMap.get(0));
        System.out.println(message + "\t加密后的字符串为:" + messageEn);
        String messageDe = decrypt(messageEn, keyMap.get(1));
        System.out.println("还原后的字符串为:" + messageDe);
    }


}
