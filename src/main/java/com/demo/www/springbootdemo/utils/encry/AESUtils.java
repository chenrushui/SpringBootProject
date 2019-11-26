package com.demo.www.springbootdemo.utils.encry;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * Created on 2019/10/18 13:08
 * author:crs
 * Description:XXX
 */
public class AESUtils {

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param password  加密密码
     * @return
     */
    public static byte[] encrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**解密
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {

//        String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCa6j3SJwXr/pLLwb6Pq8pi9StPq+Wvm6vu+LWQB1hNqClWk0jQm5GnF6Kj0ac2gqgsMsutc3hhMaaX2QZvLX+gFQHC/ufGBdBbpPtDeGWsQItsMf/xqqlkLPkc7eVTyfsmrpQM7BG9LVvaPVXPVUcZfJNBaYuR4+Sf6Zi2ayI/hQIDAQAB";

        /*
        String content = "{\"password\":\"D0DCBF0D12A6B1E7FBFA2CE5848F3EFF\",\"mobile\":\"13024112057\"}";
        String password = "76dd74d5161e45b8";
        //加密
        System.out.println("加密前：" + content);
        byte[] encryptResult = encrypt(content, password);
        String encryptResultStr = parseByte2HexStr(encryptResult);
        System.out.println("加密后：" + encryptResultStr);
        //解密
        byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);
        byte[] decryptResult = decrypt(decryptFrom,password);
        System.out.println("解密后：" + new String(decryptResult));
        String encrypt = RSAUtil.encrypt("76dd74d5161e45b8", RSAUtil.publicKey);
        System.out.println("RSA加密后："+encrypt);
        String decrypt = RSAUtil.decrypt(encrypt, RSAUtil.privateKey);
        System.out.println("RSA解密后："+decrypt);
        */
        String encrypt="j92V985MGxyTxakXZa8lL0c0SBvRETSQqIhxQ4dR9Dzoz3hlX0Qc3d0o8zKh19uxF5OgsQ5ix8HhLkQoVNThDDth48ztZ97gdcTUZwlA5Pyand6csbhPGJj4Sk/XUBP7+TKgU3MljpUOOcAZ40+ZjjhLuWnsLTtkormuv4HcSsI=";
        String decrypt = RSAUtil.decrypt(encrypt);
        System.out.println(decrypt);
        //System.out.println("YCPQPx4qpQjEjDea");
        String content="RESKPSZ5sBPghGUb5UZWL5/BaLd/apm2oMD5R8iBHCDRWNB53HnbMqIKAPjksMNDKKPmHowabWwx2RGbgwRrW+rXfgQ15jB2DVBqCDA4MdO/B3dQ7GbkWd/DuqCPctMd";
        String result = AESUtil.aesDecrypt(content, decrypt);
        System.out.println(result);
    }







}
