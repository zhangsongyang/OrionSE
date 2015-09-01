package cn.zsy.eg.redis.RedisPackage;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public enum Redis {

    singleton;

    private static final Logger logger = Logger.getLogger(Redis.class);

    private Map<Integer, JedisPool> pools = new HashMap<Integer, JedisPool>();

    JedisPool master;

    public void init() {

        RedisType[] values = RedisType.values();
        for (RedisType redisType : values) {
            String configHost = redisType.getConfigName();
            String[] hostAndPort = configHost.split(":");
            JedisPool redisInstance = startServer(hostAndPort[0], Integer.parseInt(hostAndPort[1]), redisType.getDB());
            pools.put(redisType.value(), redisInstance);
            logger.info("started jedis pool: " + configHost + "\t" + redisType.value() + "\tdb:" + redisType.getDB());
            try {
                pools.get(redisType.value()).getResource().get("test");
            } catch (Exception e) {
                logger.error(e, e);
                pools.put(redisType.value(), null);
            }
        }
    }

    protected JedisPool startServer(String host, int port, int db) {
        return new JedisPool(new JedisPoolConfig(), host, port, 6000, null, db);
    }

    public void close() {
        try {

            if (master != null)
                master.destroy();

            if (pools != null) {
                logger.info("destroy redis");
                Collection<JedisPool> values = pools.values();
                for (JedisPool pool : values) {
                    pool.destroy();
                    pool = null;
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public void release(RedisBean redisBean) {
        if (redisBean == null) {
            return;
        }

        // release server.
        int serverId = redisBean.getServerId();
        Jedis redis = redisBean.getRedis();
        pools.get(serverId).returnResource(redis);
    }

    public void releaseBroken(RedisBean redisBean) {
        if (redisBean == null) {
            return;
        }

        // release server.
        int serverId = redisBean.getServerId();
        Jedis redis = redisBean.getRedis();
        pools.get(serverId).returnBrokenResource(redis);
    }

    protected Jedis getRedis(int i) {
        return pools.get(i).getResource();
    }

    protected RedisBean getMasterRedis(RedisType redisType) {
        return getRedis(redisType);
    }

    public RedisBean getRedis(RedisType redisType) {
        Jedis redis = pools.get(redisType.value()).getResource();

        return new RedisBean(redisType.value(), redis);
    }

    public static enum RedisType {

        Master(-1, Constants.REDIS_SERVER, 0),
        DJ_Master(-2, Constants.DJ_REDIS_SERVER, 4);

        private int type;
        private int db;
        private String configName;

        private RedisType(int type, String configName, int db) {
            this.type = type;
            this.configName = configName;
            this.db = db;
        }

        public int value() {
            return type;
        }

        public String getConfigName() {
            return configName;
        }

        public int getDB() {
            return db;
        }

    }

}
