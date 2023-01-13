package com.bee.sample.chl.exercises.reflectexercise;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName Person.java
 * @Description TODO
 * @createTime 2022年12月21日 16:04:00
 */
public class Person {
    private  String loginId;
    private String  name;

    public Person() {
    }

    public Person(String loginId, String name) {
        this.loginId = loginId;
        this.name = name;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
