package com.zzh.leetcode._2701_2800;

import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2799_countCompleteSubarrays {

    public static void main(String[] args) {
        _2799_countCompleteSubarrays countCompleteSubarrays = new _2799_countCompleteSubarrays();
        int[] nums;
        int ans;

        nums = new int[]{1, 3, 1, 2, 2};
        ans = countCompleteSubarrays.countCompleteSubarrays(nums);
        Assert.assertEquals(4, ans);

//        nums = new int[]{5, 5, 5, 5};
//        ans = countCompleteSubarrays.countCompleteSubarrays(nums);
//        Assert.assertEquals(10, ans);
    }

    public int countCompleteSubarrays(int[] nums) {
        var set = new HashSet<>();
        for (int num : nums) set.add(num);
        int n = set.size();
        int ans = 0, leftIndex = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int rightValue : nums) {
            counter.merge(rightValue, 1, Integer::sum);
            while (counter.size() == n) {
                int leftValue = nums[leftIndex++];
                if (counter.merge(leftValue, -1, Integer::sum) == 0) {
                    counter.remove(leftValue);
                }
            }
            ans += leftIndex;
        }
        return ans;
    }

}
