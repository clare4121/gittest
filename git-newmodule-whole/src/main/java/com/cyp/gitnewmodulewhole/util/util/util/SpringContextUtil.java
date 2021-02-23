package com.cyp.gitnewmodulewhole.util.util.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author zhaoxuan
 * @description Spring工具类
 * @createTime 2020/5/20 3:08 下午
 */
public class SpringContextUtil implements ApplicationContextAware {

    //Spring应用上下文环境
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {

        return applicationContext;

    }

    public static Object getBean(String name) throws BeansException {

        return applicationContext.getBean(name);

    }

    public static <T> T getBean(Class<T> requiredType) {

        return applicationContext.getBean(requiredType);

    }

    public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {

        return applicationContext.getBean(name, requiredType);

    }

    public static boolean containsBean(String name) {

        return applicationContext.containsBean(name);

    }

    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {

        return applicationContext.isSingleton(name);

    }

    @SuppressWarnings("rawtypes")
    public static Class getType(String name) throws NoSuchBeanDefinitionException {

        return applicationContext.getType(name);

    }

    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {

        return applicationContext.getAliases(name);

    }
}
