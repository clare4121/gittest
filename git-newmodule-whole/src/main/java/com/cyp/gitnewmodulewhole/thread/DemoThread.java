package com.cyp.gitnewmodulewhole.thread;

import com.cyp.gitnewmodulewhole.mapper.impl.DemoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DemoThread implements Runnable{
    @Autowired
    DemoImpl demo;
    private static Logger _log = LoggerFactory.getLogger(DemoThread.class);
    @Override
    public void run() {
    _log.info("线程DemoThread开始"+new Date());
   while (true){
       List<String> list =new ArrayList<>();
       list.add("20191129002739");
       list.add("20191129002720");
       System.out.println(Arrays.toString(list.toArray()));
       demo.getSmsCount(list);
   }
    }
}
