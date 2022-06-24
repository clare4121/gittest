package com.bee.sample.chl.controller;

import com.bee.sample.chl.test.CarFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName FactoryBeanCarTestController.java
 * @Description TODO
 * @createTime 2022年06月15日 16:03:00
 */
@Controller
public class FactoryBeanCarTestController {
    @Autowired
    private ApplicationContext applicationContext;
    @RequestMapping("/getAllbeans")
    public void getAllbeans() {
       applicationContext.getApplicationName();
    }
}
