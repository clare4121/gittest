package com.bee.sample.chl.thread.threadStop;

import com.bee.sample.chl.thread.TextDemo;
import com.bee.sample.chl.thread.ThreadSubName;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName ShutDown.java
 * @Description TODO
 * @createTime 2022年12月13日 09:40:00
 */
public class ShutDown {

    @SneakyThrows
    public static void main(String[] args) {
        ThreadSubName threadSubName1 =new ThreadSubName("we",1000);
        threadSubName1.start();


        TimeUnit.SECONDS.sleep(1);




        threadSubName1.interrupt();
        TextDemo textDemo =new TextDemo("we",1000);
        textDemo.start();
        TimeUnit.SECONDS.sleep(1);




    }



}
