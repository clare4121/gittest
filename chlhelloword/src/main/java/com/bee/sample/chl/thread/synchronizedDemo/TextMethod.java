package com.bee.sample.chl.thread.synchronizedDemo;

import com.bee.sample.chl.thread.ThreadSubName;
import com.bee.sample.chl.thread.ThreadTest;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName TextMethod.java
 * @Description TODO
 * @createTime 2022年12月13日 13:42:00
 */
public class TextMethod {

    public static void main(String[] args) {
        ThreadSubName t1= new ThreadSubName("1",1);


        new Thread(t1).start();
        new Thread(t1).start();


        System.out.println();
    }
    //线程同步类方法方式
    class ThreadTest1  implements  Runnable{
        private  int x;
        private  int y ;


        @Override
        public synchronized void run() {
            for (int i = 0; i < 4; i++) {
            x++;
            y++;

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println("线程出错了");
                }
                System.out.println(Thread.currentThread().getName()
                +"x="+x+",y="+y+"  "+i);
            }
        }
    }

  public synchronized String call(){
        String name =Thread.currentThread().getName();
        return "Hello"+name;
  }
}
