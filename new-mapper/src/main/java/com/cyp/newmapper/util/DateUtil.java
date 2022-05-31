package com.cyp.newmapper.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/** 
 * @author 作者: jxw 
 * @date 创建时间: 2017年1月31日 下午6:08:52 
 * @version 版本: 1.0 
*/
public class DateUtil {
	
	private static SimpleDateFormat spDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat spDate = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat spTime = new SimpleDateFormat("HH:mm:ss");
	private static SimpleDateFormat sp = new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat sp2 = new SimpleDateFormat("yyyyMMddHHmmss");
	private static  SimpleDateFormat sp3= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	private static  SimpleDateFormat sp4= new SimpleDateFormat("yyyyMMddHHmmssSSS");
	public static String simDateTime3String3(){
		return sp3.format(new Date());
	}
	public static String simDateTime2String2(){		
		return sp2.format(new Date());
	}
	public static String simDateTime2String(Date date){		
		return sp.format(date);
	}
	public static String dateTime2String(Date date){
		return spDateTime.format(date);
	}
	public static String dateTime3String(Date date){return sp3.format(date);}
	public static String dateTime4String(Date date){return sp4.format(date);}
	public static String date2String(Date date){
		return spDate.format(date);
	}
	
	public static String time2String(Date date){
		return spTime.format(date);
	}
	
	public static String time2String(String format,Date date){
		SimpleDateFormat mySp = new SimpleDateFormat(format);
		return mySp.format(date);
	}
	
	public static Date string2Time(String format,String str){
		SimpleDateFormat mySp = new SimpleDateFormat(format);
		if("".equals(str)||str==null||"".equals(format)||format==null){
			return null;
		}
		try {
			return mySp.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date string2DateTime(String str){
		if("".equals(str)||str==null){
			return null;
		}
		try {
			return spDateTime.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date string2Date(String str){
		if("".equals(str)||str==null){
			return null;
		}
		try {
			return spDate.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date string2Time(String str){
		if("".equals(str)||str==null){
			return null;
		}
		try {
			return spTime.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Time stringToTime(String str){
		return Time.valueOf(str);
	}
	
	public static int getYear(){
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public static int getMonth(){
		return Calendar.getInstance().get(Calendar.MONTH)+1;
	}
	
	public static int getDay(){
		return Calendar.getInstance().get(Calendar.DATE);
	}
	
//	public static int getYear(Date date) {
//		if (date == null)
//			return 0;
//		Calendar now = Calendar.getInstance();
//		now.setTime(date);
//		int year = now.get(Calendar.YEAR);
//		return year;
//	}

	/**
	 * 获取该日期的月份
	 * @param date 日期
	 * @return 对应的月份
	 */
//	public static int getMonth(Date date) {
//		if (date == null)
//			return 0;
//		Calendar now = Calendar.getInstance();
//		now.setTime(date);
//		int month = now.get(Calendar.MONTH);
//		return month;
//	}

	/**
	 * 获取该日期在当前月的最大天数
	 * @param date 日期
	 * @return 天数
	 */
	public static int getDaysOfMonth(Date date) {
		if (date == null)
			return 0;
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		int days = now.getActualMaximum(Calendar.DAY_OF_MONTH);
		return days;
	}

	/**
	 * 获取当前日期
	 * @return 格式：yyyy年MM月dd日
	 */
	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	/**
	 * 
	 * @Description: 获取当前日期
	 * @param format
	 * @return
	 */
	public static String getStringDateShort(String format) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	
	/**
	 * 获得未来指定月后的时间
	 * @param amount
	 * @return
	 */
	public static Date getAfterYear(int amount,Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, amount);
		return calendar.getTime();
	}
	
	/**
	 * 获得未来指定月后的时间
	 * @param amount
	 * @return
	 */
	public static Date getAfterMonth(int amount,Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, amount);
		return calendar.getTime();
	}
	
	/**
	 * 获得未来指定天后的时间
	 * @param amount
	 * @return 
	 */
	public static Date getAfterDay(int amount,Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, amount);
		return calendar.getTime();
	}
	
	/**
	 * 获得未来指定小时后的时间
	 * @param amount
	 * @return
	 */
	public static Date getAfterHour(int amount,Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, amount);
		return calendar.getTime();
	}
	
	/**
	 * 获得未来指定分钟后的时间
	 * @param amount
	 * @return
	 */
	public static Date getAfterMinute(int amount,Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, amount);
		return calendar.getTime();
	}
	
	/**
	 * 自定义简单字符串转时间
	 * @param str
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String str,String format) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.parse(str);
	}
	
	/**
	 * 自定义简单时间转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String format(Date date,String format){
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}
	
	/**
	 * Date时间转Timestamp时间
	 * @param date
	 * @return
	 */
	public static Timestamp dateToTimestamp(Date date){
		return new Timestamp(date.getTime());
	}
	
	/**
	 * 字符串转Timestamp时间

	 * @return
	 */
	public static Timestamp string2Timestamp(String str){
		Date date = string2DateTime(str);
		return new Timestamp(date.getTime());
	}
	
	/**
	 * Timestamp时间转字符串

	 * @return
	 */
	public static String timestamp2String(Timestamp timestamp){
		Date date = new Date(timestamp.getTime());
		return dateTime2String(date);
	}

	/**
	 * 获得指定日期的前N天
	 * 
	 * @param specifiedDay
	 *            指定日期
	 * @return 指定日期前N天的那一天
	 */
	public static String getSpecifiedDayBefore(String specifiedDay, int n) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - n);

		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayBefore;
	}

	/**
	 * 获得指定日期的后N天
	 * 
	 * @param specifiedDay
	 *            指定日期
	 * @return 指定日期后N天的那一天
	 */
	public static String getSpecifiedDayAfter(String specifiedDay, int n) {
		if (specifiedDay == null || "".equals(specifiedDay)) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + n);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayAfter;
	}

	/** 
     * 获取SimpleDateFormat 
     * @param parttern 日期格式 
     * @return SimpleDateFormat对象 
     * @throws RuntimeException 异常：非法日期格式 
     */  
    private static SimpleDateFormat getDateFormat(String parttern) throws RuntimeException {  
        return new SimpleDateFormat(parttern);  
    }  
  
    /** 
     * 获取日期中的某数值。如获取月份 
     * @param date 日期 
     * @param dateType 日期格式 
     * @return 数值 
     */  
    private static int getInteger(Date date, int dateType) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        return calendar.get(dateType);  
    }  
      
