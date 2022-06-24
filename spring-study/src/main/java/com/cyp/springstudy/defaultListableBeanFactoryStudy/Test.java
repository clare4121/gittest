package com.cyp.springstudy.defaultListableBeanFactoryStudy;


import org.springframework.beans.BeansException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.Scope;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.metrics.StartupStep;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service
public class Test {

    @Autowired
    DefaultListableBeanFactory defaultListableBeanFactory;
    XmlBeanDefinitionReader xmlBeanDefinitionReader;
    public static  Map testGetbean() throws InterruptedException, IOException {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("/static/beanFactoryTest.xml"));
        Test test =(Test) bf.getBean("beanScope");
        test.setTest("测试");
        System.out.println(test);
        ClassPathResource classPathResource = new ClassPathResource("/static/sceond/test.text");
        System.out.println("classPathResource.exists()----"+classPathResource.exists());
        System.out.println("classPathResource.getURL()----"+classPathResource.getURL());
        System.out.println("classPathResource.getDescription()----"+classPathResource.getDescription());
        System.out.println("classPathResource.getPath()----"+classPathResource.getPath());
        System.out.println("classPathResource.createRelative------"+classPathResource.createRelative(""));
        return null;

    }





    public static void main(String[] args) throws IOException, InterruptedException {
        testGetbean();
        FactoryBean factoryBean= new FactoryBean() {
            @Override
            public Object getObject() throws Exception {
                return null;
            }

            @Override
            public Class<?> getObjectType() {
                return null;
            }
        };
        factoryBean.isSingleton();

    }
    public void setTest(String test) {
        System.out.println(test);
    }






    //=====================================以下内容可忽略=========================================
