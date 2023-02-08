package com.bee.sample.chl;

import com.bee.sample.chl.service.RedisLockService;
import com.bee.sample.chl.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName ApplicationStart.java
 * @Description TODO
 * @createTime 2023年02月07日 17:02:00
 */
@Component
@Order(value = 1)
public class ApplicationStart implements ApplicationRunner {

   @Autowired
   RedisLockService redisLockService;
    @Override
    public void run(ApplicationArguments args) throws Exception {




       boolean aa= redisLockService.getLock("lock","miya2",10000);
       System.out.println("---------测试是否执行-------并输出锁的结果-------"+aa);
       if (!aa){
           System.exit(1);
       }



    }
}
