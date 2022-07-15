package com.cyp.newmapper.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * nk_industry_l3
 * @author 
 */
@Data
public class NkIndustryL3Entity implements Serializable {
    /**
     * 国民经济行业分类1级
     */
    private String nkIndustryL1;

    /**
     * 国民经济行业分类2级
     */
    private String nkIndustryL2;

    /**
     * 国民经济行业分类3级
     */
    private String nkIndustryL3;

    /**
     * 国民经济行业分类1级名称
     */
    private String nkIndustryL1Name;

    /**
     * 国民经济行业分类2级名称
     */
    private String nkIndustryL2Name;

    /**
     * 国民经济行业分类3级名称
     */
    private String nkIndustryL3Name;

    private static final long serialVersionUID = 1L;
}