//
//    protected <T> T doGetBean(String name, @Nullable Class<T> requiredType, @Nullable Object[] args, boolean typeCheckOnly) throws BeansException {
//        String beanName = this.transformedBeanName(name);
//        Object sharedInstance = this.getSingleton(beanName);
//        Object bean;
//        if (sharedInstance != null && args == null) {
//            if (this.logger.isTraceEnabled()) {
//                if (this.isSingletonCurrentlyInCreation(beanName)) {
//                    this.logger.trace("Returning eagerly cached instance of singleton bean '" + beanName + "' that is not fully initialized yet - a consequence of a circular reference");
//                } else {
//                    this.logger.trace("Returning cached instance of singleton bean '" + beanName + "'");
//                }
//            }
//
//            bean = this.getObjectForBeanInstance(sharedInstance, name, beanName, (RootBeanDefinition)null);
//        } else {
//            if (this.isPrototypeCurrentlyInCreation(beanName)) {
//                throw new BeanCurrentlyInCreationException(beanName);
//            }
//
//            BeanFactory parentBeanFactory = this.getParentBeanFactory();
//            if (parentBeanFactory != null && !this.containsBeanDefinition(beanName)) {
//                String nameToLookup = this.originalBeanName(name);
//                if (parentBeanFactory instanceof AbstractBeanFactory) {
//                    return ((AbstractBeanFactory)parentBeanFactory).doGetBean(nameToLookup, requiredType, args, typeCheckOnly);
//                }
//
//                if (args != null) {
//                    return parentBeanFactory.getBean(nameToLookup, args);
//                }
//
//                if (requiredType != null) {
//                    return parentBeanFactory.getBean(nameToLookup, requiredType);
//                }
//
//                return parentBeanFactory.getBean(nameToLookup);
//            }
//
//            if (!typeCheckOnly) {
//                this.markBeanAsCreated(beanName);
//            }
//
//            StartupStep beanCreation = this.applicationStartup.start("spring.beans.instantiate").tag("beanName", name);
//
//            try {
//                if (requiredType != null) {
//                    beanCreation.tag("beanType", requiredType::toString);
//                }
//
//                RootBeanDefinition mbd = this.getMergedLocalBeanDefinition(beanName);
//                this.checkMergedBeanDefinition(mbd, beanName, args);
//                String[] dependsOn = mbd.getDependsOn();
//                String[] var12;
//                if (dependsOn != null) {
//                    var12 = dependsOn;
//                    int var13 = dependsOn.length;
//
//                    for(int var14 = 0; var14 < var13; ++var14) {
//                        String dep = var12[var14];
//                        if (this.isDependent(beanName, dep)) {
//                            throw new BeanCreationException(mbd.getResourceDescription(), beanName, "Circular depends-on relationship between '" + beanName + "' and '" + dep + "'");
//                        }
//
//                        this.registerDependentBean(dep, beanName);
//
//                        try {
//                            this.getBean(dep);
//                        } catch (NoSuchBeanDefinitionException var33) {
//                            throw new BeanCreationException(mbd.getResourceDescription(), beanName, "'" + beanName + "' depends on missing bean '" + dep + "'", var33);
//                        }
//                    }
//                }
//
//                if (mbd.isSingleton()) {
//                    sharedInstance = this.getSingleton(beanName, () -> {
//                        try {
//                            return this.createBean(beanName, mbd, args);
//                        } catch (BeansException var5) {
//                            this.destroySingleton(beanName);
//                            throw var5;
//                        }
//                    });
//                    bean = this.getObjectForBeanInstance(sharedInstance, name, beanName, mbd);
//                } else if (mbd.isPrototype()) {
//                    var12 = null;
//
//                    Object prototypeInstance;
//                    try {
//                        this.beforePrototypeCreation(beanName);
//                        prototypeInstance = this.createBean(beanName, mbd, args);
//                    } finally {
//                        this.afterPrototypeCreation(beanName);
//                    }
//
//                    bean = this.getObjectForBeanInstance(prototypeInstance, name, beanName, mbd);
//                } else {
//                    String scopeName = mbd.getScope();
//                    if (!StringUtils.hasLength(scopeName)) {
//                        throw new IllegalStateException("No scope name defined for bean ��" + beanName + "'");
//                    }
//
//                    Scope scope = (Scope)this.scopes.get(scopeName);
//                    if (scope == null) {
//                        throw new IllegalStateException("No Scope registered for scope name '" + scopeName + "'");
//                    }
//
//                    try {
//                        Object scopedInstance = scope.get(beanName, () -> {
//                            this.beforePrototypeCreation(beanName);
//
//                            Object var4;
//                            try {
//                                var4 = this.createBean(beanName, mbd, args);
//                            } finally {
//                                this.afterPrototypeCreation(beanName);
//                            }
//
//                            return var4;
//                        });
//                        bean = this.getObjectForBeanInstance(scopedInstance, name, beanName, mbd);
//                    } catch (IllegalStateException var32) {
//                        throw new ScopeNotActiveException(beanName, scopeName, var32);
//                    }
//                }
//            } catch (BeansException var35) {
//                beanCreation.tag("exception", var35.getClass().toString());
//                beanCreation.tag("message", String.valueOf(var35.getMessage()));
//                this.cleanupAfterBeanCreationFailure(beanName);
//                throw var35;
//            } finally {
//                beanCreation.end();
//            }
//        }
//
//        if (requiredType != null && !requiredType.isInstance(bean)) {
//            try {
//                T convertedBean = this.getTypeConverter().convertIfNecessary(bean, requiredType);
//                if (convertedBean == null) {
//                    throw new BeanNotOfRequiredTypeException(name, requiredType, bean.getClass());
//                } else {
//                    return convertedBean;
//                }
//            } catch (TypeMismatchException var34) {
//                if (this.logger.isTraceEnabled()) {
//                    this.logger.trace("Failed to convert bean '" + name + "' to required type '" + ClassUtils.getQualifiedName(requiredType) + "'", var34);
//                }
//
//                throw new BeanNotOfRequiredTypeException(name, requiredType, bean.getClass());
//            }
//        } else {
//            return bean;
//        }
//    }
}
