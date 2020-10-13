package com.cyp.gitnewmodulewhole.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
@Slf4j
@EnableScheduling
@Configuration
public class scheduleTaskDemo {
    @Value("${userinfo.name}")
    private String username;
    @Value("${userinfo.password}")
    private String userpassword;
//        @Scheduled(cron="*/5 * * * * ?")
        @Scheduled(cron="0 */10 * * * ?")
        private void configureTasks()  {
          log.info("-------------开始输出------------");
          log.info("用户名：{}",username);
          log.info("用户密码：{}",userpassword);
        }

}
