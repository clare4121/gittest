package com.cyp.springstudy.macMyBeanTest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Map;

public class Test {

    public static Map testGetbean(){
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("/static/beanFactoryTest.xml"));
        return null;

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        testGetbean();
    }

}
