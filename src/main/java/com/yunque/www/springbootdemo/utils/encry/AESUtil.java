package com.yunque.www.springbootdemo.utils.encry;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * AES加解密工具类
 */
public class AESUtil {
    /**
     * 指定加密算法为AES
     */
    private static final String ALGORITHM = "AES";

    /**
     * UUID随机密钥:必须长度为16
     *
     * @return
     */
    public static String generateKeyString() {
        //return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
        return "276e35e6f91d4ec1";
    }

    /**
     * 根据密钥和算法生成Key
     *
     * @return
     * @throws Exception
     */
    private static Key generateKey(String keyString) throws Exception {
        Key key = new SecretKeySpec(keyString.getBytes(), ALGORITHM);
        return key;
    }

    /**
     * 用来进行加密的操作
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encrypt(String keyString, String data)
            throws Exception {
        Key key = generateKey(keyString);
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    /**
     * 用来进行解密的操作
     *
     * @param encryptedData
     * @return
     * @throws Exception
     */
    public static String decrypt(String keyString, String encryptedData) throws Exception {
        Key key = generateKey(keyString);
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }


    public static void main(String[] args) throws Exception {
//        System.out.println(generateKeyString());
        String keyString = "";
        //String keyString = "1234567890123456";
        System.out.println("密钥：" + keyString);

//        String source = "13440000002";// 要加密的字符串
//        System.out.println("准备用密钥加密的字符串为：" + source);
//
//        String cryptograph = encrypt(keyString, source);// 生成的密文
//        System.out.print("用密钥加密后的结果为:" + cryptograph);
//        System.out.println();

        String target = decrypt(keyString, "RQ0AVNOulPsCL1ENQCc3gQ==");// 解密密文
        System.out.println("用密钥解密后的字符串为：" + target);
        System.out.println();


        //对某篇文章进行点赞处理
        Integer artical_id = 50;
        //点赞操作
        Integer userId = 2;
    }

}
