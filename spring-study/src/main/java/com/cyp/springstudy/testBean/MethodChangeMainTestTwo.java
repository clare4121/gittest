package com.cyp.springstudy.testBean;

import com.cyp.springstudy.defaultListableBeanFactoryStudy.mybean.TestChangeMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MethodChangeMainTestTwo {
    public static void main(String[] args) {
        ApplicationContext bf= new ClassPathXmlApplicationContext("/static/TestChangeMethod.xml");
        TestChangeMethod testChangeMethod =(TestChangeMethod)bf.getBean("testChangeMethod");
        testChangeMethod.changeMe();
    }
}
