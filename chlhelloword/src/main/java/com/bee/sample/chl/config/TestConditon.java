package com.bee.sample.chl.config;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;


/**
 * @author cyp
 * @version 1.0.0
 * @ClassName TestConditon.java
 * @Description TODO
 * @createTime 2022年09月07日 14:01:00
 */
public class TestConditon  implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String[] profiles =conditionContext.getEnvironment().getActiveProfiles();
        if(ObjectUtil.isNotEmpty(profiles) && profiles[0].equals("prod")) {
            System.out.println("------profiles[0]-----------------------"+profiles[0]);
            return true;
        } else {
            return false;
        }
    }
}