    /** 
     * 增加日期中某类型的某数值。如增加日期 
     * @param date 日期字符串 
     * @param dateType 类型 
     * @param amount 数值 
     * @return 计算后日期字符串 
     */  
    private static String addInteger(String date, int dateType, int amount) {  
        String dateString = null;  
        DateStyle dateStyle = getDateStyle(date);  
        if (dateStyle != null) {  
            Date myDate = StringToDate(date, dateStyle);  
            myDate = addInteger(myDate, dateType, amount);  
            dateString = DateToString(myDate, dateStyle);  
        }  
        return dateString;  
    }  
      
    /** 
     * 增加日期中某类型的某数值。如增加日期 
     * @param date 日期 
     * @param dateType 类型 
     * @param amount 数值 
     * @return 计算后日期 
     */  
    private static Date addInteger(Date date, int dateType, int amount) {  
        Date myDate = null;  
        if (date != null) {  
            Calendar calendar = Calendar.getInstance();  
            calendar.setTime(date);  
            calendar.add(dateType, amount);  
            myDate = calendar.getTime();  
        }  
        return myDate;  
    }  
  
    /** 
     * 获取精确的日期 
     * @param timestamps 时间long集合 
     * @return 日期 
     */  
    private static Date getAccurateDate(List<Long> timestamps) {  
        Date date = null;  
        long timestamp = 0;  
        Map<Long, long[]> map = new HashMap<Long, long[]>();  
        List<Long> absoluteValues = new ArrayList<Long>();  
  
        if (timestamps != null && timestamps.size() > 0) {  
            if (timestamps.size() > 1) {  
                for (int i = 0; i < timestamps.size(); i++) {  
                    for (int j = i + 1; j < timestamps.size(); j++) {  
                        long absoluteValue = Math.abs(timestamps.get(i) - timestamps.get(j));  
                        absoluteValues.add(absoluteValue);  
                        long[] timestampTmp = { timestamps.get(i), timestamps.get(j) };  
                        map.put(absoluteValue, timestampTmp);  
                    }  
                }  
  
                // 有可能有相等的情况。如2012-11和2012-11-01。时间戳是相等的  
                long minAbsoluteValue = -1;  
                if (!absoluteValues.isEmpty()) {  
                    // 如果timestamps的size为2，这是差值只有一个，因此要给默认值  
                    minAbsoluteValue = absoluteValues.get(0);  
                }  
                for (int i = 0; i < absoluteValues.size(); i++) {  
                    for (int j = i + 1; j < absoluteValues.size(); j++) {  
                        if (absoluteValues.get(i) > absoluteValues.get(j)) {  
                            minAbsoluteValue = absoluteValues.get(j);  
                        } else {  
                            minAbsoluteValue = absoluteValues.get(i);  
                        }  
                    }  
                }  
  
                if (minAbsoluteValue != -1) {  
                    long[] timestampsLastTmp = map.get(minAbsoluteValue);  
                    if (absoluteValues.size() > 1) {  
                        timestamp = Math.max(timestampsLastTmp[0], timestampsLastTmp[1]);  
                    } else if (absoluteValues.size() == 1) {  
                        // 当timestamps的size为2，需要与当前时间作为参照  
                        long dateOne = timestampsLastTmp[0];  
                        long dateTwo = timestampsLastTmp[1];  
                        if ((Math.abs(dateOne - dateTwo)) < 100000000000L) {  
                            timestamp = Math.max(timestampsLastTmp[0], timestampsLastTmp[1]);  
                        } else {  
                            long now = new Date().getTime();  
                            if (Math.abs(dateOne - now) <= Math.abs(dateTwo - now)) {  
                                timestamp = dateOne;  
                            } else {  
                                timestamp = dateTwo;  
                            }  
                        }  
                    }  
                }  
            } else {  
                timestamp = timestamps.get(0);  
            }  
        }  
  
        if (timestamp != 0) {  
            date = new Date(timestamp);  
        }  
        return date;  
    }  
  
