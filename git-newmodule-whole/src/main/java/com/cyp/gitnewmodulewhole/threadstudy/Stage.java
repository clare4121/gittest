package com.cyp.gitnewmodulewhole.threadstudy;

import lombok.SneakyThrows;

public class Stage  extends  Thread{


    @SneakyThrows
    @Override
    public void run() {
        System.out.println("战争开始====");
        Thread.sleep(5000);
        System.out.println("徐徐拉开");
        Thread.sleep(5000);
        ArmyRunable armyRunableSuiDynasty = new ArmyRunable();
        ArmyRunable armyRunableRevolt= new ArmyRunable();

        //使用Runable接口创建线程
        Thread armyOfSui =new Thread(armyRunableSuiDynasty,"随军");
        Thread armtOfRevolt = new Thread(armyRunableRevolt,"农民起义军");

        //启动线程
        armyOfSui.start();
        armtOfRevolt.start();

        //舞台休眠
       Thread.sleep(50);

        System.out.println("双方激战=====");
        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");
        System.out.println("程咬金出战=====");
        //军队停止作战
        armyRunableRevolt.keepRuning=false;
        armyRunableSuiDynasty.keepRuning=false;

        //线程休眠
        Thread.sleep(2000);
        mrCheng.start();
        //等待join线程方法执行完毕
        mrCheng.join();

        System.out.println("战争结束=====");
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
