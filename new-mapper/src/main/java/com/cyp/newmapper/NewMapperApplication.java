package com.cyp.newmapper;

import com.cyp.newmapper.service.impl.DemoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewMapperApplication implements CommandLineRunner {
   @Autowired
   DemoImpl demo;
    public static void main(String[] args) {
        SpringApplication.run(NewMapperApplication.class, args);
    }
    @Override
    public void run(String... args) {
        demo.sayImpl2("20200617004808");
    }
}
