package com.bee.sample.chl.util;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName NameClass.java
 * @Description TODO
 * @createTime 2022年10月20日 15:55:00
 */
public class NameClass {
    private static int x;
    public static void main(String[] args) {
     Integer a =0;
     int b=0;
        System.out.println(a+"<-------------->"+b);
        String str= Integer.toString(12313);
        System.out.println(str.length());
        System.out.println(str);
        StringBuffer as =new StringBuffer(16);
        as.setLength(23424);
        System.out.println(as.append(2323424) );

    }


}
