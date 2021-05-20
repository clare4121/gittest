package com.cyp.springstudy.defaultListableBeanFactoryStudy.test;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class BeanFactoryTestTwoTest {

    @Autowired
    DefaultListableBeanFactory defaultListableBeanFactory;
    XmlBeanDefinitionReader xmlBeanDefinitionReader;
    public static  Map testGetbean() throws InterruptedException, IOException {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("/static/beanFactoryTestTwo.xml"));
        GetBeanTest test =(GetBeanTest) bf.getBean("getBeanTest");
        test.showMe();
        return null;
    }


    public static void main(String[] args) throws InterruptedException, IOException {
        testGetbean();
    }
}
