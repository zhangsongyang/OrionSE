package cn.zsy.eg.redis.RedisPackage.Dao;

import cn.zsy.eg.redis.RedisPackage.Redis;
import cn.zsy.eg.redis.RedisPackage.RedisCallable;
import cn.zsy.eg.redis.RedisPackage.RedisExecutor;
import cn.zsy.eg.redis.RedisPackage.RedisKey;
import redis.clients.jedis.Jedis;

import java.util.Map;


public class RedisDAO {

    private static RedisDAO instance = new RedisDAO();

    private RedisDAO() {
    }

    public static RedisDAO getInstance() {
        return instance;
    }

    public Map<String, String> getMsg(final String cid) {
        return RedisExecutor.executeInMaster(new RedisCallable<Map<String, String>>() {
            @Override
            public Map<String, String> call(Jedis redis) {
                return redis.hgetAll(String.format(RedisKey.ECOM_GXH_CID, cid));
            }
        });
    }

    public String getMsgOfValue(final String cid, final String field) {
        return RedisExecutor.executeInMaster(new RedisCallable<String>() {
            @Override
            public String call(Jedis redis) {
                return redis.hget(String.format(RedisKey.ECOM_GXH_CID, cid), field);
            }
        });
    }

    public String getDJMsg(final String cid) {
        return RedisExecutor.executeInMaster(Redis.RedisType.DJ_Master, new RedisCallable<String>() {
            @Override
            public String call(Jedis redis) {
                return redis.get(String.format(RedisKey.ECOM_GXH_DJ_USER, cid));
            }
        });
    }

    public Long IncrShowCnt(final String date) {
        return RedisExecutor.executeInMaster(new RedisCallable<Long>() {
            @Override
            public Long call(Jedis redis) {
                return redis.incr(String.format(RedisKey.ECOM_GXH_SHOW_CNT, date));
            }
        });
    }

    public Long IncrFilterCnt(final String date) {
        return RedisExecutor.executeInMaster(new RedisCallable<Long>() {
            @Override
            public Long call(Jedis redis) {
                return redis.incr(String.format(RedisKey.ECOM_GXH_FILTER_TOTAL, date));
            }
        });
    }

    public Long IncrUserCnt(final String type, final String date) {
        return RedisExecutor.executeInMaster(new RedisCallable<Long>() {
            @Override
            public Long call(Jedis redis) {
                return redis.incr(String.format(RedisKey.ECOM_GXH_USER_CNT, type, date));
            }
        });
    }

    public Long IncrHasIconUserCnt(final String type, final String date) {
        return RedisExecutor.executeInMaster(new RedisCallable<Long>() {
            @Override
            public Long call(Jedis redis) {
                return redis.incr(String.format(RedisKey.ECOM_GXH_HAS_ICON_CNT, type, date));
            }
        });
    }

    public Long IncrShowCnt(final String date, final String isshow) {
        return RedisExecutor.executeInMaster(new RedisCallable<Long>() {
            @Override
            public Long call(Jedis redis) {
                return redis.incr(String.format(RedisKey.ECOM_GXH_SHOW_NEW_CNT, date, isshow));
            }
        });
    }

    public Long IncrReqTotal(final String today) {
        return RedisExecutor.executeInMaster(new RedisCallable<Long>() {
            @Override
            public Long call(Jedis redis) {
                return redis.incr(String.format(RedisKey.ECOM_GXH_REQ_TOTAL, today));
            }
        });
    }

    public Long IncrReqUrlCnt(final String uri, final String today) {
        return RedisExecutor.executeInMaster(new RedisCallable<Long>() {
            @Override
            public Long call(Jedis redis) {
                return redis.incr(String.format(RedisKey.ECOM_GXH_REQ_URL_CNT, uri, today));
            }
        });
    }


    public String getShowCnt(final String date) {
        return RedisExecutor.executeInMaster(new RedisCallable<String>() {
            @Override
            public String call(Jedis redis) {
                return redis.get(String.format(RedisKey.ECOM_GXH_SHOW_CNT, date));
            }
        });
    }

    public String getShowCnt(final String date, final String isshow) {
        return RedisExecutor.executeInMaster(new RedisCallable<String>() {
            @Override
            public String call(Jedis redis) {
                return redis.get(String.format(RedisKey.ECOM_GXH_SHOW_NEW_CNT, date, isshow));
            }
        });
    }

    public String setShowTotalCnt(final String date) {
        return RedisExecutor.executeInMaster(new RedisCallable<String>() {
            @Override
            public String call(Jedis redis) {
                return redis.set(String.format(RedisKey.ECOM_GXH_SHOW_CNT_TOTAL, date), "65000");
            }
        });
    }

    public String setShowTotalCnt(final String date, final String isshow, final String count) {
        return RedisExecutor.executeInMaster(new RedisCallable<String>() {
            @Override
            public String call(Jedis redis) {
                return redis.set(String.format(RedisKey.ECOM_GXH_SHOW_NEW_CNT_TOTAL, date, isshow), count);
            }
        });
    }


    public String getShowTotalCnt(final String date) {
        return RedisExecutor.executeInMaster(new RedisCallable<String>() {
            @Override
            public String call(Jedis redis) {
                return redis.get(String.format(RedisKey.ECOM_GXH_SHOW_CNT_TOTAL, date));
            }
        });
    }

    public String getShowTotalCnt(final String date, final String isshow) {
        return RedisExecutor.executeInMaster(new RedisCallable<String>() {
            @Override
            public String call(Jedis redis) {
                return redis.get(String.format(RedisKey.ECOM_GXH_SHOW_NEW_CNT_TOTAL, date, isshow));
            }
        });
    }

    public boolean saveMsg(final String cid, final Map<String, String> mapBean) {
        RedisExecutor.executeInMaster(new RedisCallable<String>() {
            @Override
            public String call(Jedis redis) {
                redis.hmset(String.format(RedisKey.ECOM_GXH_CID, cid), mapBean);
                redis.expire(String.format(RedisKey.ECOM_GXH_CID, cid), 15552000);
                return "OK";
            }
        });
        return true;
    }

    public Boolean delMsg(final String uid) {
        return RedisExecutor.executeInMaster(new RedisCallable<Boolean>() {
            @Override
            public Boolean call(Jedis redis) {
                redis.del(String.format(RedisKey.ECOM_GXH_CID, uid));
                return true;
            }
        });
    }

}
