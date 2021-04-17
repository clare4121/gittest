package com.cyp.springstudy.defaultListableBeanFactoryStudy;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service
public class Test {

    @Autowired
    DefaultListableBeanFactory defaultListableBeanFactory;
    XmlBeanDefinitionReader xmlBeanDefinitionReader;
    public static  Map testGetbean() throws InterruptedException, IOException {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("/static/beanFactoryTest.xml"));
        bf.getBean("beanScope");

        System.out.println("线程等待4秒");
        Thread.sleep(4000);
        ClassPathResource classPathResource = new ClassPathResource("/static/sceond/test.text");
        System.out.println("classPathResource.exists()----"+classPathResource.exists());
        System.out.println("classPathResource.getURL()----"+classPathResource.getURL());
        System.out.println("classPathResource.getDescription()----"+classPathResource.getDescription());
        System.out.println("classPathResource.getPath()----"+classPathResource.getPath());
        System.out.println("classPathResource.createRelative------"+classPathResource.createRelative(""));
        InputStream inputStream =classPathResource.getInputStream();
        int contentLength =(int)classPathResource.contentLength();
        byte[] b= new byte[1024];
       // inputStream.read(b);
        while (!(inputStream.read(b)==-1)){
            System.out.println(new String(b));
        }

        inputStream.close();
        return null;

    }




    public static void main(String[] args) throws InterruptedException, IOException {
        testGetbean();
        new ifNullChoose("123");
    }
    public void setTest(String test) {
    }
}
