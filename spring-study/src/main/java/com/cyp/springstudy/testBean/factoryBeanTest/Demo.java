package com.cyp.springstudy.testBean.factoryBeanTest;


import org.springframework.context.ApplicationContext;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName Demo.java
 * @Description TODO
 * @createTime 2022年06月15日 15:16:00
 */
public class Demo {
    private ApplicationContext applicationContext;
    public void getAllbeans(){
    CarFactoryBean carFactoryBean = (CarFactoryBean)applicationContext.getBean("CarFactoryBean");
    System.out.println(carFactoryBean);
}
    public static void main(String[] args) {
    }
}
