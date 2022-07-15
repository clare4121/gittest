package com.cyp.springstudy.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName StringToList.java
 * @Description TODO
 * @createTime 2022年07月01日 14:06:00
 */
public class StringToList {


    public static void main(String[] args) {
        String testSt ="a,eee,tttt,a,eee,tttt,rrr";
        List<String> list = Arrays.asList(testSt.split(","));
        List<String> listWithoutDuplicate =list.stream().distinct().collect(Collectors.toList());
        for (int i = 0; i <listWithoutDuplicate.size() ; i++) {
            System.out.println(listWithoutDuplicate.get(i));
    }
        String newStr =String.join(",",listWithoutDuplicate);
        System.out.println("newStr------------"+newStr);
    }
}
