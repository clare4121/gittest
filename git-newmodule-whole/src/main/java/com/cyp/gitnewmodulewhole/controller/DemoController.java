package com.cyp.gitnewmodulewhole.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/demo")
public class DemoController {

    @PostMapping("/firstDemo")
    @ResponseBody
    public String firstDemo(@RequestBody JSONObject  jsonObject){
        System.out.println(new Date()+"====接口调用开始记录");
//        JSONObject jsonObject =JSONObject.parseObject(str);
        //获取的jsonObject值存在map中
        Map map =new HashMap<String,Object>();
        map.put("activityId",jsonObject.getString("Id"));
//        List<Map<String,Object>> mapList = getSmsInfo.getSmsList(map);
        //存数据库

        return jsonObject.toString()+"first";
    }
    @GetMapping("/secondDemo")
    @ResponseBody
    public String secondDemo(@RequestBody String str){
        System.out.println(str);
        return str;
    }
}