    /** 
     * 判断字符串是否为日期字符串 
     * @param date 日期字符串 
     * @return true or false 
     */  
    public static boolean isDate(String date) {  
        boolean isDate = false;  
        if (date != null) {  
            if (StringToDate(date) != null) {  
                isDate = true;  
            }  
        }  
        return isDate;  
    }  
  
    /** 
     * 获取日期字符串的日期风格。失敗返回null。 
     * @param date 日期字符串 
     * @return 日期风格 
     */  
    public static DateStyle getDateStyle(String date) {  
        DateStyle dateStyle = null;  
        Map<Long, DateStyle> map = new HashMap<Long, DateStyle>();  
        List<Long> timestamps = new ArrayList<Long>();  
        for (DateStyle style : DateStyle.values()) {  
            Date dateTmp = StringToDate(date, style.getValue());  
            if (dateTmp != null) {  
                timestamps.add(dateTmp.getTime());  
                map.put(dateTmp.getTime(), style);  
            }  
        }  
        dateStyle = map.get(getAccurateDate(timestamps).getTime());  
        return dateStyle;  
    }  
  
    /** 
     * 将日期字符串转化为日期。失败返回null。 
     * @param date 日期字符串 
     * @return 日期 
     */  
    public static Date StringToDate(String date) {  
        DateStyle dateStyle = null;  
        return StringToDate(date, dateStyle);  
    }  
  
