package cn.zsy.eg.redis;

import redis.clients.jedis.Jedis;

public class RedisExecute {


    public static void main(String[] args){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("family", "xshzsy");
        String value = jedis.get("family");
        System.out.println(value);
    }


}
