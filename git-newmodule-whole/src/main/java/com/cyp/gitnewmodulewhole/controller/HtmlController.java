package com.cyp.gitnewmodulewhole.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/index/")
public class HtmlController {
    @RequestMapping("htmlDemo")
    public String htmlDemo() {
        return "index";
    }
}
