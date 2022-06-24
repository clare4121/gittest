package com.cyp.springstudy.testBean;

import com.cyp.springstudy.defaultListableBeanFactoryStudy.test.GetBeanTest;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Map;

public class MethodChangeMainTest {
    @Autowired
    DefaultListableBeanFactory defaultListableBeanFactory;
    XmlBeanDefinitionReader xmlBeanDefinitionReader;
    public static Map testGetbean(){
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("/static/TestChangeMethod.xml"));
        GetBeanTest test =(GetBeanTest) bf.getBean("GetBeanTest");
        test.showMe();
        return null;
    }


    public static void main(String[] args) {
        testGetbean();
    }
}
