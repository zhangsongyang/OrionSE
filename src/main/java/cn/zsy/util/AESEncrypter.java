package cn.zsy.util;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class AESEncrypter {
	
	public static String encrypt(String sSrc, String sKey,String charset) throws Exception {
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
        
        //return new String(StringUtil.byteHex(encrypted));
        return  new BASE64Encoder().encode(encrypted);
        
    }

	    public static String decrypt(String value,String sKey,String charset) {
	    	String str="";
	        try {
	        	 Security.addProvider(new BouncyCastleProvider());
	        	 byte[] raw=sKey.getBytes(charset);
	             SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
	             Cipher cipher = Cipher.getInstance("AES/ECB/ZeroBytePadding");//"算法/模式/补码方式"
	             //KeyGenerator kgen = KeyGenerator.getInstance("AES");
	             //kgen.init(128, new SecureRandom(raw));
	             //SecretKey skey = kgen.generateKey();
	             cipher.init(Cipher.DECRYPT_MODE, skeySpec);
	        	byte[] b=cipher.doFinal(new BASE64Decoder().decodeBuffer(value));
	        	str=new String(b,charset);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return str;
	    }
	   
	   
	    public static void main(String args[]) throws Exception{
	    	System.out.println(encrypt("谢世会", "IloveyouIloveyou", "gb2312"));
	    		System.out.println(decrypt("7j6Q22GKXUqW8IGsbMkj6w==", "IloveyouIloveyou", "gb2312"));
	    }
	}

