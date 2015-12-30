package cn.zsy;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashSet;
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
        UUID str = UUID.randomUUID();
        System.out.println(str.toString());

    }

    @Test
    public void marry2() {

        for (int i= 0; i< 100; i++){
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
        if(jsonObject.keySet().contains("bbv")){
            System.out.println(jsonObject.get("bb"));
        }
    }


}
