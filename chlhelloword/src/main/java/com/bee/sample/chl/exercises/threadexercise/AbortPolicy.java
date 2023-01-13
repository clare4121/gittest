package com.bee.sample.chl.exercises.threadexercise;

import java.util.concurrent.*;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName AbortPolicy.java
 * @Description TODO
 * @createTime 2023年01月10日 09:33:00
 * DK内置的拒绝策略有AbortPolicy、CallerRunsPolicy、DiscardOldestPolicy、DiscardPolicy这4种，
 * 默认的拒绝策略在ThreadPoolExecutor中作为内部类提供。在默认的拒绝策略不能满足应用的需求时，可以自定义拒绝策略。
 */
public class AbortPolicy implements RejectedExecutionHandler {

    public AbortPolicy(){
    }
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        throw  new RejectedExecutionException( "  "+r.toString()+"reject from"+ executor.toString());
    }


    public static void main(String[] args) {
        BlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<Runnable>(10);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

    }
}
