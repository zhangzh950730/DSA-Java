package com.zzh.leetcode._601_700;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _611_triangleNumber {
    public static void main(String[] args) {
        _611_triangleNumber triangleNumber = new _611_triangleNumber();
        int ans = triangleNumber.triangleNumber(new int[]{2, 2, 3, 4});
        Assert.assertEquals(3, ans);
    }

    public int triangleNumber(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int k = 2; k < nums.length; k++) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    ans += j - i;
                    j--;
                } else i++;
            }
        }
        return ans;
    }

}
