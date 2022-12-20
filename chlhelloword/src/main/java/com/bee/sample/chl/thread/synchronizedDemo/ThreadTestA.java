package com.bee.sample.chl.thread.synchronizedDemo;

public class ThreadTestA {
        private int j;
        public static void main(String args[]) {
            ThreadTestA tt = new ThreadTestA();
            //创建本类的实例化对象tt
            IncOfJ inc = tt.new IncOfJ("自增线程1");
            //创建线程inc，因为IncOfJ是ThreadTest1
            //的内部类， 所以用tt.new IncOfJ("自增线程1")的形式创建IncOfJ的实例化对象
            inc.start();                              //启动线程
            IncOfJ inc1 = tt.new IncOfJ("自增线程2");
            inc1.start();
            //创建线程dec，因为DecOfJ是ThreadTest1
            DecOfJ dec = tt.new DecOfJ("自减线程3");
            //的内部类， 所以用tt.new DecOfJ("自减线程3")的形式创建DecOfJ的实例化对象
            dec.start();
            //启动线程
            DecOfJ dec1 = tt.new DecOfJ("自减线程4");
            dec1.start();
        }
        private synchronized void incValue() {
            //定义synchronized方法，用于变量j的自增和信息的输出
            j++;
            System.out.println(Thread.currentThread().getName() + "-inc:" + j);
        }
        private synchronized void decValue() {
            //定义synchronized方法，用于变量j的自减和信息的输出
            j--;
            System.out.println(Thread.currentThread().getName() + "-dec:" + j);
        }
        class IncOfJ extends Thread {
            //创建实现Runnable的子类IncOfJ，也是ThreadTest1的内部类
            IncOfJ(String name) {
                super(name);
                //调用Thread类的构造方法，为线程设置名称
            }
            @Override
            public void run() {
                //在IncOfJ类中重写父类Thread的run()方法
                for (int i = 0; i < 5; i++) {
                incValue();
                //调用ThreadTest1类的incValue()方法
                }
            }
        }
        class DecOfJ extends Thread {
            //创建实现Runnable的子类DecOfJ，也是ThreadTest1的内部类
            DecOfJ(String name) {
                super(name);
                //调用Thread类的构造方法，为线程设置名称
            }
            @Override
            public void run() {
                //在DecOfJ类中重写父类Thread的run()方法
                for (int i = 0; i < 5; i++) {
                decValue();
                //调用ThreadTest1类的decValue()方法
                }
            }
        }
    }