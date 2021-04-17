package com.cyp.gitnewmodulewhole.threadstudy;

public class ArmyRunable implements Runnable {
    // volatile 保证了线程可以正确的读取其他线程写入的值
    // 可见性 ref JMM happens-before原则
    volatile boolean keepRuning =true;
    @Override
    public void run() {
        while (keepRuning){
            for (int i = 0; i <3 ; i++) {
                System.out.println(Thread.currentThread().getName()+"进攻对方"+"["+i+"]");
                //让出处理器时间
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName()+"结束了战斗！！！");
    }
}
