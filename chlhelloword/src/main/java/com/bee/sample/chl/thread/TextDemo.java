package com.bee.sample.chl.thread;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName TextDemo.java
 * @Description TODO
 * @createTime 2022年12月12日 16:04:00
 */
public class TextDemo extends ThreadSubName implements Runnable {


    public TextDemo(String threadName, int ms) {
        super(threadName, ms);
    }

    @Override
    public void run(){
        super.run();
        System.out.println("RunnableTest---->");
    }
}
