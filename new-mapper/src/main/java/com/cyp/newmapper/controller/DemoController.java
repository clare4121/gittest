package com.cyp.newmapper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName DemoController.java
 * @Description TODO
 * @createTime 2022年01月27日 17:03:00
 */
@Controller
@RequestMapping("/api/demo")
public class DemoController {
    public ModelAndView index(){
        return new ModelAndView(){{
            setViewName("demo/testFTl");
        }};
    }

}
