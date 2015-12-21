package cn.zsy.eg.encoder;

import org.apache.commons.codec.binary.Base64;

public class Base64Apache {

    /**
     *
     * TODO 使用Base64加密算法加密字符串
     *return
     */
    public static String encodeStr(String plainText){
        byte[] b=plainText.getBytes();
        Base64 base64=new Base64();
        b=base64.encode(b);
        String s=new String(b);
        return s;
    }

    /**
     *
     * TODO 使用Base64解密
     *return
     */
    public static String decodeStr(String encodeStr){
        byte[] b=encodeStr.getBytes();
        Base64 base64=new Base64();
        b=base64.decode(b);
        String s=new String(b);
        return s;
    }

    public static void main(String[] args) {

        String str = "578c44f58c6b3be5e50e9fac98296abb";
        try {
            String result1 = Base64Apache.encodeStr(str);
            System.out.println("result1=====加密数据==========" + result1);

            String result2 = Base64Apache.decodeStr(result1);
            System.out.println("str2========解密数据========" + result2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
