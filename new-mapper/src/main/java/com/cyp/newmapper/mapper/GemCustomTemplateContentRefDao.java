package com.cyp.newmapper.mapper;

import com.cyp.newmapper.entity.GemCustomTemplateContentRef;

public interface GemCustomTemplateContentRefDao {
    int insert(GemCustomTemplateContentRef record);

    int insertSelective(GemCustomTemplateContentRef record);
}