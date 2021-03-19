package com.cyp.gitnewmodulewhole.controller;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class httpTest {


    DefaultListableBeanFactory defaultListableBeanFactory =new DefaultListableBeanFactory();

    @Override
    public String toString() {
       return defaultListableBeanFactory.toString();
    }

    public static void main(String[] args) {
        new httpTest().toString();
    }
}
