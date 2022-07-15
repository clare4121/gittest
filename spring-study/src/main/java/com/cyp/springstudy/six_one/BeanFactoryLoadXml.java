package com.cyp.springstudy.six_one;

import com.cyp.springstudy.defaultListableBeanFactoryStudy.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName BeanFactoryLoadXml.java
 * @Description TODO
 * @createTime 2022年07月05日 10:47:00
 */
@Service
public class BeanFactoryLoadXml {
    @Autowired
    DefaultListableBeanFactory defaultListableBeanFactory;
    XmlBeanDefinitionReader xmlBeanDefinitionReader;
    public static Map testGetbean() throws InterruptedException, IOException {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("/static/beanFactoryTest.xml"));
        com.cyp.springstudy.defaultListableBeanFactoryStudy.Test test =(Test) bf.getBean("beanScope");
        test.setTest("测试");
        System.out.println(test);
        return null;

    }





    public static void main(String[] args) throws IOException, InterruptedException {
        testGetbean();
        FactoryBean factoryBean= new FactoryBean() {
            @Override
            public Object getObject() throws Exception {
                return null;
            }

            @Override
            public Class<?> getObjectType() {
                return null;
            }
        };
        factoryBean.isSingleton();

    }
    public void setTest(String test) {
        System.out.println(test);
    }



}
