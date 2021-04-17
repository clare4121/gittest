package com.cyp.gitnewmodulewhole.controller;

import com.cyp.gitnewmodulewhole.entity.UserEntity;
import org.apache.ibatis.io.Resources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/ftlIndex/")
public class FtlController {
    @RequestMapping("ftlDemo")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("demo/login");
        return modelAndView;
    }

}
