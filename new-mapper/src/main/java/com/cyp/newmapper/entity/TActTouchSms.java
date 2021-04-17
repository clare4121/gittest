package com.cyp.newmapper.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * T_ACT_TOUCH_SMS
 * @author 
 */
@Data
@Builder
public class TActTouchSms implements Serializable {
    /**
     * 波次ID
     */
    private String waveId;

    /**
     * 构成ID
     */
    private String consistId;

    /**
     * 策略ID
     */
    private String activityId;

    /**
     * 短信网关
     */
    private String smsGateway;

    /**
     * 话术信息
     */
    private String words;

    /**
     * 内嵌URL
     */
    private String inUrl;

    /**
     * URL短地址
     */
    private String inShortUrl;

    /**
     * 0-不接收回复订购    1-接收回复订购
     */
    private Short ifOrder;

    /**
     * 是否接收回复订购
     */
    private String productId;

    /**
     * 短信回复订购码
     */
    private String smsOrderCode;

    /**
     * 短信回复有效期，单位分钟
     */
    private Short smsValidDura;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 话术 html
     */
    private String wordsHtml;

    /**
     * 执行时段
     */
    private String executeTime;

    /**
     * 实时短信发送有效期
     */
    private String passDate;

    private String customFilterType;

    private String touchRule;

    private static final long serialVersionUID = 1L;
}