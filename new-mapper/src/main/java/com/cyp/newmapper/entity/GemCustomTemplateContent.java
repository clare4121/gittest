package com.cyp.newmapper.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * gem_custom_template_content
 * @author 
 */
@Data
public class GemCustomTemplateContent implements Serializable {
    /**
     * 产品类别（1IDC、2云计算、3...）
     */
    private String productType;

    /**
     * 个性化摸排模板编码（1IDC、2云计算...）
     */
    private String templateId;

    /**
     * 个性化摸排模板问题编码（1.1、1.2、1.3、2.1、2.2、2.3...）
     */
    private String contentId;

    /**
     * 个性化摸排模板问题内容
     */
    private String contentDesc;

    /**
     * 个性化摸排模板问题类型(1单选、2多选、3是非、4问答)
     */
    private String contentType;

    /**
     * 选项编码（a、b、c、d）
     */
    private String realAnserCode;

    /**
     * 选项内容（例a、IDC机柜产品需求（预留输入框）b、IDC带宽产品需求（预留输入框）
c、IDC增值产品需求（预留输入框）d、其他（预留输入框））
     */
    private String realAnser;

    /**
     * 顺序
     */
    private String shunxu;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 个性化摸排模板问题状态(1正常2作废)
     */
    private String contentStatus;

    private Date anserTime;

    /**
     * 是否需要填写补充内容(1不需要、2需要)
     */
    private String inputType;

    private static final long serialVersionUID = 1L;
}