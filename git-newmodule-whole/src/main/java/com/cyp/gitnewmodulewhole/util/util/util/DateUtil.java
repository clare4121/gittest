package com.cyp.gitnewmodulewhole.util.util.util;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhaoxuan
 * @description 日期工具类
 * @createTime 2020/5/12 12:54 上午
 */
@UtilityClass
public class DateUtil {

    /**
     * 获取当前年月
     * @return
     */
    public String currMonth() {
        LocalDate today = LocalDate.now();
        int thisMonth = today.getMonthValue();
        return today.getYear() + (thisMonth < 10 ? "0" + thisMonth : String.valueOf(thisMonth));
    }

    /**
     * 获取时间戳 - 秒
     * @return
     */
    public long timestampWithSeconds() {
        return Instant.now().getEpochSecond();
    }
    /**
     * 获取时间戳 - 毫秒
     * @return
     */
    public long timestampWithMillSeconds() {
        return Instant.now().toEpochMilli();
    }

    /**
     * 获取当前时间 - 2020-04-28 15:28:30
     * @return
     */
    public String now() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }

    /**
     * 计算月份差值
     * @param startDate
     * @param end
     * @return
     */
    public long monthMinus(Date startDate, LocalDate end) {
        LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.MONTHS.between(start, end);
    }

    /**
     * 判断当前日期是否在[startDate, endDate]区间
     *
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @author jqlin
     * @return
     */
    public static boolean isEffectiveDate(Date startDate, Date endDate){
        if(startDate == null || endDate == null){
            return false;
        }

        long currentTime = new Date().getTime();
        if(currentTime >= startDate.getTime()
                && currentTime <= endDate.getTime()){
            return true;
        }

        return false;
    }

    /**
     * 获取当前时间 - 20200512111120
     * @return
     */
    public String yyyyMMddHHmmss() {
        return DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());
    }

    public void main(String[] args) {

        System.out.println(currMonth());

        System.out.println(timestampWithMillSeconds());



        System.out.println(now());

        System.out.println(yyyyMMddHHmmss());

        System.out.println(timestampWithSeconds());

        System.out.println((System.currentTimeMillis()) / 1000L);

        Calendar c = Calendar.getInstance();

        c.setTime(new Date());
        c.add(Calendar.MONTH, -20);
        Date m = c.getTime();
        System.out.println(m);

        System.out.println(monthMinus(m, LocalDate.now()));

    }

}
