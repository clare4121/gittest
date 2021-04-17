package com.cyp.gitnewmodulewhole.mapper.impl;

import com.cyp.gitnewmodulewhole.util.DaoHelper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DemoImpl {
    @Autowired
    DaoHelper daoHelper;
    public List<Map<String,Object>>  getSmsInfo(Map map){
        return daoHelper.queryForList("com.cyp.gitnewmodulewhole.mapper.DemoMapper.getSmsInfo",map);
    }
    public int getSmsCount(List<String> list){
        return daoHelper.selectCount("com.cyp.gitnewmodulewhole.mapper.DemoMapper.getSmsCount");
    }
}
