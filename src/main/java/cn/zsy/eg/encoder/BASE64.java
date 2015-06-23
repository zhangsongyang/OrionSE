package cn.zsy.eg.encoder;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/*

简单的java加密算法有：

BASE64 严格地说，属于编码格式，而非加密算法
MD5(Message Digest algorithm 5，信息摘要算法)
SHA(Secure Hash Algorithm，安全散列算法)
HMAC(Hash Message Authentication Code，散列消息鉴别码)

1. BASE64
Base64是网络上最常见的用于传输8Bit字节代码的编码方式之一，大家可以查看RFC2045～RFC2049，上面有MIME的详细规范。
Base64编码可用于在HTTP环境下传递较长的标识信息。例如，在Java Persistence系统Hibernate中，就采用了Base64来将一个较长的
唯一标识符（一般为128-bit的UUID）编码为一个字符串， 用作HTTP表单和HTTP GET URL中的参数。在其他应用程序中，也常常需要把
二进制数据编码为适合放在URL（包括隐藏表单域）中的形式。此时，采用Base64编码具有不可读性， 即所编码的数据不会被人用肉眼
所直接看到。（来源百度百科）

BASE64的加密解密是双向的，可以求反解.
BASE64Encoder和BASE64Decoder是非官方JDK实现类。虽然可以在JDK里能找到并使用，但是在API里查不到。
JRE 中 sun 和 com.sun 开头包的类都是未被文档化的，他们属于 java, javax 类库的基础，其中的实现大多数与底层平台有关，
一般来说是不推荐使用的。
BASE64 严格地说，属于编码格式，而非加密算法
主要就是BASE64Encoder、BASE64Decoder两个类，我们只需要知道使用对应的方法即可。
另，BASE加密后产生的字节位数是8的倍数，如果不够位数以=符号填充。
BASE64
按照RFC2045的定义，Base64被定义为：Base64内容传送编码被设计用来把任意序列的8位字节描述为一种不易被人直接识别的形式。
（The Base64 Content-Transfer-Encoding is designed to represent arbitrary sequences of octets in a form that need not be humanly readable.）
常见于邮件、http加密，截取http信息，你就会发现登录操作的用户名、密码字段通过BASE64加密的。
*/

public class BASE64 {
    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    public static void main(String[] args) {

        String str = "578c44f58c6b3be5e50e9fac98296abb";

        try {
            String result1 = BASE64.encryptBASE64(str.getBytes());
            System.out.println("result1=====加密数据==========" + result1);

            byte result2[] = BASE64.decryptBASE64(result1);
            String str2 = new String(result2);
            System.out.println("str2========解密数据========" + str2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}