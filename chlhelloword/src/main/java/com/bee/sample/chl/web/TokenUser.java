package com.bee.sample.chl.web;

import java.lang.annotation.*;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName TokenUser.java
 * @Description TODO
 * @createTime 2022年09月13日 15:53:00
 */
@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenUser {}
