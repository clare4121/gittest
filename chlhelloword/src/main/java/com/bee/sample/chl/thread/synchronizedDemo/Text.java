package com.bee.sample.chl.thread.synchronizedDemo;



/**
 * @author cyp
 * @version 1.0.0
 * @ClassName Text.java
 * @Description TODO
 * @createTime 2022年12月13日 10:19:00
 */
public class Text {
    public static void main(String[] args) {
        TextThread textThread =new TextThread();
         new Thread(textThread).start();
         new Thread(textThread).start();

    }



    static class TextThread implements Runnable{
        private int num =5;
        @Override
        public void run() {
            while (true){
                //----------------------------------------------------线程同步代码块方式
                synchronized (this){

                    if (num>0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"数字为----》"+num--);
                    }
                    else {
                        System.out.println(Thread.currentThread().getName()+"退出了");
                        break;
                    }
                }
            }
        }
    }

}
