package com.bee.sample.chl.exercises.JavaInternet;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName MapDemo.java
 * @Description TODO
 * @createTime 2022年12月16日 15:27:00
 */
public class MapDemo {

    public static void main(String[] args) throws IOException {


        Map<String,String > mp=new HashMap<>();
        mp.put("1","2");
        mp.put("3","4");

        Iterator<Map.Entry<String,String>> it=mp.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,String> s=it.next();
            System.out.println("key---"+s.getKey()+",value---"+s.getValue());

        }



        Selector selector =Selector.open();

        Iterator<SelectionKey> its =selector.selectedKeys().iterator();
    }


}
