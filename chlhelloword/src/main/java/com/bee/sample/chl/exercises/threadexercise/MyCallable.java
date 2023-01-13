package com.bee.sample.chl.exercises.threadexercise;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName MyCallable.java
 * @Description TODO
 * @createTime 2023年01月09日 14:06:00
 */
public class MyCallable implements Callable<String> {


    private  String name;

    public MyCallable(String name){
        this.name=name;
    }

    @Override
    public String call() throws Exception {
        return name;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNamePrefix("线程-->").build();

         /*
         * AbortPolicy直接抛出异常，阻止线程正常运行
         * CallerRunsPolicy的拒绝策略为：如果被丢弃的线程任务未关闭，则执行该线程任务。注意，CallerRunsPolicy拒绝策略不会真的丢弃任务
         * DiscardOldestPolicy的拒绝策略为：移除线程队列中最早的一个线程任务，并尝试提交当前任务。具体的JDK实现源码如下
         * DiscardPolicy的拒绝策略为：丢弃当前的线程任务而不做任何处理。如果系统允许在资源不足的情况下丢弃部分任务
         * */
        //拒绝策略有AbortPolicy、CallerRunsPolicy、DiscardOldestPolicy、DiscardPolicy这4种，
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        RejectedExecutionHandler handler2 = new ThreadPoolExecutor.CallerRunsPolicy();
        RejectedExecutionHandler handler3 = new ThreadPoolExecutor.DiscardOldestPolicy();
        RejectedExecutionHandler handler4 = new ThreadPoolExecutor.DiscardPolicy();


        //new ArrayBlockingQueue<Runnable>(65536) 阻塞队列数  无界的LinkedBlockingQueue  遵循FIFO原则的队列如ArrayBlockingQueue，另一类是优先级队列如PriorityBlockingQueue

        ExecutorService pool = new ThreadPoolExecutor(10, 100, 600, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(65536), namedThreadFactory,handler);
        ExecutorService pool2 = new ThreadPoolExecutor(10, 100, 600, TimeUnit.SECONDS,
                new PriorityBlockingQueue<Runnable>(65536), namedThreadFactory,handler2);
        ExecutorService pool3 = new ThreadPoolExecutor(10, 100, 600, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(65536), namedThreadFactory,handler3);



        //创建新线程的时候如果有可用的线程 则重用否则重新创建一个新的线程并将其添加到线程池中
        // 对于执行时间很短的大量任务 可以最大程度的重用线程并提高系统的性能
        Executors.newCachedThreadPool();

        Executors.newFixedThreadPool(5);


        ScheduledExecutorService scheduledExecutorpool=  Executors.newScheduledThreadPool(5);

        //创建一个3s后执行的线程
        scheduledExecutorpool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 sconds execu");
            }
        },3, TimeUnit.SECONDS);


        //创建一个延迟一秒执行且每3s执行一次的线程
        scheduledExecutorpool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

            }
        },1,3,TimeUnit.SECONDS);

        Executors.newSingleThreadExecutor();
        Executors.newWorkStealingPool();




        List<Future>  list=new ArrayList<Future>();
        for (int i = 0; i <10 ; i++) {
            Callable c =new MyCallable(i+"--->");
            Future future=pool.submit(c);
            System.out.println("submit a callable thread "+i);
            list.add(future);
        }
        pool.shutdown();
        for (Future future:list){
            System.out.println("get the result from callable thread:"+future.get().toString());
        }
    }




}
