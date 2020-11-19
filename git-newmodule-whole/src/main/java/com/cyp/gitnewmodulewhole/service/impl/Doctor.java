package com.cyp.gitnewmodulewhole.service.impl;

import com.cyp.gitnewmodulewhole.service.GongjuPeople;
import org.springframework.stereotype.Service;

@Service("doctor")
public class Doctor implements GongjuPeople {
    @Override
    public void gongju() {
        System.out.println("我是医生");
    }
}
