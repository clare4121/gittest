package com.bee.sample.chl.service;

import com.bee.sample.chl.util.RedisUtil;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName RedisLockService.java
 * @Description TODO
 * @createTime 2023年02月07日 16:28:00
 */
@Service
public class RedisLockService implements DistributionLockService {

    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final String IS_LOCKED = "OK";
    private static Logger logger;

    @Override
    public boolean getLock(String lockName, String uniqueCode, int expireTime) {

        boolean isLock = false;
        Jedis jedis = RedisUtil.getJedisConn();
        try {
            Long result = jedis.setnx(lockName, uniqueCode);
            isLock = result == 1 ? true : false;
            if (isLock) {
                jedis.expire(lockName, expireTime);
            }
        } catch (Exception e){


            logger.error("DistributionLockService/getLock", e);

        }finally {
            jedis.close();
        }

        return isLock;
    }

    /**
     *     getLock 获取锁的完善搬
     *    set之后如果节点down掉 则不会执行下面的
     *    jedis.expire(lockName, expireTime); 就会一直锁住
     */

    public boolean getLock2(String lockName, String uniqueCode, int expireTime) {

        boolean isLock = false;
        Jedis jedis = RedisUtil.getJedisConn();
        try {
            String result = jedis.set(lockName, uniqueCode, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
            isLock = IS_LOCKED.equalsIgnoreCase(result) ? true : false;
        } catch (Exception e){
            logger.error("DistributionLockService/getLock", e);
        }
        return isLock;
    }

    @Override
    public void releaseLock(String lockName, String uniqueCode) {
        Jedis jedis = RedisUtil.getJedisConn();
        try {
            String tag = jedis.get(lockName);

            if (tag != null && tag.equals(uniqueCode)){
                jedis.del(lockName);
            }

        } catch (Exception e) {
            logger.error("DistributionLockService/releaseLock", e);

        }finally {

            jedis.close();
        }

    }
}
