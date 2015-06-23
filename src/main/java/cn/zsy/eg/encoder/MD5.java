package cn.zsy.eg.encoder;


import java.math.BigInteger;
import java.security.MessageDigest;

/*

MD5即Message-Digest Algorithm 5（信息-摘要算法5），用于确保信息传输完整一致。是计算机广泛使用的杂凑算法之一
（又译摘要算法、哈希算法），主流编程语言普遍已有MD5实现。将数 据（如汉字）运算为另一固定长度值，是杂凑算法的基础原理，
MD5的前身有MD2、MD3和 MD4。广泛用于加密和解密技术，常用于文件校验。校验？不管文件多大，经过MD5后都能生成唯一的MD5值。
好比现在的ISO校验，都是MD5校验。怎 么用？当然是把ISO经过MD5后产生MD5的值。一般下载linux-ISO的朋友都见过下载链接旁边放
着MD5的串。就是用来验证文件是否一致的。

MD5(Message Digest algorithm 5，信息摘要算法)
通常我们不直接使用上述MD5加密。通常将MD5产生的字节数组交给BASE64再加密一把，得到相应的字符串
Digest:汇编

MD5算法具有以下特点：

1、压缩性：任意长度的数据，算出的MD5值长度都是固定的。
2、容易计算：从原数据计算出MD5值很容易。
3、抗修改性：对原数据进行任何改动，哪怕只修改1个字节，所得到的MD5值都有很大区别。
4、弱抗碰撞：已知原数据和其MD5值，想找到一个具有相同MD5值的数据（即伪造数据）是非常困难的。
5、强抗碰撞：想找到两个不同的数据，使它们具有相同的MD5值，是非常困难的。
MD5的作用是让大容量信息在用数字签名软件签署私人密钥前被”压缩”成一种保密的格式（就是把一个任意长度的字节串变换成一定长
的十六进制数字串）。除了MD5以外，其中比较有名的还有sha-1、RIPEMD以及Haval等。
*/
public class MD5 {
    public static final String KEY_MD5 = "MD5";

    public static String getResult(String inputStr) {
        System.out.println("=======加密前的数据:" + inputStr);
        BigInteger bigInteger = null;

        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("MD5加密后:" + bigInteger.toString(16));
        return bigInteger.toString(16);
    }

    public static void main(String args[]) {
        try {
            String inputStr = "简单加密888888888888888222228888";
            getResult(inputStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}