    /** 
     * 将日期字符串转化为日期。失败返回null。 
     * @param date 日期字符串 
     * @param parttern 日期格式 
     * @return 日期 
     */  
    public static Date StringToDate(String date, String parttern) {  
        Date myDate = null;  
        if (date != null) {  
            try {  
                myDate = getDateFormat(parttern).parse(date);  
            } catch (Exception e) {  
            }  
        }  
        return myDate;  
    }  
  
    /** 
     * 将日期字符串转化为日期。失败返回null。 
     * @param date 日期字符串 
     * @param dateStyle 日期风格 
     * @return 日期 
     */  
    public static Date StringToDate(String date, DateStyle dateStyle) {  
        Date myDate = null;  
        if (dateStyle == null) {  
            List<Long> timestamps = new ArrayList<Long>();  
            for (DateStyle style : DateStyle.values()) {  
                Date dateTmp = StringToDate(date, style.getValue());  
                if (dateTmp != null) {  
                    timestamps.add(dateTmp.getTime());  
                }  
            }  
            myDate = getAccurateDate(timestamps);  
        } else {  
            myDate = StringToDate(date, dateStyle.getValue());  
        }  
        return myDate;  
    }  
  
    /** 
     * 将日期转化为日期字符串。失败返回null。 
     * @param date 日期 
     * @param parttern 日期格式 
     * @return 日期字符串 
     */  
    public static String DateToString(Date date, String parttern) {  
        String dateString = null;  
        if (date != null) {  
            try {  
                dateString = getDateFormat(parttern).format(date);  
            } catch (Exception e) {  
            }  
        }  
        return dateString;  
    }  
  
    /** 
     * 将日期转化为日期字符串。失败返回null。 
     * @param date 日期 
     * @param dateStyle 日期风格 
     * @return 日期字符串 
     */  
    public static String DateToString(Date date, DateStyle dateStyle) {  
        String dateString = null;  
        if (dateStyle != null) {  
            dateString = DateToString(date, dateStyle.getValue());  
        }  
        return dateString;  
    }  
  
    /** 
     * 将日期字符串转化为另一日期字符串。失败返回null。 
     * @param date 旧日期字符串 
     * @param parttern 新日期格式 
     * @return 新日期字符串 
     */  
    public static String StringToString(String date, String parttern) {  
        return StringToString(date, null, parttern);  
    }  
  
    /** 
     * 将日期字符串转化为另一日期字符串。失败返回null。 
     * @param date 旧日期字符串 
     * @param dateStyle 新日期风格 
     * @return 新日期字符串 
     */  
    public static String StringToString(String date, DateStyle dateStyle) {  
        return StringToString(date, null, dateStyle);  
    }  
  
    /** 
     * 将日期字符串转化为另一日期字符串。失败返回null。 
     * @param date 旧日期字符串 
     * @param olddParttern 旧日期格式 
     * @param newParttern 新日期格式 
     * @return 新日期字符串 
     */  
    public static String StringToString(String date, String olddParttern, String newParttern) {  
        String dateString = null;  
        if (olddParttern == null) {  
            DateStyle style = getDateStyle(date);  
            if (style != null) {  
                Date myDate = StringToDate(date, style.getValue());  
                dateString = DateToString(myDate, newParttern);  
            }  
        } else {  
            Date myDate = StringToDate(date, olddParttern);  
            dateString = DateToString(myDate, newParttern);  
        }  
        return dateString;  
    }  
  
    /** 
     * 将日期字符串转化为另一日期字符串。失败返回null。 
     * @param date 旧日期字符串 
     * @param olddDteStyle 旧日期风格 
     * @param newDateStyle 新日期风格 
     * @return 新日期字符串 
     */  
    public static String StringToString(String date, DateStyle olddDteStyle, DateStyle newDateStyle) {  
        String dateString = null;  
        if (olddDteStyle == null) {  
            DateStyle style = getDateStyle(date);  
            dateString = StringToString(date, style.getValue(), newDateStyle.getValue());  
        } else {  
            dateString = StringToString(date, olddDteStyle.getValue(), newDateStyle.getValue());  
        }  
        return dateString;  
    }  
  
