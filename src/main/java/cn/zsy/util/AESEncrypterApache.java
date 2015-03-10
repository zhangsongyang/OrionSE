package cn.zsy.util;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.security.Security;

/**
 * 这个AES加密和解密没有用到 sun.misc.BASE64Encoder 类
 * 用的是Apache的Base64加密和解密
 */
public class AESEncrypterApache {

    public static String encrypt(String sSrc, String sKey, String charset) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes(charset);
        Security.addProvider(new BouncyCastleProvider());
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        //KeyGenerator kgen = KeyGenerator.getInstance("AES");
        // kgen.init(128, new SecureRandom(raw));
        //SecretKey skey = kgen.generateKey();
        Cipher cipher = Cipher.getInstance("AES/ECB/ZeroBytePadding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(charset));
        return Base64.encodeBase64String(encrypted);
//        return  new BASE64Encoder().encode(encrypted);

    }

    public static String decrypt(String value, String sKey, String charset) {
        String str = "";
        try {
            Security.addProvider(new BouncyCastleProvider());
            byte[] raw = sKey.getBytes(charset);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/ZeroBytePadding");//"算法/模式/补码方式"
            //KeyGenerator kgen = KeyGenerator.getInstance("AES");
            //kgen.init(128, new SecureRandom(raw));
            //SecretKey skey = kgen.generateKey();
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
//	        	byte[] b=cipher.doFinal(new BASE64Decoder().decodeBuffer(value));

            byte[] b = cipher.doFinal(Base64.decodeBase64(value));

            str = new String(b, charset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }


    public static void main(String args[]) throws Exception {
        String test = encrypt("33", "_ket_pay_success", "gb2312");
        System.out.println(test);
        String sss = URLEncoder.encode(test);
        System.out.println(sss);
        System.out.println(decrypt("YXT1oXZ2yr5sL3KQMHk+dg==", "_ket_pay_success", "gb2312"));
    }
}