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

    private static final String privateKey="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAO+zh8bnUA+elnRy1BHKEGrbTmh/" +
            "r71zFboVTznwAuEzPnvOezQBOY+623mIXh86/cyCLlCRzbGm0Q5M3LSY6sTemNXtupVnb1lWwD1xDrSG0JsCgeS/weCLI9gHaknNuMfVlg+" +
            "5esYcy2JlyG5ldcJahCgAOog2lJr4pLUSj8fJAgMBAAECgYEAiJIlnjJU71FQL/Ds22XhjMB/IBMAMlTL4EYb6crSGTV1OF0g3TSFc1rniY" +
            "sk9W5LBKZ3dPhd1gZRvnAUn+EwgPh1bVBG0Z30vr2Ea0w9v+D3T96byeCKh+xoKQqG+Yp+u5w8v6MNNX6sVN2D0gks9YgY+2xGEeAf9kuF5" +
            "gpHhAECQQD65WyV3dI8uO4tQEBnS6LRAWVFuEZEWp1W8MXm5DUz/Tnsd7eAdg3VRdS1rZJ17pLa9umFtL/FUVWmw++zeABhAkEA9JPOqXlr" +
            "vB/GjLl9g3YJBpPjA7UhWHZ6vn8bUq55noengQQL0l2mrJfEFXVHLs0m9lV3tAURpgpuraLkd/ugaQJATFBITPVhozKkz4LBlCm/Zk9EXIa" +
            "GaPge73jg2TAEtsGJQtHPMPW3k21gG7ql19UvOgbsVMz7n6rzoHvshuwzQQJAY92WnQy/OOmgoQV8gplHxi/Mmk7zdrOqGu67sV8cueaaNs" +
            "v4J8WlsQOnRTvF/Q43wo3TeuY29p1749qHf5Z3QQJBANnZYSe93QlOT+6PFT1Dkv8osnOY/93CZYD2IvTpfXfqJnbBZ9bkSe7xcxIIqGO6M" +
            "JWlZjItnYBZLLHP3JKVgOQ=";

    private static final String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDvs4fG51APnpZ0ctQRyhBq205of6+9cxW6FU858" +
            "ALhMz57zns0ATmPutt5iF4fOv3Mgi5Qkc2xptEOTNy0mOrE3pjV7bqVZ29ZVsA9cQ60htCbAoHkv8HgiyPYB2pJzbjH1ZYPuXrGHMtiZchu" +
            "ZXXCWoQoADqINpSa+KS1Eo/HyQIDAQAB";

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
