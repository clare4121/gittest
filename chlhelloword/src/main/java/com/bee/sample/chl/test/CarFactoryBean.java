package com.bee.sample.chl.test;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName CarFactoryBean.java
 * @Description TODO
 * @createTime 2022年06月14日 17:41:00
 */
@Component
public class CarFactoryBean implements FactoryBean<Car> {

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    private  String carInfo;
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos =carInfo.split(",");
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.valueOf(infos[1]));
        car.setPrice(Integer.valueOf(infos[2]));
        return car;
    }


    public Class<?> getObjectType() {
        return Car.class;
    }


    public boolean isSingleton() {
        return false;
    }
}
