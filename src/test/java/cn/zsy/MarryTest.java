package cn.zsy;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class MarryTest {

    @Test
    public void sendmess() {
        String returnJson = "{\"version\":\"1.0\",\"user_profile\":{\"game\":27}}";
        String returnJsonQ = "{\"version\":\"1.0\",\"user_profile\":{\"game\":0}}";
        System.out.println(returnJson);
        System.out.println(returnJsonQ);
        String[] ss = new String[1];
        ss[0] = "asdf";
        System.out.println(ss[0]);

    }

    @Test
    public void marry1() {
//        UUID str = UUID.randomUUID();
//        System.out.println(str.toString());
        String srcid = "FUNMUSIC";
        if("funmusic".equalsIgnoreCase(srcid)){
            System.out.println("asfd");
        }

    }

    @Test
    public void marry2() {

        for (int i = 0; i < 100; i++) {
            Random r = new Random();
            System.out.println(r.nextInt(3));
        }

    }

    @Test
    public void marry3() {
        long s = 11L;
        System.out.println("asdfsdf" + s);
        String USER_HOME = System.getProperty("user.home");
        System.out.println(USER_HOME);
        ThreadLocal<MarryTest> t = new ThreadLocal<MarryTest>();
        System.out.println(t.get());
        Set<String> set = new HashSet<String>();
        System.out.println(set.toString());
    }

    @Test
    public void marry4() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aa", "asdfasdf");
        jsonObject.put("bb", "a222222222");
        System.out.println(jsonObject.toJSONString());

        System.out.println(jsonObject.keySet().toString());
        if (jsonObject.keySet().contains("bbv")) {
            System.out.println(jsonObject.get("bb"));
        }
    }


    @Test
    public void marry5() {
//        try {
//            int a = 1 / 0;
//        } catch (Exception e) {
//            throw  new ArithmeticException();
////            e.printStackTrace();
//        }
//        System.out.println("-------------");

//        Random random = new Random();
        for(int i=0; i<100; i++){
            Random random = new Random();
//            int index = random.nextInt(4);
            int a = random.nextInt(4);
            System.out.println(a);
        }
//        String apacheHost = "asdfasfd";
//        String cid = "asdf";
//        String[] urls = {
//                apacheHost + "aid=text_ad_3127&cid=" + cid +
//                        "&url=http://game.kuwo.cn/g/st/newdl?dlid=gfbdl30&gameid=219&serverid=999&s=1&at=71&ap=85&from=icon&uid=" + cid,
//                apacheHost + "aid=text_ad_3127&cid=" + cid +
//                        "&url=http://game.kuwo.cn/g/st/newdl?dlid=gfbdl30&gameid=219&serverid=999&s=1&at=71&ap=85&from=icon&uid=" + cid,
//                apacheHost + "aid=text_ad_3127&cid=" + cid +
//                        "&url=http://game.kuwo.cn/g/st/newdl?dlid=gfbdl30&gameid=219&serverid=999&s=1&at=71&ap=85&from=icon&uid=" + cid,
//                apacheHost + "aid=text_ad_3230&cid=" + cid +
//                        "&url=http://game.kuwo.cn/g/st/newdl?dlid=gjyjh30&gameid=226&serverid=999&at=71&ap=86&from=icon&uid=" + cid
//        };
//        System.out.println(urls[3]);

    }


    @Test
    public void marry6() {
//        String[] ss = new String[]{"1001008096", "1001008097"};
//        System.out.println(ss[0] + "   " + ss[1]);
        System.out.println((int)Math.rint(333.544));


//        for (int i = 0; i < 100; i++) {
//            Random random = new Random();
//            int a = random.nextInt(2);
//            System.out.println(a);
//        }

    }




}
