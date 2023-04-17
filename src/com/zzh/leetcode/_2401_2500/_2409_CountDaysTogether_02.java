package com.zzh.leetcode._2401_2500;

import org.junit.Assert;

/**
 * 将日期计算为当年的第几天
 *
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2409_CountDaysTogether_02 {

    public static void main(String[] args) {
        _2409_CountDaysTogether_02 countDaysTogether_2409 = new _2409_CountDaysTogether_02();
        int days = countDaysTogether_2409.countDaysTogether("08-15", "08-18", "08-16", "08-19");
        Assert.assertEquals(days, 3);
        days = countDaysTogether_2409.countDaysTogether("10-01", "10-31", "11-01", "12-31");
        Assert.assertEquals(days, 0);
        days = countDaysTogether_2409.countDaysTogether("09-01", "10-19", "06-19", "10-20");
        Assert.assertEquals(days, 49);
        days = countDaysTogether_2409.countDaysTogether("03-05", "07-14", "04-14", "09-21");
        Assert.assertEquals(days, 92);
    }

    private static final int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveDays = calcDays(arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob);
        int leaveDays = calcDays(leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob);
        return Math.max(leaveDays - arriveDays + 1, 0);
    }

    private int calcDays(String monthAndDay) {
        char[] chars = monthAndDay.toCharArray();
        int month = (chars[0] - '0') * 10 + chars[1] - '0';
        int day = (chars[3] - '0') * 10 + chars[4] - '0';
        for (int i = 0; i < month - 1; i++) {
            day += monthDays[i];
        }
        return day;
    }

}
