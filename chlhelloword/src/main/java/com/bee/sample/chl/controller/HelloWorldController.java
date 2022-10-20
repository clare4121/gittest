package com.bee.sample.chl.controller;

import com.bee.sample.chl.common.JwtUser;
import com.bee.sample.chl.web.TokenUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName HelloWorldController.java
 * @Description TODO
 * @createTime 2022年05月31日 17:14:00
 */
@Controller
public class HelloWorldController {
    @RequestMapping("sayhello.html")
    @ResponseBody
    public  String say(@TokenUser JwtUser jwtTokenUser){
        System.out.println(jwtTokenUser);
        System.out.println("------HelloWorldController的调用记录----------");
        return "hello Spring Boot";
    }







}
