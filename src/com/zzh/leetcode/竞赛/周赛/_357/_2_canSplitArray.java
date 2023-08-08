package com.zzh.leetcode.竞赛.周赛._357;

import java.util.List;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2_canSplitArray {

    public boolean canSplitArray(List<Integer> nums, int m) {
        if (nums.size() <= 2) return true;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) + nums.get(i) >= m) return true;
        }
        return false;
    }

}