    /** 
     * 增加日期的年份。失败返回null。 
     * @param date 日期 
     * @param yearAmount 增加数量。可为负数 
     * @return 增加年份后的日期字符串 
     */  
    public static String addYear(String date, int yearAmount) {  
        return addInteger(date, Calendar.YEAR, yearAmount);  
    }  
      
    /** 
     * 增加日期的年份。失败返回null。 
     * @param date 日期 
     * @param yearAmount 增加数量。可为负数 
     * @return 增加年份后的日期 
     */  
    public static Date addYear(Date date, int yearAmount) {  
        return addInteger(date, Calendar.YEAR, yearAmount);  
    }  
      
    /** 
     * 增加日期的月份。失败返回null。 
     * @param date 日期 
     * @param yearAmount 增加数量。可为负数 
     * @return 增加月份后的日期字符串 
     */  
    public static String addMonth(String date, int yearAmount) {  
        return addInteger(date, Calendar.MONTH, yearAmount);  
    }  
      
    /** 
     * 增加日期的月份。失败返回null。 
     * @param date 日期 
     * @param yearAmount 增加数量。可为负数 
     * @return 增加月份后的日期 
     */  
    public static Date addMonth(Date date, int yearAmount) {  
        return addInteger(date, Calendar.MONTH, yearAmount);  
    }  
      
    /** 
     * 增加日期的天数。失败返回null。 
     * @param date 日期字符串 
     * @param dayAmount 增加数量。可为负数 
     * @return 增加天数后的日期字符串 
     */  
    public static String addDay(String date, int dayAmount) {  
        return addInteger(date, Calendar.DATE, dayAmount);  
    }  
  
    /** 
     * 增加日期的天数。失败返回null。 
     * @param date 日期 
     * @param dayAmount 增加数量。可为负数 
     * @return 增加天数后的日期 
     */  
    public static Date addDay(Date date, int dayAmount) {  
        return addInteger(date, Calendar.DATE, dayAmount);  
    }  
      
