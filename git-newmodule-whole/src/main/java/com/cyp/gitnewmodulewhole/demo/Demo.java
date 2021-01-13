package com.cyp.gitnewmodulewhole.demo;


import com.cyp.gitnewmodulewhole.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Service
public class Demo {
    public  void main() {
        Jedis jedis =RedisUtil.getJedisConn();
        Map<String,String> map  =new HashMap<String,String>();
        map.put("key1","v1");
        map.put("key2","v2");
        Pipeline pipeline =jedis.pipelined();
        //redis中的list相关操作
        pipeline.lpush("list_test","l1");
        pipeline.lset("list_test",0,"l2");
        pipeline.lset("list_test",1,"l3");

        //jedis.lset("list_test",0,"listkey1");
        //redis中map的相关操作
        pipeline.hset("map_test","mapk1","mapv1");
        pipeline.expire("map_test",10);
        pipeline.sync();
        pipeline.close();
        log.info("-=====================================结束==========================");

    }

//    public static void main(String[] args) {
//        String str ="青浦渠道中心,嘉定大客户一中心,网格名称2";
//        String arr2 ="(\'"+str.replaceAll(",","\',\'")+"\')";
//        System.out.println(arr2);
//        String[] arr =str.split(",");
//        String str2=null;
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//
//    }
}
