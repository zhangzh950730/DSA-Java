package com.zzh.leetcode._2401_2500;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2455_AverageValue {
    public static void main(String[] args) {
        _2455_AverageValue averageValue = new _2455_AverageValue();
        int result;

        result = averageValue.averageValue(new int[]{1, 3, 6, 10, 12, 15});
        Assert.assertEquals(result, 9);

        result = averageValue.averageValue(new int[]{1, 2, 4, 7, 10});
        Assert.assertEquals(result, 0);

    }

    public int averageValue(int[] nums) {
        int count = 0, sum = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }

}
