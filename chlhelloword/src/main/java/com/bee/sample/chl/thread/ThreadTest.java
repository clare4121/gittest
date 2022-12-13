package com.bee.sample.chl.thread;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.text.DecimalFormat;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName ThreadTest.java
 * @Description TODO
 * @createTime 2022年12月12日 15:30:00
 */
public class ThreadTest  {
    private  static  ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNamePrefix("teset--->").build();


    private  static  ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 600, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(65536), namedThreadFactory);
    public static void main(String[] args) {

//        Thread thread= new ThreadSubName("第一个",3000);
//        thread.start();
//        Thread thread1=new ThreadSubName("第二个",1000);
//        thread1.start();
//
//
        TextDemo textDemo =new TextDemo("第三个",1000);
        threadPoolExecutor.submit(textDemo);

        DecimalFormat mFormat = new DecimalFormat("00");
        System.out.println(mFormat.format(0));
        System.out.println(mFormat.format(11));

    }





}
