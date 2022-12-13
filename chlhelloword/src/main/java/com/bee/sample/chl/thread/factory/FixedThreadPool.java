package com.bee.sample.chl.thread.factory;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import org.apache.catalina.Executor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.*;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName FixedThreadPool.java
 * @Description TODO
 * @createTime 2022年12月12日 16:19:00
 */
public class FixedThreadPool {


    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNamePrefix("teset--->").build();
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 600, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(65536), namedThreadFactory);
    @RequestMapping("pingTest/{ip}")
    public Object testPingOpenFiles(@PathVariable("ip") String ip) {
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("ssssssssss");
            }
        });
        return null;
    }



}
