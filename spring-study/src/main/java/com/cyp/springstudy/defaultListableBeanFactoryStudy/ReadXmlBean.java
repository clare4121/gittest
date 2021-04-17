package com.cyp.springstudy.defaultListableBeanFactoryStudy;



import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.io.InputStream;

public class ReadXmlBean {
    public static void main(String[] args) throws IOException {
        Resource resource =new ClassPathResource("beanFactoryTest.xml");
        InputStream input =resource.getInputStream();
    }


}
