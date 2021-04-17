package com.cyp.gitnewmodulewhole;

import com.cyp.gitnewmodulewhole.demo.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class GitNewmoduleWholeApplication implements CommandLineRunner , Ordered {
    @Autowired
    private Demo demo;

    public static void main(String[] args) {
        SpringApplication.run(GitNewmoduleWholeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        demo.main();
    }

    @Override
    public int getOrder() {
        return 1;
    }
//    实现ApplicationRunner方法
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        demo.main();
//    }
}
