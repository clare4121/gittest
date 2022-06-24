package com.cyp.springstudy.testBean.factoryBeanTest;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName Car.java
 * @Description TODO
 * @createTime 2022年06月14日 17:39:00
 */

public class Car {
    private String brand;
    private  int maxSpeed;
    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
