package com.cyp.newmapper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName DemoController.java
 * @Description TODO
 * @createTime 2022年01月27日 17:03:00
 */
@RestController
@RequestMapping("/api/test")
public class DemoController {
    public ModelAndView index(){
        return new ModelAndView(){{
            setViewName("demo/testFTl");
        }};
    }
    @PostMapping("/demo")
    public List demo(){
        List<String> list =new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
     return list;
    }

}
