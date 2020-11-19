package com.cyp.gitnewmodulewhole.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/firstDemo")
    @ResponseBody
    public String Test(@RequestBody JSONObject jsonObject){
        return jsonObject.toString();
    }
}