    /** 
     * 增加日期的小时。失败返回null。 
     * @param date 日期字符串 

     * @return 增加小时后的日期字符串 
     */  
    public static String addHour(String date, int hourAmount) {  
        return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);  
    }  
  
    /** 

     */  
    public static Date addHour(Date date, int hourAmount) {  
        return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);  
    }  
      
    /** 

     */  
    public static String addMinute(String date, int hourAmount) {  
        return addInteger(date, Calendar.MINUTE, hourAmount);  
    }  
  
    /** 
     * 增加日期的分钟。失败返回null。 
     * @param date 日期 

     * @return 增加分钟后的日期 
     */  
    public static Date addMinute(Date date, int hourAmount) {  
        return addInteger(date, Calendar.MINUTE, hourAmount);  
    }  
      
    /** 
     * 增加日期的秒钟。失败返回null。 
     * @param date 日期字符串 

     * @return 增加秒钟后的日期字符串 
     */  
    public static String addSecond(String date, int hourAmount) {  
        return addInteger(date, Calendar.SECOND, hourAmount);  
    }  
  
    /** 
     * 增加日期的秒钟。失败返回null。 
     * @param date 日期 

     * @return 增加秒钟后的日期 
     */  
    public static Date addSecond(Date date, int hourAmount) {  
        return addInteger(date, Calendar.SECOND, hourAmount);  
    }  
  
    /** 
     * 获取日期的年份。失败返回0。 
     * @param date 日期字符串 
     * @return 年份 
     */  
    public static int getYear(String date) {  
        return getYear(StringToDate(date));  
    }  
  
    /** 
     * 获取日期的年份。失败返回0。 
     * @param date 日期 
     * @return 年份 
     */  
    public static int getYear(Date date) {  
        return getInteger(date, Calendar.YEAR);  
    }  
  
    /** 
     * 获取日期的月份。失败返回0。 
     * @param date 日期字符串 
     * @return 月份 
     */  
    public static int getMonth(String date) {  
        return getMonth(StringToDate(date));  
    }  
  
    /** 
     * 获取日期的月份。失败返回0。 
     * @param date 日期 
     * @return 月份 
     */  
    public static int getMonth(Date date) {  
        return getInteger(date, Calendar.MONTH);  
    }  
  
    /** 
     * 获取日期的天数。失败返回0。 
     * @param date 日期字符串 
     * @return 天 
     */  
    public static int getDay(String date) {  
        return getDay(StringToDate(date));  
    }  
  
    /** 
     * 获取日期的天数。失败返回0。 
     * @param date 日期 
     * @return 天 
     */  
    public static int getDay(Date date) {  
        return getInteger(date, Calendar.DATE);  
    }  
      
    /** 
     * 获取日期的小时。失败返回0。 
     * @param date 日期字符串 
     * @return 小时 
     */  
    public static int getHour(String date) {  
        return getHour(StringToDate(date));  
    }  
  
    /** 
     * 获取日期的小时。失败返回0。 
     * @param date 日期 
     * @return 小时 
     */  
    public static int getHour(Date date) {  
        return getInteger(date, Calendar.HOUR_OF_DAY);  
    }  
      
    /** 
     * 获取日期的分钟。失败返回0。 
     * @param date 日期字符串 
     * @return 分钟 
     */  
    public static int getMinute(String date) {  
        return getMinute(StringToDate(date));  
    }  
  
    /** 
     * 获取日期的分钟。失败返回0。 
     * @param date 日期 
     * @return 分钟 
     */  
    public static int getMinute(Date date) {  
        return getInteger(date, Calendar.MINUTE);  
    }  
      
    /** 
     * 获取日期的秒钟。失败返回0。 
     * @param date 日期字符串 
     * @return 秒钟 
     */  
    public static int getSecond(String date) {  
        return getSecond(StringToDate(date));  
    }  
  
    /** 
     * 获取日期的秒钟。失败返回0。 
     * @param date 日期 
     * @return 秒钟 
     */  
    public static int getSecond(Date date) {  
        return getInteger(date, Calendar.SECOND);  
    }  
  
    /** 
     * 获取日期 。默认yyyy-MM-dd格式。失败返回null。 
     * @param date 日期字符串 
     * @return 日期 
     */  
    public static String getDate(String date) {  
        return StringToString(date, DateStyle.YYYY_MM_DD);  
    }  
  
    /** 
     * 获取日期。默认yyyy-MM-dd格式。失败返回null。 
     * @param date 日期 
     * @return 日期 
     */  
    public static String getDate(Date date) {  
        return DateToString(date, DateStyle.YYYY_MM_DD);  
    }  
  
    /** 
     * 获取日期的时间。默认HH:mm:ss格式。失败返回null。 
     * @param date 日期字符串 
     * @return 时间 
     */  
    public static String getTime(String date) {  
        return StringToString(date, DateStyle.HH_MM_SS);  
    }  
  
    /** 
     * 获取日期的时间。默认HH:mm:ss格式。失败返回null。 
     * @param date 日期 
     * @return 时间 
     */  
    public static String getTime(Date date) {  
        return DateToString(date, DateStyle.HH_MM_SS);  
    }  
  
    /** 
     * 获取日期的星期。失败返回null。 
     * @param date 日期字符串 
     * @return 星期 
     */  
    public static Week getWeek(String date) {  
        Week week = null;  
        DateStyle dateStyle = getDateStyle(date);  
        if (dateStyle != null) {  
            Date myDate = StringToDate(date, dateStyle);  
            week = getWeek(myDate);  
        }  
        return week;  
    }  
  
    /** 
     * 获取日期的星期。失败返回null。 
     * @param date 日期 
     * @return 星期 
     */  
    public static Week getWeek(Date date) {  
        Week week = null;  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;  
        switch (weekNumber) {  
        case 0:  
            week = Week.SUNDAY;  
            break;  
        case 1:  
            week = Week.MONDAY;  
            break;  
        case 2:  
            week = Week.TUESDAY;  
            break;  
        case 3:  
            week = Week.WEDNESDAY;  
            break;  
        case 4:  
            week = Week.THURSDAY;  
            break;  
        case 5:  
            week = Week.FRIDAY;  
            break;  
        case 6:  
            week = Week.SATURDAY;  
            break;  
        }  
        return week;  
    }  
      
    /** 
     * 获取两个日期相差的天数 
     * @param date 日期字符串 
     * @param otherDate 另一个日期字符串 
     * @return 相差天数 
     */  
    public static int getIntervalDays(String date, String otherDate) {  
        return getIntervalDays(StringToDate(date), StringToDate(otherDate));  
    }  
      
    /** 
     * @param date 日期 
     * @param otherDate 另一个日期 
     * @return 相差天数 
     */  
    public static int getIntervalDays(Date date, Date otherDate) {  
        date = DateUtil.StringToDate(DateUtil.getDate(date));  
        long time = Math.abs(date.getTime() - otherDate.getTime());  
        return (int)time/(24 * 60 * 60 * 1000);  
    }  
    
    
    
    
    public static enum DateStyle {  
        
        MM_DD("MM-dd"),  
        YYYY_MM("yyyy-MM"),  
        YYYY_MM_DD("yyyy-MM-dd"),  
        MM_DD_HH_MM("MM-dd HH:mm"),  
        MM_DD_HH_MM_SS("MM-dd HH:mm:ss"),  
        YYYY_MM_DD_HH_MM("yyyy-MM-dd HH:mm"),  
        YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss"),  
          
        MM_DD_EN("MM/dd"),  
        YYYY_MM_EN("yyyy/MM"),  
        YYYY_MM_DD_EN("yyyy/MM/dd"),  
        MM_DD_HH_MM_EN("MM/dd HH:mm"),  
        MM_DD_HH_MM_SS_EN("MM/dd HH:mm:ss"),  
        YYYY_MM_DD_HH_MM_EN("yyyy/MM/dd HH:mm"),  
        YYYY_MM_DD_HH_MM_SS_EN("yyyy/MM/dd HH:mm:ss"),  
          
        MM_DD_CN("MM月dd日"),  
        YYYY_MM_CN("yyyy年MM月"),  
        YYYY_MM_DD_CN("yyyy年MM月dd日"),  
        MM_DD_HH_MM_CN("MM月dd日 HH:mm"),  
        MM_DD_HH_MM_SS_CN("MM月dd日 HH:mm:ss"),  
        YYYY_MM_DD_HH_MM_CN("yyyy年MM月dd日 HH:mm"),  
        YYYY_MM_DD_HH_MM_SS_CN("yyyy年MM月dd日 HH:mm:ss"),  
          
        HH_MM("HH:mm"),  
        HH_MM_SS("HH:mm:ss");  
          
          
        private String value;  
          
        DateStyle(String value) {  
            this.value = value;  
        }  
          
        public String getValue() {  
            return value;  
        }  
    } 
    
    
    public static enum Week {  
    	  
        MONDAY("星期一", "Monday", "Mon.", 1),  
        TUESDAY("星期二", "Tuesday", "Tues.", 2),  
        WEDNESDAY("星期三", "Wednesday", "Wed.", 3),  
        THURSDAY("星期四", "Thursday", "Thur.", 4),  
        FRIDAY("星期五", "Friday", "Fri.", 5),  
        SATURDAY("星期六", "Saturday", "Sat.", 6),  
        SUNDAY("星期日", "Sunday", "Sun.", 7);  
          
        String name_cn;  
        String name_en;  
        String name_enShort;  
        int number;  
          
        Week(String name_cn, String name_en, String name_enShort, int number) {  
            this.name_cn = name_cn;  
            this.name_en = name_en;  
            this.name_enShort = name_enShort;  
            this.number = number;  
        }  
          
        public String getChineseName() {  
            return name_cn;  
        }  
      
        public String getName() {  
            return name_en;  
        }  
      
        public String getShortName() {  
            return name_enShort;  
        }  
      
        public int getNumber() {  
            return number;  
        }  
    }


}
