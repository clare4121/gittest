package com.cyp.newmapper.mapper;

import com.cyp.newmapper.entity.SmsQueueDTO;

public interface SmsQueueMapper {
    int deleteByPrimaryKey(Long rowNo);

    int insert(SmsQueueDTO record);

    int insertSelective(SmsQueueDTO record);

    SmsQueueDTO selectByPrimaryKey(Long rowNo);

    int updateByPrimaryKeySelective(SmsQueueDTO record);

    int updateByPrimaryKey(SmsQueueDTO record);
}