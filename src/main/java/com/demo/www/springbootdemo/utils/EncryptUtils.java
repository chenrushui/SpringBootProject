package com.demo.www.springbootdemo.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 加解密工具类
 */
public class EncryptUtils {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String encryptType;
    public static String aesKey;

    static {
        EncryptUtils encryptUtils = new EncryptUtils();
        //设置密钥
        encryptUtils.setAesKey("zJJ$c5md3$yuuhWW");
        //设置加解密算法
        encryptUtils.setEncryptType("AES");

    }

    public EncryptUtils() {

    }

    public String getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType;
    }

    public static String getAesKey() {
        return aesKey;
    }

    public static void setAesKey(String aesKey) {
        EncryptUtils.aesKey = aesKey;
    }

    /**
     * 加密处理
     *
     * @param input
     * @return
     */
    public static String encrypt(String input) {
        if (null == input) {
            return null;
        } else {
            try {
                Object var1 = null;
                SecretKeySpec aes = new SecretKeySpec(aesKey.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, aes);
                byte[] bytes = cipher.doFinal(input.getBytes());
                return new String(Base64.encodeBase64(bytes));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /**
     * 解密处理
     *
     * @param input 输入参数
     * @return
     */
    public static String dencrypt(String input) {
        if (null == input) {
            return null;
        } else {
            try {
                byte[] bytes = input.getBytes();
                byte[] aesArray = Base64.decodeBase64(bytes);
                SecretKeySpec aes = new SecretKeySpec(aesKey.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.DECRYPT_MODE, aes);
                byte[] crypt = cipher.doFinal(aesArray);
                return new String(crypt);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }


    public static void main(String[] args) {
        //todo：对称加密  手机号
        //1)两次密码的md5值是一样的，密码不可以是明文
        //2)手机号加密解密处理
        String phone = "13024112588";
        String result = encrypt(phone);
        System.out.println(result);

//        String secrt = "RM2u9gTX+tBS5+Cv6/xnBg==";
//        String dencrypt = dencrypt(secrt);
//        System.out.println(dencrypt);

        System.out.println(new String(Base64.encodeBase64("123".getBytes())));
        System.out.println(new String(Base64.decodeBase64("MTIz".getBytes())));



    }


}
