package com.bee.sample.chl.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName RedisUtil.java
 * @Description TODO
 * @createTime 2023年02月02日 15:07:00
 */
@Configuration
public class RedisUtil {
    private static String redisHost;
    private static String redisPort;
    private static String redisPwd;
    private static String redisDb;
    private static Jedis jedis;

    @Value("${spring.redis.host}")
    public void setRedisHost(String redisHost) {
        RedisUtil.redisHost = redisHost;
    }
    @Value("${spring.redis.port}")
    public void setRedisPort(String redisPort) {
        RedisUtil.redisPort = redisPort;
    }

    @Value("${spring.redis.password}")
    public void setRedisPwd(String redisPwd) {
        RedisUtil.redisPwd = redisPwd;
    }

    @Value("${spring.redis.database}")
    public void setRedisDb(String redisDb) {
        RedisUtil.redisDb = redisDb;
    }

    public static Jedis getJedisConn() {
        try {
            if (jedis != null) {
                return jedis;
            }
            // 无密码配置时，可以通过该方式获取
            // Jedis jedis = new Jedis("node100");
            // 设置redis服务IP、端口及端口
            String redisUrl = "redis://" + redisHost + ":" + redisPort + "/" + redisDb;
            // String redisUrl = "redis://134.70.1.20:6379/0";
            JedisShardInfo shardInfo = new JedisShardInfo(redisUrl);
            // 设置redis密码
            shardInfo.setPassword(redisPwd);
            // shardInfo.setPassword("bonc123");
            jedis = new Jedis(shardInfo);
            jedis.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jedis;
    }

    public static void closeJedisConn(Jedis jedis) {
        try {
            if (jedis != null) {
                jedis.close();
                jedis = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
