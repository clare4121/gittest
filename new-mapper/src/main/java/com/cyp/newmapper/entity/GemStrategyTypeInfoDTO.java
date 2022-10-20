package com.cyp.newmapper.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * gem_strategy_type_info
 * @author 
 */
@Data
public class GemStrategyTypeInfoDTO implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 策略类型编码
     */
    private String strategyTypeId;

    /**
     * 策略类型名称
     */
    private String strategyTypeName;

    /**
     * 策略类型归属 1、双融经营 2、靶向经营
     */
    private String strategyTypeAscription;

    /**
     * 适配属性  1、市公司 2、BU 3、区分
     */
    private String adaptationType;

    /**
     * 是否有效
     */
    private String isValid;

    /**
     * 备用字段1
     */
    private String spare1;

    /**
     * 备用字段2
     */
    private String spare2;

    /**
     * 创建人
     */
    private String loginId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}