package com.bee.sample.chl.exercises.setexercist;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName SetDemo.java
 * @Description TODO
 * @createTime 2022年12月21日 13:46:00
 */
public class SetDemo {



    public static void main(String[] args) {


        //不可重复
        HashSet hashset =new HashSet();
        //带排序
        TreeSet treeset =new TreeSet();
        //数组+链表存储数据 线程不安全  java8之后数据机构为数组+链表或者红黑树
        HashMap hashMap =new HashMap();
        //数组+链表存储数据 线程安全
        Map concurrentHashMap =new ConcurrentHashMap<>();
        concurrentHashMap.put("a","1");




        //线程安全
        Hashtable hashtable =new Hashtable();

    }

}
