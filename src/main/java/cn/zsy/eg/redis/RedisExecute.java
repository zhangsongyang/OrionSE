package cn.zsy.eg.redis;

import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisExecute {


    public static void main(String[] args){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Set<String> keys = jedis.keys("*");
        jedis.set("family", "xshzsy");
        String value = jedis.get("family");
        System.out.println(value);
        System.out.println(keys.size());
        Object[] keyArray =  keys.toArray();
        for(int i=0; i<keyArray.length; i++){
            System.out.println(keyArray[i]);
        }
        jedis.close();
    }


}
