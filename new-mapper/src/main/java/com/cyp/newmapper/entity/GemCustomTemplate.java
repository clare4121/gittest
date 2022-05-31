package com.cyp.newmapper.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * gem_custom_template
 * @author 
 */
@Data
public class GemCustomTemplate implements Serializable {
    /**
     * 创建用户ID
     */
    private String createOrg;

    /**
     * 个性化摸排模板编码（1IDC、2云计算...）
     */
    private String templateId;

    /**
     * 个性化摸排模板名称
     */
    private String templateName;

    /**
     * 个性化摸排模板描述
     */
    private String templateDetail;

    /**
     * 产品大类（1IDC、2云计算、3...）
     */
    private String productType;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    private static final long serialVersionUID = 1L;
}