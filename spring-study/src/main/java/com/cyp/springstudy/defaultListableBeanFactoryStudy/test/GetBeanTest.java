package com.cyp.springstudy.defaultListableBeanFactoryStudy.test;

import com.cyp.springstudy.defaultListableBeanFactoryStudy.mybean.User;

public  abstract class GetBeanTest {
    public  void showMe(){
        this.getBean().showMe();
    }
    public abstract User getBean();
}
