package com.cyp.springstudy.defaultListableBeanFactoryStudy;

public class ShuXingA {
    public  ShuXingB shuXingB;
    private   void  say(){
        System.out.println("3333333");
    }
    public static void main(String[] args) {
        System.out.println(new ShuXingA().shuXingB.ss);
    }

}
