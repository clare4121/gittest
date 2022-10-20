package com.cyp.newmapper.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sms_queue
 * @author 
 */
@Data
public class SmsQueueDTO implements Serializable {
    private Long rowNo;

    private String deviceNumber;

    private String smsContent;

    private Date sendTime;

    /**
     * 0: 手动发送。1: 定点发送
     */
    private String isSet;

    /**
     * 发送用户ID,汉字代表发给谁，英文代表那个工号发的
     */
    private String loginId;

    private static final long serialVersionUID = 1L;
}