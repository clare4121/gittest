package com.cyp.gitnewmodulewhole.threadstudy;

import lombok.SneakyThrows;

public class Actress implements Runnable {
    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"是一个演员");
        int count=0;
        boolean keepRuning =true;
        while (keepRuning){
            System.out.println(Thread.currentThread().getName()+"登台演出 ："+(++count));

            if (count==100){
                keepRuning=false;
            }
            if (count%10==0){
                Thread.sleep(3000);
            }
        }
        System.out.println(Thread.currentThread().getName()+"演出结束了");
    }
}
