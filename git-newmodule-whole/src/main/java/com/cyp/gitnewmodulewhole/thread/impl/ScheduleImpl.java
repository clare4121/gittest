package com.cyp.gitnewmodulewhole.thread.impl;

import com.cyp.gitnewmodulewhole.thread.Schedule;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Scope("prototype")
@Service
public class ScheduleImpl implements Schedule {
    ExecutorService executorServiceName = Executors.newSingleThreadExecutor();
    ExecutorService executorServiceSay = Executors.newSingleThreadExecutor();
    ExecutorService executorServicedoThing = Executors.newSingleThreadExecutor();
    @Override
    public void name() {
        System.out.println("执行ScheduleImpl.name()..........");
        executorServiceName.submit(new NameThread());
    }

    @Override
    public void say() {
        System.out.println("执行ScheduleImpl.say()..........");
        executorServiceSay.submit(new SayThread());
    }

    @Override
    public void doThing() {
      executorServicedoThing.submit(new DoThingThread());
    }
}
