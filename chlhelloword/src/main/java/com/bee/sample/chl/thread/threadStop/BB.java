package com.bee.sample.chl.thread.threadStop;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName BB.java
 * @Description TODO
 * @createTime 2022年12月13日 15:11:00
 */
public class BB  extends Thread{
    int time;
    public BB(int t){
        this.time=t;
    }






    @Override
    public  void run(){
        for (int i = 1; i <=5 ; i++) {
            System.out.println(Thread.currentThread().getName()+"-------------->"+i+"次");

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i==5){
                System.out.println(Thread.currentThread().getName()+"退出了");
            }
        }
    }


    public static void main(String[] args) {
        BB b1 =new BB(500);
        b1.setName("线程1");
        b1.start();



        BB b2 = new BB(200);
        b2.setName("线程1");
        b2.start();


    }
}
