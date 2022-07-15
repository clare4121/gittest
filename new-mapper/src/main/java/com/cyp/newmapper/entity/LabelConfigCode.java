package com.cyp.newmapper.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * label_config_code
 * @author 
 */
@Data
public class LabelConfigCode implements Serializable {
    /**
     * 标签id
     */
    private String labelId;

    /**
     * 页面字段名
     */
    private String webField;

    /**
     * 表字段名
     */
    private String tableField;

    /**
     * 字段描述
     */
    private String fieldDesc;

    /**
     * 是否再用
     */
    private String ifUse;

    /**
     * 标签类型 1常规标签  2范围标签
     */
    private String labelType;

    /**
     * 取值类型 1常规  2 数组
     */
    private String valueType;

    private static final long serialVersionUID = 1L;
}