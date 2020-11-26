package com.cyp.newmapper.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cyp.newmapper.entity.TActTouchBlb;
import com.cyp.newmapper.entity.TActTouchSms;
import com.cyp.newmapper.mapper.TActTouchBlbMapper;
import com.cyp.newmapper.mapper.TActTouchSmsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DemoImpl {
    @Autowired
    TActTouchSmsMapper tActTouchSmsMapper;
    @Autowired
    TActTouchBlbMapper tActTouchBlbMapper;
    public List<TActTouchSms> sayImpl(String activityId){
        LambdaQueryWrapper<TActTouchSms> tActTouchSmsLambdaQueryWrapper = Wrappers.lambdaQuery(TActTouchSms.class);
        tActTouchSmsLambdaQueryWrapper.eq(TActTouchSms::getActivityId,activityId);
        System.out.println(tActTouchSmsLambdaQueryWrapper);
        List<TActTouchSms> list =tActTouchSmsMapper.selectList(tActTouchSmsLambdaQueryWrapper);
        System.out.println("sayImpl----方法");
        for (TActTouchSms tt:list) {
            System.out.println(tt);
        }
        return list;
    }

    public String sayImpl2(String activityId){
        TActTouchBlb tActTouchBlb =new TActTouchBlb();
        tActTouchBlb.setActivityId(activityId);
        List<TActTouchBlb> list =tActTouchBlbMapper.selectTActTouchBlbInfo(activityId);
        for (TActTouchBlb ll: list) {
            System.out.println(ll);
        }
        return  null;
    }
}
