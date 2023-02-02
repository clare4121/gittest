//package com.bee.sample.chl.util;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//
//@Configuration
//public class RedisConfig {
//
//    @Bean
//    @SuppressWarnings("all")
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        // 设置连接工厂类
//        template.setConnectionFactory(factory);
//        // 设置key的序列化器
//        template.setKeySerializer(RedisSerializer.string());
//        // 设置value的序列化器
//        template.setValueSerializer(RedisSerializer.json());
//        // 设置hash key的序列化器
//        template.setHashKeySerializer(RedisSerializer.string());
//        // 设置hash value的序列化器
//        template.setHashValueSerializer(RedisSerializer.json());
//        // 设置完成
//        template.afterPropertiesSet();
//        return template;
//    }
//}