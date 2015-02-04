package cn.zsy.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class TestMD5 {
	private static final String Key = "d82f6748-8f0f-467a-a398-60b1bf97dea3";

	public static void main(String[] args) {
		Map map = new LinkedHashMap<String, String>();
		map.put("userOrderId", "20150204Mo14181019892");
		map.put("payOrderId", "2015020400000685");
		map.put("provider", "0");
		map.put("payType", "0");
		map.put("resultCode", "0");
		map.put("resultMsg", "");
		map.put("orderAmount", "200");
		map.put("realAmount", "200");
		map.put("payTime", "20150204141854");
		map.put("appKey", "AP14250115162809560000");
//		map.put("appName", URLEncoder.encode("3D火线穿越", "UTF-8"));
		map.put("goodsId", "4");
//		map.put("goodsName", URLEncoder.encode("20金砖", "UTF-8"));
		map.put("channelId", "kuwo_game");
		map.put("ext1", "");
		map.put("ext2", "");
		map.put("ext3", "");
		map.put("sign", "20cbd860df2d98c0da7f95f3b7372d7d");
		
//		System.out.println(URLEncoder.encode("3D火线穿越", "ISO-8859-1"));
//		
//		System.out.println(URLDecoder.decode("%E5%A4%A9%E5%A4%A9%E6%88%98%E6%9C%BA%EF%BC%88%E8%B5%A2%E8%AF%9D%E8%B4%B9%EF%BC%89", "UTF-8"));
//		userOrderId=20150202235307&payOrderId=2015020200190900&provider=2&payType=0&result
//		Code=0&resultMsg=&orderAmount=200&realAmount=63&payTime=20150202235306&appKey=AP10471014161644160000&appName=%E5%A4%A9%E5%A4%A9%E6%88%98%E6%9C%BA%EF%BC%88%E8%B5%A2%E8%
//				AF%9D%E8%B4%B9%EF%BC%89&goodsId=GOOD1888MONEY&goodsName=2%E5%85%831888%E9%87%91%E5%B8%81&channelId=JOB004&ext1=AerialCombat&ext2=AerialCombat&ext3=AerialCombat + getCpKey())

		
		String ttt = "userOrderId=20150204Mo14181019892&payOrderId=2015020400000685&provider=0&payType=0&resultCode=0"
				+ "&resultMsg="
				+ "&orderAmount=200&realAmount=200&payTime=20150204141854&appKey=AP14250115162809560000&appName="
				+ "3D火线穿越" + "&goodsId=4&goodsName="
						+ "20金砖" + "&channelId=kuwo_game"
								+ "&ext1=&ext2=&ext3";
		
//		String ttt = "userOrderId=20150204Mo14181019892&payOrderId=2015020400000685&provider=0&payType=0&resultCode=0"
//				+ "&resultMsg="
//				+ "&orderAmount=200&realAmount=200&payTime=20150204141854&appKey=AP14250115162809560000&appName="
//				+ URLEncoder.encode("3D火线穿越","UTF-8") + "&goodsId=4&goodsName="
//						+ URLEncoder.encode("20金砖", "UTF-8") + "&channelId=kuwo_game"
//								+ "&ext1=&ext2=&ext3";
		
//		System.out.println(ttt);
		String trtr = "userOrderId=20150204Mo16533519921&payOrderId=2015020400001064&provider=0&payType=0&resultCode=0&resultMsg=&orderAmount=200&realAmount=200&payTime=20150204165420&appKey=AP14250115162809560000&appName=3D火线穿越&goodsId=4&goodsName=20金砖&channelId=kuwo_game&ext1=&ext2=&ext3=";
//		String mySign = getMD5Str(trtr + MoConfig.moAppKey);
		String mySign = Md5Encrypt.md5(trtr + Key);
		// TODO Auto-generated method stub   5f688a506489b8afeb64d52ce14b9275
//		String mySign = SignatureHelper.sign(map, MoConfig.moAppKey);
		System.out.println("###");
		System.out.println(mySign);
//		78ea2539989f3c776970cdc7651c7349	
		
//		"userOrderId=20150204Mo14181019892&payOrderId=2015020400000685&provider=0&payType=0&resultCode=0&resultMsg=&orderAmount=200&"
//		+ "realAmount=200&payTime=20150204141854&appKey=AP14250115162809560000&appName=3D火线穿越&goodsId=4&goodsName=20金砖&channelId=kuwo_game&ext1=";
		
	}
	
	
	
	
	 public static  String getMD5Str(String str) {  
	        MessageDigest messageDigest = null;  
	        try {  
	            messageDigest = MessageDigest.getInstance("MD5");  
	            messageDigest.reset();  
	            messageDigest.update(str.getBytes("UTF-8"));  
	        } catch (NoSuchAlgorithmException e) {  
	            System.out.println("NoSuchAlgorithmException caught!");  
	            System.exit(-1);  
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();  
	        }  
	  
	        byte[] byteArray = messageDigest.digest();  
	        StringBuffer md5StrBuff = new StringBuffer();  
	        for (int i = 0; i < byteArray.length; i++) {              
	            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)  
	                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));  
	            else  
	                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));  
	        }  
	  
	        return md5StrBuff.toString();  
	    }

}

// userOrderId=20150204Mo14181019892	payOrderId=2015020400000685	provider=0	
//payType=0	resultCode=0	resultMsg=	orderAmount=200	realAmount=200	payTime=20150204141854	appKey=AP14250115162809560000	
//appName=3D火线穿越	goodsId=4	goodsName=20金砖	channelId=kuwo_game	ext1=	sign=20cbd860df2d98c0da7f95f3b7372d7d	

//userOrderId=20150204Mo14181019892&payOrderId=2015020400000685&provider=0&payType=0&resultCode=0&resultMsg=&orderAmount=200&realAmount=200&
//payTime=20150204141854&appKey=AP14250115162809560000&appName=3D%E7%81%AB%E7%BA%BF%E7%A9%BF%E8%B6%8A&goodsId=4&
//goodsName=20%E9%87%91%E7%A0%96&channelId=kuwo_game&ext1=


//sign=md5（userOrderId=20150202235307&payOrderId=2015020200190900&provider=2&payType=0&result
//Code=0&resultMsg=&orderAmount=200&realAmount=63&payTime=20150202235306&appKey=AP10471014161644160000&appName=%E5%A4%A9%E5%A4%A9%E6%88%98%E6%9C%BA%EF%BC%88%E8%B5%A2%E8%
//AF%9D%E8%B4%B9%EF%BC%89&goodsId=GOOD1888MONEY&goodsName=2%E5%85%831888%E9%87%91%E5%B8%81&channelId=JOB004&ext1=AerialCombat&ext2=AerialCombat&ext3=AerialCombat+CP_KEY）
