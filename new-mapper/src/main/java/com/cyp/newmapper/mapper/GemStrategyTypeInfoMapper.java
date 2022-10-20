package com.cyp.newmapper.mapper;

import com.cyp.newmapper.entity.GemStrategyTypeInfoDTO;

public interface GemStrategyTypeInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GemStrategyTypeInfoDTO record);

    int insertSelective(GemStrategyTypeInfoDTO record);

    GemStrategyTypeInfoDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GemStrategyTypeInfoDTO record);

    int updateByPrimaryKey(GemStrategyTypeInfoDTO record);
}