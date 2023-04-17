package com.zzh.leetcode._2401_2500;

import org.junit.Assert;

/**
 * 弱智方法
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2409_CountDaysTogether_01 {

    public static void main(String[] args) {
        _2409_CountDaysTogether_01 countDaysTogether_2409 = new _2409_CountDaysTogether_01();
        int days = countDaysTogether_2409.countDaysTogether("08-15", "08-18", "08-16", "08-19");
        Assert.assertEquals(days, 3);
        days = countDaysTogether_2409.countDaysTogether("10-01", "10-31", "11-01", "12-31");
        Assert.assertEquals(days, 0);
        days = countDaysTogether_2409.countDaysTogether("09-01", "10-19", "06-19", "10-20");
        Assert.assertEquals(days, 49);
        days = countDaysTogether_2409.countDaysTogether("03-05", "07-14", "04-14", "09-21");
        Assert.assertEquals(days, 92);
    }


    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String i = arriveAlice, j = arriveBob;
        int days = 0;
        while (compare(leaveAlice, i) && compare(leaveBob, j)) {
            if (i.equals(j)) {
                i = increase(monthDays, i);
                j = increase(monthDays, j);
                days++;
            } else {
                boolean iMax = compare(i, j);
                if (iMax) j = increase(monthDays, j);
                else i = increase(monthDays, i);
            }
        }
        return days;
    }

    private boolean compare(String i, String j) {
        String[] iMonthAndDay = i.split("-");
        String iMonthStr = iMonthAndDay[0];
        int iMonth;
        if (iMonthStr.charAt(0) == '0') iMonth = Integer.parseInt(iMonthStr.substring(1));
        else iMonth = Integer.parseInt(iMonthStr);
        String iDayStr = iMonthAndDay[1];
        int iDay = Integer.parseInt(iDayStr);

        String[] jMonthAndDay = j.split("-");
        String jMonthStr = jMonthAndDay[0];
        int jMonth;
        if (jMonthStr.charAt(0) == '0') jMonth = Integer.parseInt(jMonthStr.substring(1));
        else jMonth = Integer.parseInt(jMonthStr);
        String jDayStr = jMonthAndDay[1];
        int jDay = Integer.parseInt(jDayStr);

        if (iMonth < jMonth) return false;
        else if (iMonth > jMonth) return true;
        else return jDay <= iDay;
    }

    private String increase(int[] monthDays, String i) {
        String[] iMonthAndDay = i.split("-");
        String iMonthStr = iMonthAndDay[0];
        int iMonth;
        if (iMonthStr.charAt(0) == '0') iMonth = Integer.parseInt(iMonthStr.substring(1));
        else iMonth = Integer.parseInt(iMonthStr);
        int monthDay = monthDays[iMonth - 1];
        String iDayStr = iMonthAndDay[1];
        int iDay = Integer.parseInt(iDayStr);
        if (iDay == monthDay) {
            if (iMonth + 1 < 10) {
                i = "0" + ++iMonth + "-" + "01";
            } else {
                i = ++iMonth + "-" + "01";
            }
        } else {
            if (iDay + 1 < 10) {
                i = iMonthStr + "-0" + ++iDay;
            } else {
                i = iMonthStr + "-" + ++iDay;
            }
        }
        return i;
    }
}
