package com.cyp.newmapper.mapper;

import com.cyp.newmapper.entity.GemCustomTemplateContent;

public interface GemCustomTemplateContentDao {
    int insert(GemCustomTemplateContent record);

    int insertSelective(GemCustomTemplateContent record);
}