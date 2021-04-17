package com.cyp.gitnewmodulewhole.thread.impl;

import com.cyp.gitnewmodulewhole.mapper.impl.DemoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DoThingThread  implements Runnable {
    @Autowired
    DemoImpl demo;
    private static Logger _log = LoggerFactory.getLogger(NameThread.class);
    @Override
    public void run() {
        _log.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"线程DoThingThread开始........."+Thread.currentThread().getName());
//        while (true){
//            System.out.println("DoThing");
////       demo.getSmsCount(list);
//        }
    }
}
