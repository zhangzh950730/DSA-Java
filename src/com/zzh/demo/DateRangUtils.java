package com.zzh.demo;

import java.util.Calendar;
import java.util.Date;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class DateRangUtils {
    public static void main(String[] args) {
        Date now = new Date();
        Date startDate = getFirstTimeOfYear(now);
        System.out.println("startDate = " + startDate);
        Date endDate = getLastTimeOfYear(now);
        System.out.println("endDate = " + endDate);
    }

    public static Date getFirstTimeOfYear(Date date) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.set(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        cale.set(Calendar.HOUR_OF_DAY, 0);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND, 0);
        cale.set(Calendar.MILLISECOND, 0);
        return cale.getTime();
    }

    public static Date getLastTimeOfYear(Date date) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(Calendar.YEAR, 1);
        cale.set(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        cale.set(Calendar.HOUR_OF_DAY, 0);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND, 0);
        cale.set(Calendar.MILLISECOND, 0);
        return cale.getTime();
    }
}
