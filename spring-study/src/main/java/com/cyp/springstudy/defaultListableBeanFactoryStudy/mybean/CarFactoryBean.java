package com.cyp.springstudy.defaultListableBeanFactoryStudy.mybean;

import com.cyp.springstudy.testBean.factoryBeanTest.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName CarFactoryBean.java
 * @Description TODO
 * @createTime 2022年06月14日 17:36:00
 */
public class CarFactoryBean implements FactoryBean<Car> {
    private String carInfo;


    @Override
    public Car getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
