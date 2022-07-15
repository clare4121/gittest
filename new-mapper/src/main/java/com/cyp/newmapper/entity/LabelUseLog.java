package com.cyp.newmapper.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * label_use_log
 * @author 
 */
@Data
public class LabelUseLog implements Serializable {
    /**
     * 标签id
     */
    private String labelId;

    /**
     * 使用人
     */
    private String usePerson;

    /**
     * 使用时间
     */
    private String useTime;

    /**
     * 标签名称
     */
    private String labelName;

    /**
     * 标签值
     */
    private String labelValue;

    /**
     * 使用接口
     */
    private String useInterface;

    /**
     * 最小
     */
    private String labelValueMin;

    /**
     * 最大
     */
    private String labelValueMax;

    /**
     * 类型
     */
    private String labelType;

    private static final long serialVersionUID = 1L;
}