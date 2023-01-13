package com.bee.sample.chl.exercises.listexercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName ListDemo.java
 * @Description TODO
 * @createTime 2022年12月21日 13:38:00
 */
public class ListDemo {
    public static void main(String[] args) {
        //基于数组的线性表 线程不安全 查询快 增删慢 --内存位置 增删时所有节点都要移动
        List arraylist = new ArrayList(  );

        //基于双向链表实现 线程不安全 查询慢 增删快  -- 指针更换指向
        List linklist =new LinkedList();

        //vector 基于数组实现   查询快 增删慢  比arraylist查询效率要高

        Vector vector =new Vector();


        //队列

    }
}
