package com.cyp.gitnewmodulewhole.controller;

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    com.cyp.gitnewmodulewhole.service.impl.getSmsInfo getSmsInfo;
    @RequestMapping("/firstDemo")
    @ResponseBody
    public String Test(@RequestBody JSONObject jsonObject){
        //获取的jsonObject值存在map中
        Map map =new HashMap<String,Object>();
        map.put("activityId",jsonObject.getString("Id"));
        List<Map<String,Object>> mapList = getSmsInfo.getSmsList(map);
        //存数据库
        return jsonObject.toString();
    }
}
