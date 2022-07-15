package com.cyp.newmapper.mapper;

import com.cyp.newmapper.entity.LabelUseLog;

public interface LabelUseLogMapper {
    int insert(LabelUseLog record);

    int insertSelective(LabelUseLog record);
}