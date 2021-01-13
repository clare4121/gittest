package com.cyp.gitnewmodulewhole.threadstudy;

public class SayThread extends Thread {
    @Override
    public void run() {
        while (true){
            System.out.println(getName()+"在说话");
        }
    }

}
