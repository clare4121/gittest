package com.bee.sample.chl.exercises.reflectexercise;

import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName reflectDemo.java
 * @Description TODO
 * @createTime 2022年12月21日 16:00:00
 */
public class reflectDemo {

  public static  Object returnObject(){


      return null;
  }
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

      Class clazz2 =null;
        try {
             clazz2 = Class.forName("com.bee.sample.chl.exercises.reflectexercise.Person");
        } catch (ClassNotFoundException e) {
            e.getCause();
        }


//        Method[] method =clazz2.getMethods();
//        for (Method m: method
//             ) {
//            System.out.println("--method--"+m);
//        }


//        assert clazz2 != null;
//        Field[] field =clazz2.getDeclaredFields();
//        for (Field f:field){
//            System.out.println("--Field--"+f);
//        }


        Person p =(Person)clazz2.newInstance();
        p.setLoginId("douss5");
        System.out.println("-------------Person-----------"+p.getLoginId());

        Constructor constructor = clazz2.getConstructor();
        Object o =constructor.newInstance();
        Method method=clazz2.getMethod("setLoginId",String.class);
        method.invoke(o,"alex");
        System.out.println(((Person) o).getLoginId());


    }

}
