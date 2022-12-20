package com.bee.sample.chl.exercises.JavaInternet;

import com.bee.sample.chl.common.JwtUser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName IteratorDemo.java
 * @Description TODO
 * @createTime 2022年12月19日 17:29:00
 */
public class IteratorDemo {
    public static void main(String[] args) {
        List<JwtUser> lists =new ArrayList<>();
        JwtUser jwtUser =new JwtUser();
        jwtUser.setTenantId("1");
        jwtUser.setUsername("a");
        lists.add(jwtUser);

        Iterator<JwtUser> ssss =lists.iterator();

        while (ssss.hasNext()){
            JwtUser jj=  ssss.next();
            System.out.println(jj.toString());

        }



    }
}
