package com.cyp.gitnewmodulewhole.threadstudy;

public class KeyPersonThread extends Thread {
    @Override
    public void run() {
        System.out.println(getName()+"开始了战斗");
        for (int i = 0; i <8 ; i++) {
            System.out.println(getName()+"左突右杀，攻击随军");

        }
        System.out.println(getName()+"结束了战斗");
    }
}
