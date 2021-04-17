package com.cyp.gitnewmodulewhole.demo;

import com.cyp.gitnewmodulewhole.ContextBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class GetBean {
    @Autowired
    private static  ContextBeanUtil contextBeanUtil;
    private  static String getName(String name ){
        contextBeanUtil.getStorageType("");
        return null;
    }
    public static void main(String[] args) {
       getName("");
    }
}
