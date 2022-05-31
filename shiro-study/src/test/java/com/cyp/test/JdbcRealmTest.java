package com.cyp.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.omg.CORBA.DATA_CONVERSION;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName JdbcRealmTest.java
 * @Description TODO
 * @createTime 2022年05月07日 15:33:00
 */
public class JdbcRealmTest {
    DruidDataSource dataSource =new DruidDataSource();
    {
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setName("root");
        dataSource.setPassword("123456");
    }

        @Test
        public void testAutheneication(){
            JdbcRealm jdbcRealm =new JdbcRealm();
            jdbcRealm.setDataSource(dataSource);
            //构建SecurityManager环境
            DefaultSecurityManager defaultSecurityManager =new DefaultSecurityManager();
            //defaultSecurityManager.setRealm(simpleAccountRealm);
            defaultSecurityManager.setRealm(jdbcRealm);
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
