package com.demo.www.springbootdemo.utils.encry;

import com.demo.www.springbootdemo.pojo.EncryptEntity;

/**
 * 加解密工具类
 */
public class CryptoUtil {

    /**
     * 加密数据
     *
     * @param data
     * @return
     * @throws Exception
     */
//    public static EncryptEntity encrypt(String data) throws Exception {
//        //1、产生AES密钥
//        String keyString = AESUtil.generateKeyString();
//        //2、用AES法加密数据
//        String content = AESUtil.encrypt(keyString, data);
//        //3、用RSA加密AES密钥
//        String finalKey = RSAUtil.encrypt(keyString);
//        EncryptEntity encryptEntity = new EncryptEntity();
//        encryptEntity.setContent(content);
//        encryptEntity.setKey(finalKey);
//        return encryptEntity;
//    }
//
//    /**
//     * 解密数据
//     *
//     * @param key
//     * @param data
//     * @return
//     */
//    public static String decrypt(String key, String data) throws Exception {
//        //获取解密密钥
//        String decryptKey = RSAUtil.decrypt(key);
//        //解密数据
//        String content = AESUtil.decrypt(decryptKey, data);
//        return content;
//    }

}
