package com.cyp.gitnewmodulewhole.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {
    public static void main(String[] args) {
        Map paramsMap=new HashMap();
        paramsMap.put("START_DATE","2020-12-24 00:00:00");
        paramsMap.put("END_DATE","2021-01-10 00:00:00");
        Date startDay = strToDate(paramsMap.get("START_DATE")+"");
        Date endDay = strToDate(paramsMap.get("END_DATE")+"");
        boolean aaaa = regBetweenDay(startDay,endDay);
        System.out.println(aaaa);
    }
    public static boolean regBetweenDay(Date startDay, Date endDay) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date sysDate = new Date();
        String d1= fmt.format(sysDate);
        String d2 =fmt.format(endDay);
        if (sysDate.after(startDay)){
            if (d1.equals(d2)){
                return true;
            }else if (sysDate.before(endDay)){
                return  true;
            }else {
                return false;
            }
        }else {
            return false;
        }

    }


    private static Date strToDate(String dateStr)  {
        SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
        Date  date = null;
        try {
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
