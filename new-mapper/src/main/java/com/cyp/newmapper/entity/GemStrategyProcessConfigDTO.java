package com.cyp.newmapper.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * gem_strategy_process_config
 * @author 
 */
@Data
public class GemStrategyProcessConfigDTO implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 执行编码
     */
    private String actionCode;

    /**
     * 执行动作
     */
    private String actionName;

    /**
     * 级别
     */
    private String actionLever;

    /**
     * 动作顺序
     */
    private String actionOrder;

    /**
     * 父级编码
     */
    private String parentId;

    /**
     * 动作描述
     */
    private String actionDesc;

    /**
     * 策略类型归属 1、双融经营 2、靶向经营
     */
    private String strategyTypeAscription;

    /**
     * 是否有效
     */
    private String isValid;

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