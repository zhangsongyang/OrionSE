package cn.zsy.eg.redis.RedisPackage;

import redis.clients.jedis.Jedis;

public interface RedisCallable<T> {

	public T call(Jedis redis);
}
