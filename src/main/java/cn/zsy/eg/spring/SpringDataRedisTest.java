package cn.zsy.eg.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

public class SpringDataRedisTest {

    // http://snowolf.iteye.com/blog/1666908

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-data-redis.xml");
        final StringRedisTemplate redisTemplate = context.getBean("stringRedisTemplate", StringRedisTemplate.class);
        final StringRedisTemplate redisTemplateF = context.getBean("stringRedisTemplateF", StringRedisTemplate.class);

        Object aa = redisTemplate.execute(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                Long size = connection.dbSize();
                // Can cast to StringRedisConnection if using a StringRedisTemplate
                ((StringRedisConnection)connection).set("key1zhazhagzh张ang", "valu张e");
                System.out.println(size);
                return size;
            }
        });

        Object aaF = redisTemplateF.execute(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                Long size = connection.dbSize();
                // Can cast to StringRedisConnection if using a StringRedisTemplate
                ((StringRedisConnection)connection).set("key1zhazhagzh张ang", "valu张e");
                System.out.println(size);
                return size;
            }
        });


        Object aaa = redisTemplate.execute(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                Long size = connection.dbSize();
                byte[] key = redisTemplate.getStringSerializer().serialize("key1zhazhagzh张ang");
                // Can cast to StringRedisConnection if using a StringRedisTemplate
                String aaaaa = redisTemplate.getStringSerializer().deserialize(key);
                System.out.println(aaaaa);
                return size;
            }
        });


        //execute a transaction
        List<Object> txResults = redisTemplate.execute(new SessionCallback<List<Object>>() {
            public List<Object> execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                operations.opsForSet().add("keyddd", "value133333");
                // This will contain the results of all ops in the transaction
                return operations.exec();
            }
        });
        System.out.println("Number of items added to set: " + txResults.get(0));

    }

}
