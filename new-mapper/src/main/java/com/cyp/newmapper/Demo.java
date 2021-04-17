package com.cyp.newmapper;

import com.cyp.newmapper.service.impl.DemoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Demo {
    @Autowired
    DemoImpl demoimpl;
    public void say(String word){
        System.out.println(word);
    }
}
