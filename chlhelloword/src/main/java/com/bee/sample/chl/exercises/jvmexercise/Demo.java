package com.bee.sample.chl.exercises.jvmexercise;

import org.springframework.core.io.ClassPathResource;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName Demo.java
 * @Description TODO
 * @createTime 2022年12月21日 09:43:00
 */
public class Demo {

    //JVM的类加载分为5个阶段：加载、验证、准备、解析、初始化。在类初始化完成后就可以使用该类的信息，在一个类不再被需要时可以从JVM中卸载

    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("jvm加载.jpg");

    }

}
