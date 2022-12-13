package com.bee.sample.chl.thread;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName CallableTest.java
 * @Description TODO
 * @createTime 2022年12月12日 17:58:00
 */
public class CallableTest {
    private  static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNamePrefix("teset--->").build();

    private  static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 600, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(65536), namedThreadFactory);



    public static List<Callable<Integer>>  returnSingleCallable(List list,String str){
        List<Callable<Integer>> taskLists = new ArrayList<Callable<Integer>>();
        Callable<Integer> taskSingle =null;
        taskSingle =new Callable() {
            @Override
            public Object call() throws Exception {

                System.out.println("Callable---->test");
                return 1;
            }
        };
        taskLists.add(taskSingle);
        try {
            threadPoolExecutor.invokeAll(taskLists);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return taskLists;
    }


    public static void main(String[] args) {

        //嵌套一个算法
        int nThreadNums =10;

        int count=100/nThreadNums;
        for (int i = 0; i <nThreadNums ; i++) {
            DecimalFormat mFormat = new DecimalFormat("00");
            int maxNum =(i+1)*count-1;
            String min =mFormat.format(maxNum-count+1);
            String max =mFormat.format(maxNum);
            //根据条件去查询数据  如果查出数据 则分类放入线程中
            List<Callable<Integer>>  finalTaskLists =null;
            List list =new ArrayList();
            if (list.size()>0){
                 finalTaskLists =  returnSingleCallable(list,"");
            }

            //线程列表执行
            try {
                threadPoolExecutor.invokeAll(finalTaskLists);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


















    }
}
