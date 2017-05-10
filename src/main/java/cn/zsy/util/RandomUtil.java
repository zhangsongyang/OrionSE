package cn.zsy.util;

import java.util.Random;

/**
 * 生成随机指定长度字符 例如（NSyB94nnSM）
 */
public class RandomUtil {

    public static Random random = new Random();

    public static String getRandom(int length) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < length; i++) {
            boolean isChar = (random.nextInt(2) % 2 == 0);// 输出字母还是数字
            if (isChar) { // 字符串
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
                ret.append((char) (choice + random.nextInt(26)));
            } else { // 数字
                ret.append(Integer.toString(random.nextInt(10)));
            }
        }
        return ret.toString();
    }


    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            String str = getRandom(12);
            System.out.println(str);
        }
    }

}
