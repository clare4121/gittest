package com.bee.sample.chl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName FactoryBeanCarTestController.java
 * @Description TODO
 * @createTime 2022年06月15日 16:03:00
 */
@RestController
@RequestMapping("/api")
public class FactoryBeanCarTestController {
    @Autowired
    private ApplicationContext applicationContext;
    @RequestMapping(value = "/getAllbeans")
    public String getAllbeans() {
       String names= applicationContext.getApplicationName();
       return names;
    }
}
