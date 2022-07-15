package com.cyp.newmapper.mapper;

import com.cyp.newmapper.entity.NkIndustryL3Entity;
import com.cyp.newmapper.entity.NkIndustryL3EntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NkIndustryL3Mapper {
    long countByExample(NkIndustryL3EntityExample example);

    int deleteByExample(NkIndustryL3EntityExample example);

    int insert(NkIndustryL3Entity record);

    int insertSelective(NkIndustryL3Entity record);

    List<NkIndustryL3Entity> selectByExample(NkIndustryL3EntityExample example);

    int updateByExampleSelective(@Param("record") NkIndustryL3Entity record, @Param("example") NkIndustryL3EntityExample example);

    int updateByExample(@Param("record") NkIndustryL3Entity record, @Param("example") NkIndustryL3EntityExample example);
}