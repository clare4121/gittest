package com.cyp.gitnewmodulewhole.threadstudy;

public class Demo {
    public static void main(String[] args) {
        System.out.println("===========线程开始=========");
        DothingThread dothingThread =new DothingThread();
        dothingThread.setName("小明");
        dothingThread.run();


    }

}
