package com.cyp.newmapper.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * gem_custom_template_content_ref
 * @author 
 */
@Data
public class GemCustomTemplateContentRef implements Serializable {
    /**
     * 个性化摸排模板编码（1IDC、2云计算...）
     */
    private String templateId;

    /**
     * 个性化摸排模板问题编码（1.1、1.2、1.3、2.1、2.2、2.3...）
     */
    private String contentId;

    private static final long serialVersionUID = 1L;
}