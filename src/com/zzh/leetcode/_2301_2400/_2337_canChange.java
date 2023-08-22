package com.zzh.leetcode._2301_2400;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2337_canChange {
    public static void main(String[] args) {
        _2337_canChange canChange = new _2337_canChange();
        String start = "_L__R__R_", target = "L______RR";
        boolean ans = canChange.canChange(start, target);
        Assert.assertTrue(ans);
    }

    public boolean canChange(String start, String target) {
        if (!start.replaceAll("_", "").equals(target.replaceAll("_", ""))) {
            return false;
        }
        for (int i = 0, j = 0; i < start.length(); i++) {
            if (start.charAt(i) == '_') continue;
            while (target.charAt(j) == '_') j++;
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            j++;
        }
        return true;
    }

}
