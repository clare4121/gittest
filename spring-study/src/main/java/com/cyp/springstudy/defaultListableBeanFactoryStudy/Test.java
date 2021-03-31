package com.cyp.springstudy.defaultListableBeanFactoryStudy;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Test {

    @Autowired
    DefaultListableBeanFactory defaultListableBeanFactory;
    XmlBeanDefinitionReader xmlBeanDefinitionReader;
    public static  Map testGetbean(){
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        return null;
    }
    public static String defaultSay(){
        return  "aaaa";
    }
    public static String defaultSay(String aa){
        return aa;
    }
    public static void main(String[] args) {
        testGetbean();
        new ifNullChoose("123");
    }
}
