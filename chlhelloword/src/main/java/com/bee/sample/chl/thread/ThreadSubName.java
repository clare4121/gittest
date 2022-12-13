package com.bee.sample.chl.thread;

import lombok.SneakyThrows;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName ThreadSubName.java
 * @Description TODO
 * @createTime 2022年12月12日 15:32:00
 */
public class ThreadSubName extends  Thread implements Runnable {

    private String threadName;
    private int ms;

    public ThreadSubName(String threadName, int ms) {
        this.threadName = threadName;
        this.ms = ms;
    }

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(ms);
        System.out.println("---ThreadSubName------------------->"+threadName);
    }
}
