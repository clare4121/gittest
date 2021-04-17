package com.cyp.gitnewmodulewhole.demo;


import org.apache.naming.factory.BeanFactory;

public class Test {


    public String test() throws InterruptedException {
        String[] i ={"1","2","3","4","5","6"};

        for (String j: i
             ) {
            if(j.equals("1")){
                Thread.sleep(5000);
                System.out.println(j);
            }else {

            }

            System.out.println(j);

        }


        return  null;
    }

    public boolean test2(){
        Thread t = new Thread(()->{
            try {
                test();
            } catch (Exception e) {
                throw new RuntimeException("异步线程撞库报错！！");
            }
        });
        t.start();
        return  false;
    }


    public static void main(String[] args) throws InterruptedException {
    new Test().test2();
        System.out.println("main------------");
}
}



