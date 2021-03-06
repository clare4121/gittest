package com.cyp.newmapper.entity;


import lombok.Data;

/**
 * T_ACT_TOUCH_BLB
 * @author 
 */
@Data
public class TActTouchBlb  {
    /**
     * 活动ID
     */
    private String activityId;

    /**
     * 策略ID
     */
    private String consistId;

    /**
     * 波次ID
     */
    private String waveId;

    /**
     * corn表达式
     */
    private String cronExpression;

    private static final long serialVersionUID = 1L;
}