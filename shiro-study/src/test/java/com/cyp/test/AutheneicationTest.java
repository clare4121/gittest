package com.cyp.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName AutheneicationTest.java
 * @Description TODO
 * @createTime 2022年05月07日 14:47:00
 */
public class AutheneicationTest {

    SimpleAccountRealm simpleAccountRealm =new SimpleAccountRealm();
    @Before
    public void addUser(){
        simpleAccountRealm.addAccount("Mark","123456","admin");
    }
    @Test
    public void testAutheneication(){

        //构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager =new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);
        //主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token =new UsernamePasswordToken("Mark","123456");
        subject.login(token);
        System.out.println("----------------isAuthenticated--------------"+subject.isAuthenticated());
        subject.checkRole("admin");
        subject.logout();
        System.out.println("----------------isAuthenticated---"+subject.isAuthenticated());
    }
}
