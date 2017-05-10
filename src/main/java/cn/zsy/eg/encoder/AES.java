package cn.zsy.eg.encoder;


import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;


/**
 * 加密和解密算法
 *
 * @author Administrator
 */
public class AES {

    /**
     * 获取解密后的字符串
     *
     * @param content
     * @param passcode
     * @return
     */
    public static String RevertAESCode(String content, String passcode) throws DecoderException {
//        byte[] decryptFrom = Hex.decodeHex(content.toCharArray());
        Base64 base64 = new Base64();
        byte[] decryptFrom = base64.decode(content);
        byte[] decryptResult = decrypt(decryptFrom, passcode);
        String decryptString = new String(decryptResult);
        return decryptString;
    }

    /**
     * 获取加密后的字符串
     *
     * @param content
     * @param passcode
     * @return
     */
    public static String GetAESCode(String content, String passcode) {
        byte[] encryptResult = encrypt(content, passcode);
//        String encryptResultStr = Hex.encodeHexString(encryptResult);
        Base64 base64 = new Base64();
        String encryptResultStr = base64.encodeAsString(encryptResult);
        return encryptResultStr;
    }


    /**
     * 加密
     *
     * @param content
     * @param password
     * @return
     */
    private static byte[] encrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            /**创建密码器**/
            Cipher cipher = Cipher.getInstance("AES");
            byte[] byteContent = content.getBytes("utf-8");
            /**初始化密码器**/
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(byteContent);
            return result;
        } catch (Exception e) {
            System.out.println("出错了:" + e.getMessage());
        }
        return null;
    }

    /**
     * 解密
     *
     * @param content
     * @param password
     * @return
     */
    private static byte[] decrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            /**创建密码器**/
            Cipher cipher = Cipher.getInstance("AES");
            /**初始化密码器**/
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            System.out.println("出错了:" + e.getMessage());
        }
        return null;
    }


    /**
     * 加密和解密
     *
     * @param args
     */
    public static void main(String[] args) throws DecoderException {
        /**数据初始化**/
        String content = "AES";
        String password = "123456";
        /**加密**/
        System.out.println("加密前：" + content);
        String encryptResultStr = GetAESCode(content, password);
        System.out.println("加密后：" + encryptResultStr);
        /**解密**/
        String decryptString = RevertAESCode(encryptResultStr, password);
        System.out.println("解密后：" + new String(decryptString));
    }

}
