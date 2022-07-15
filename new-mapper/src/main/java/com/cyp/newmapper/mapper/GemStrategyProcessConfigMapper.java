package com.cyp.newmapper.mapper;

import com.cyp.newmapper.entity.GemStrategyProcessConfigDTO;

public interface GemStrategyProcessConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GemStrategyProcessConfigDTO record);

    int insertSelective(GemStrategyProcessConfigDTO record);

    GemStrategyProcessConfigDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GemStrategyProcessConfigDTO record);

    int updateByPrimaryKey(GemStrategyProcessConfigDTO record);
}