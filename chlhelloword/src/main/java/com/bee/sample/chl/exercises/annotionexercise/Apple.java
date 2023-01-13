package com.bee.sample.chl.exercises.annotionexercise;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName Apple.java
 * @Description TODO
 * @createTime 2022年12月21日 16:54:00
 */

public class Apple {

    @FruitProvider(id=1,name="陕西红富士集团",address = "陕西省西安市")
    private String appleProvider;
    public String getAppleProvider() {
        return appleProvider;
    }
    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}
