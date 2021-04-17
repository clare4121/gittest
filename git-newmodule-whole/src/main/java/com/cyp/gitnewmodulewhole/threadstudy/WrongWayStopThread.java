package com.cyp.gitnewmodulewhole.threadstudy;



public class WrongWayStopThread extends Thread {

    public void run() {
        while (!this.isInterrupted()){
            System.out.println("Thread  is  running");
            long time =System.currentTimeMillis();
            while (System.currentTimeMillis()-time<1000){
                //减少屏幕输出的空循环
                //为何不用sleep
            }
            //
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //当线程
        }
    }

    public static void main(String[] args)  {
        WrongWayStopThread thread =new WrongWayStopThread();
        System.out.println("线程开始......");
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Interrupted thread.........");
        thread.interrupt();
        //执行之后状态改变 中断状态置为true
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程结束");

    }
}
