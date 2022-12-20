package com.bee.sample.chl.thread.threadStop;

public class StartThreadDemo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            printTName();
        }
    }

    public void printTName() {
        String name = Thread.currentThread().getName();
        System.out.println("当前运行线程的名字是 " + name);
    }

    public static void main(String[] args) {
        StartThreadDemo t = new StartThreadDemo();
        t.setName("test Thread");
        System.out.println("调用start()方法之前 , t.isAlive() = " + t.isAlive());
        t.start();
        System.out.println("调用start()方法之后 , t.isAlive() = " + t.isAlive());
        for (int i = 0; i < 2; i++) {
            t.printTName();
            try {
                Thread.sleep(200);
                System.out.println("线程休眠时 , t.isAlive() = " + t.isAlive());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}