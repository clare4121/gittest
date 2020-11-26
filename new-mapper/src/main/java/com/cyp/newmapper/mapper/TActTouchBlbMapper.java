package com.cyp.newmapper.mapper;

import com.cyp.newmapper.entity.TActTouchBlb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TActTouchBlbMapper {
    int insert(TActTouchBlb record);
    int insertSelective(TActTouchBlb record);
    List<TActTouchBlb> selectTActTouchBlbInfo(String activityId);
}