package com.cyp.gitnewmodulewhole.util.util.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtilTest {



    public static String dateFormat(String datetime,int monthNum) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.MONTH, monthNum);
        date = cl.getTime();
        return sdf.format(date);
    }

}
