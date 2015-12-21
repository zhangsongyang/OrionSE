package cn.zsy;

import org.junit.Test;

import java.util.Random;
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
    }

}
