package com.cyp.springstudy.defaultListableBeanFactoryStudy;

import org.springframework.beans.factory.BeanNameAware;

public class ShuXingB implements BeanNameAware {
    public String ss;


    public ShuXingB(String ss) {
        ss="123456";
        this.ss = ss;
    }
    @Override
    public void setBeanName(String s) {
    }
}
