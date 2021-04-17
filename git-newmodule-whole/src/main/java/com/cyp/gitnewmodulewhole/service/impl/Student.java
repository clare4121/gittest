package com.cyp.gitnewmodulewhole.service.impl;

import com.cyp.gitnewmodulewhole.service.GongjuPeople;
import org.springframework.stereotype.Service;

@Service("student")
public class Student implements GongjuPeople {
    @Override
    public void gongju() {
        System.out.println("我是学生");
    }
}
