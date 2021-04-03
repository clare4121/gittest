package com.cyp.gitnewmodulewhole.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyp.gitnewmodulewhole.oracleMapperDao.TActTouchSmsMapper;
import com.cyp.gitnewmodulewhole.oracleMapperModel.TActTouchSms;
import com.cyp.gitnewmodulewhole.util.DaoHelper;
import com.cyp.gitnewmodulewhole.util.GetPostTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/demo")
public class DemoController {

    private final TActTouchSmsMapper tActTouchSmsMapper;

    public DemoController(TActTouchSmsMapper tActTouchSmsMapper) {
        this.tActTouchSmsMapper = tActTouchSmsMapper;
    }

    @PostMapping("/firstDemo")
    @ResponseBody
    public String firstDemo(@RequestBody JSONObject  jsonObject){
        System.out.println(new Date()+"====接口调用开始记录");
//        JSONObject jsonObject =JSONObject.parseObject(str);
        //获取的jsonObject值存在map中
//        Map map =new HashMap<String,Object>();
//        map.put("activityId",jsonObject.getString("Id"));
//        List<TActTouchSms>  list =tActTouchSmsMapper.select();
//        System.out.println(list.size());
//        int a =tActTouchSmsMapper.insertTActTouchSmsBatch(list);
//        System.out.println(a);
//        List waveIdlist =tActTouchSmsMapper.selectWaveIdBatch(101);
//        int b= tActTouchSmsMapper.deleteTActTouchSmsBatch(waveIdlist);
//        System.out.println(b);
        return jsonObject.toString()+"--first";
    }
    @GetMapping("/secondDemo")
    @ResponseBody
    public String secondDemo(@RequestBody String str){
        System.out.println(str);
        return str;
    }
}
