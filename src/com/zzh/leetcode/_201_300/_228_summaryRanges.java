package com.zzh.leetcode._201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _228_summaryRanges {

    public static void main(String[] args) {
        _228_summaryRanges summaryRanges = new _228_summaryRanges();
        int[] nums;
        List<String> ans;

        nums = new int[]{0, 1, 2, 4, 5, 7};
        ans = summaryRanges.summaryRanges(nums);
        System.out.println("ans = " + ans);
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int low = i++;
            while (i < nums.length && nums[i] == nums[i - 1] + 1) i++;
            int high = i - 1;
            StringBuilder sb = new StringBuilder(String.valueOf(nums[low]));
            if (low < high) sb.append("->").append(nums[high]);
            ans.add(sb.toString());
        }
        return ans;
    }
}
