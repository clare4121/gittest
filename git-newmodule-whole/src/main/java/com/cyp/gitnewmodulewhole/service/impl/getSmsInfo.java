package com.cyp.gitnewmodulewhole.service.impl;

import com.cyp.gitnewmodulewhole.util.DaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class getSmsInfo {
    @Autowired
    private DaoHelper daoHelper;
    public List<Map<String,Object>>  getSmsList(Map map){
        return daoHelper.queryForList("com.cyp.gitnewmodulewhole.mapper.DemoMapper.smsinfo",map);
    }
}
