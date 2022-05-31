package com.cyp.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName IniRealmTest.java
 * @Description TODO
 * @createTime 2022年05月07日 15:16:00
 */
public class IniRealmTest {

    @Test
    public void testAutheneication(){
        IniRealm iniRealm =new IniRealm("classpath:user.ini");

        //构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager =new DefaultSecurityManager();
        //defaultSecurityManager.setRealm(simpleAccountRealm);
        defaultSecurityManager.setRealm(iniRealm);
        //主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token =new UsernamePasswordToken("Mark","123456");
        subject.login(token);
        System.out.println("----------------isAuthenticated--------------"+subject.isAuthenticated());
        subject.checkRole("admin");

        subject.checkPermission("user:delete");
    }
}
