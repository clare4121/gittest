package com.bee.sample.chl.exercises.annotionexercise;

import java.lang.annotation.*;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName FruitProvider.java
 * @Description TODO
 * @createTime 2022年12月21日 16:51:00
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    public int id() default  -1;
    public String name() default "";
    public String address() default "";

}
