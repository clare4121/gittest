package com.cyp.newmapper.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2022年03月09日 17:57:00
 */
public class Test {

    public static void main(String[] args) {
        String  dateSting= "2022-01-31";
        System.out.println(checkDate(dateSting));

    }


     private  static  boolean checkDate(String dateSting){
         boolean convertSuccess=true;
         // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         try {
          // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
             format.setLenient(false);
             format.parse(dateSting);
         } catch (ParseException e) {
             // e.printStackTrace();
             convertSuccess=false;
         }
         return convertSuccess;
    }
}
