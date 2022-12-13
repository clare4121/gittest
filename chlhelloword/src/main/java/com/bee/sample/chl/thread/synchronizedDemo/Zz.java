package com.bee.sample.chl.thread.synchronizedDemo;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName Zz.java
 * @Description TODO
 * @createTime 2022年12月13日 14:33:00
 */
public class Zz {


    public static void main(String[] args) {
        new Zz();

    }


    public Zz() {
        Zz a1 =this;
        Zz a2 =this;





        synchronized (a1){
            try {
                a2.wait();
                a2.notify();
                System.out.println("Hellow");
            } catch (InterruptedException e) {
                System.out.println("good bye ");
            }
            catch (Exception e){
                System.out.println("this method is wrong");
            }finally {
                System.out.println("finally");
            }


            System.out.println("Together");
        }






    }
}
