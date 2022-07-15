package com.cyp.springstudy.six_one;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName ApplicationContextLoadXml.java
 * @Description TODO
 * @createTime 2022年07月05日 10:47:00
 */
@Service
public class ApplicationContextLoadXml {
    ApplicationContext bf =new ClassPathXmlApplicationContext("/static/beanFactoryTest.xm");

}
