package com.cyp.newmapper.mapper;

import com.cyp.newmapper.entity.GemCustomTemplate;

public interface GemCustomTemplateDao {
    int insert(GemCustomTemplate record);

    int insertSelective(GemCustomTemplate record);
}