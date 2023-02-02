package com.bee.sample.chl.controller;



import com.bee.sample.chl.util.RedisUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName RedisController.java
 * @Description TODO
 * @createTime 2023年02月01日 14:33:00
 */
@RestController
public class RedisController {

    @RequestMapping(value = "/demo/{id}")
    public int getCreditLevel(@PathVariable String id){
        //创建一个redis对象
        Jedis jedis = RedisUtil.getJedisConn();
        int a=Integer.valueOf(id);
        jedis.set("fist",a+"--");



        //用完关闭
        RedisUtil.closeJedisConn(jedis);
        return a;
    }


}
