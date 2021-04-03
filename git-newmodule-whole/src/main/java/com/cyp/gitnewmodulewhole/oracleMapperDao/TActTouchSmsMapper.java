package com.cyp.gitnewmodulewhole.oracleMapperDao;

import com.cyp.gitnewmodulewhole.oracleMapperModel.TActTouchSms;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface TActTouchSmsMapper {
    int  insert(TActTouchSms record);
    List<TActTouchSms> select();
    int insertSelective(TActTouchSms record);
    int insertTActTouchSmsBatch(List<TActTouchSms> listRecord);
    int insertTActTouchSmsBatch2(List<TActTouchSms> listRecord);
    List<String> selectWaveIdBatch(int rownum);
    int deleteTActTouchSmsBatch(List list);
}