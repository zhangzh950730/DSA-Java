package com.zzh.leetcode._001_100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _27_RemoveElement {
    public static void main(String[] args) {
        _27_RemoveElement removeElement = new _27_RemoveElement();
        int[] nums;
        int val, ans;

        nums = new int[]{3, 2, 2, 3};
        val = 3;
        ans = removeElement.removeElement(nums, val);
        Assert.assertEquals(ans, 2);

        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        val = 2;
        ans = removeElement.removeElement(nums, val);
        Assert.assertEquals(ans, 5);

        nums = new int[]{3, 2, 2, 3};
        val = 3;
        ans = removeElement.removeElement(nums, val);
        Assert.assertEquals(ans, 2);

    }

    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) nums[left] = nums[right--];
            else left++;
        }
        return left;
    }

    public int removeElement1(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // 若right位置不是需要删除的元素, 则复制到left位置, left++,right++
            if (nums[right] != val) nums[left++] = nums[right];
            // 否则left不变,right自增
        }
        return left;
    }

}
