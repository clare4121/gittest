package com.cyp.springstudy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName PattenTest.java
 * @Description TODO
 * @createTime 2022年07月04日 11:13:00
 */
public class PattenTest {
    public static void main(String[] args) {
//        String patten ="^[1-9]+[0-9]*$";
//        String patten ="^[a-zA-Z0-9]\\w{5,17}$";
        String patten ="^^\\w+$";
        Pattern p=Pattern.compile(patten);
        Matcher m =p.matcher("EEJYZX035");
        boolean result = m.find();
        System.out.println(result);
    }
}
