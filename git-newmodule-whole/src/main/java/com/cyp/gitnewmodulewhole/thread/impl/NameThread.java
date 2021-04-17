package com.cyp.gitnewmodulewhole.thread.impl;

import com.cyp.gitnewmodulewhole.mapper.impl.DemoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NameThread implements Runnable{
    @Autowired
    DemoImpl demo;
    private static Logger _log = LoggerFactory.getLogger(NameThread.class);
    @Override
    public void run() {
       _log.info(Thread.currentThread().getName()+"线程NameThread开始"+new Date());
   while (true){
       System.out.println("myName");
//       demo.getSmsCount(list);
   }
    }
}
