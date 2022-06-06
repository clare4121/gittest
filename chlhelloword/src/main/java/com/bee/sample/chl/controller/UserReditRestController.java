package com.bee.sample.chl.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName UserReditRestController.java
 * @Description TODO
 * @createTime 2022年06月04日 22:38:00
 */
@RestController
public class UserReditRestController {
    @RequestMapping(value = "/usercredit/{id}")
    public Integer getCreditLevel(@PathVariable String id){
        int a=Integer.valueOf(id);
        return a;
    }
}
