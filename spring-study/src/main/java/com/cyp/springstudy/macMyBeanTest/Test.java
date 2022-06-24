package com.cyp.springstudy.macMyBeanTest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    private static final Map<String, String> transformedBeanNameCache = new ConcurrentHashMap();
    public static Map testGetbean(){
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("/static/beanFactoryTest.xml"));
        return null;

    }

    public static void main(String[] args)  {
       String beanName ="&&&123&&";
        System.out.println("&&".length());
        beanName = beanName.substring(4);
        System.out.println(beanName);
        System.out.println(demo());
    }


public static String  demo (){

    String name="&&&111&&&&&111qwqwqw";
    return !name.startsWith("&") ? name : (String)transformedBeanNameCache.computeIfAbsent(name, (beanName) -> {
        do {
            beanName = beanName.substring("&".length());
        } while(beanName.startsWith("&"));

        return beanName;
    });
}
}
