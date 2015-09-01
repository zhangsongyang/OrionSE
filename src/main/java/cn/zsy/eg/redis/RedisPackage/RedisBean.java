package cn.zsy.eg.redis.RedisPackage;

import redis.clients.jedis.Jedis;

public class RedisBean {

    /**
     * server id
     */
    private int serverId;

    private Jedis redis;

    public RedisBean(int serverId, Jedis redis) {
        super();
        this.serverId = serverId;
        this.redis = redis;
    }

    public int getServerId() {
        return serverId;
    }

    public Jedis getRedis() {
        return redis;
    }

}
