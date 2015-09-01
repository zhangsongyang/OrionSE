package cn.zsy.eg.redis.RedisPackage;

import redis.clients.jedis.exceptions.JedisException;

public class RedisExecutor {

    public static <T> T executeInMaster(RedisCallable<T> callable) {
        return execute(Redis.RedisType.Master, callable);
    }

    public static <T> T executeInMaster(Redis.RedisType type, RedisCallable<T> callable) {
        return execute(type, callable);
    }

    private static <T> T execute(Redis.RedisType type, RedisCallable<T> callable) {
        RedisBean redisBean = null;
        try {
            redisBean = Redis.singleton.getMasterRedis(type);
            return callable.call(redisBean.getRedis());
        } catch (JedisException e) {
            Redis.singleton.releaseBroken(redisBean);
            throw e;
        } finally {
            Redis.singleton.release(redisBean);
        }
    }

}
