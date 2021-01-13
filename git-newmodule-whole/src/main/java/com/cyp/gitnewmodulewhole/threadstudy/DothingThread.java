package com.cyp.gitnewmodulewhole.threadstudy;

public class DothingThread extends Thread {
    @Override
    public void run() {
        while (true){
            System.out.println(getName()+"在做事情");
        }

    }
}
