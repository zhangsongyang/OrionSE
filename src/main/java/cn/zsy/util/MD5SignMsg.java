package cn.zsy.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5SignMsg {

//	private static Logger log = Logger.getLogger(MD5SignMsg.class);

	public static String getMD5SignMsg(String signSource) {
		String mySign = null;
		// 通过MD5计算出签名
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			byte[] b = messageDigest.digest(signSource.getBytes("utf-8"));
			String HEX_CHARS = "0123456789abcdef";
			StringBuffer sb = new StringBuffer();
			for (byte aB : b) {
				sb.append(HEX_CHARS.charAt(aB >>> 4 & 0x0F));
				sb.append(HEX_CHARS.charAt(aB & 0x0F));
			}
			mySign = sb.toString();
		} catch (NoSuchAlgorithmException e) {
//			log.error(e, e);
		} catch (UnsupportedEncodingException e) {
//			log.error(e, e);
		} catch (Exception e) {
//			log.error(e, e);
		}
		return mySign;
	}

}
