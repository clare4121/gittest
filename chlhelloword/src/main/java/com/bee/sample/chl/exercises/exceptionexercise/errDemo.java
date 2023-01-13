package com.bee.sample.chl.exercises.exceptionexercise;

import com.sun.xml.internal.ws.api.model.CheckedException;

import java.io.File;
import java.io.InputStream;
import java.util.zip.CheckedInputStream;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName errDemo.java
 * @Description TODO
 * @createTime 2022年12月21日 15:25:00
 */
public class errDemo {

    public static void main(String[] args) {
        //运行时异常
        //常见的有 NullPointerException ClassCastException ArrayIndexOutOf BundsException

        RuntimeException exception =new RuntimeException();
        exception.getMessage();

          //常见的CheckedException有由于I/O错误 OException、SQLException、ClassNotFoundException
        CheckedException checkedException ;


        //处理异常的方式
        try{

        }catch (Exception e){

        }finally {
            System.out.println();
        }
        //还有抛出异常 throw 和throws
        //throw和throws的区别如下。位置不同：throws作用在方法上，后面跟着的是异常的类；
        // 而throw作用在方法内，后面跟着的是异常的对象。
        // 功能不同：throws用来声明方法在运行过程中可能出现的异常，以便调用者根据不同的异常类型预先定义不同的处理方式；
        // throw用来抛出封装了异常信息的对象，程序在执行到throw时后续的代码将不再执行，而是跳转到调用者，
        // 并将异常信息抛给调用者。也就是说，throw后面的语句块将无法被执行（finally语句块除外）。
    }
     //参考FileChannelDemo1的throws 和当前trycatch下的throw e
    public static void throwDemo(String a) {
        File  file =new File("");
        InputStream ins ;
        try {
        }catch (Exception e){
           throw e;
        }


    }



}
