package com.cyp.gitnewmodulewhole.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class Demo {
    public    void main() {
        log.info("---------start---------------");
        log.info("这是一个测试demo");
        log.info("git");
        log.info("---------end----------------");

    }

    public static void main(String[] args) {
        String str ="青浦渠道中心,嘉定大客户一中心,网格名称2";
        String arr2 ="(\'"+str.replaceAll(",","\',\'")+"\')";
        System.out.println(arr2);
        String[] arr =str.split(",");
        String str2=null;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
