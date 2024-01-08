package com.zzh.leetcode.竞赛.周赛._379;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _3_maximumSetSize {

    public static void main(String[] args) {
        _3_maximumSetSize maximumSetSize = new _3_maximumSetSize();
        int ans = maximumSetSize.maximumSetSize(new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 3, 2, 3, 2, 3});
        Assert.assertEquals(5, ans);
    }

    public int maximumSetSize(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int x : nums1) {
            set1.add(x);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int x : nums2) {
            set2.add(x);
        }
        int common = 0;
        for (int x : set1) {
            if (set2.contains(x)) {
                common++;
            }
        }

        int n1 = set1.size();
        int n2 = set2.size();
        int ans = n1 + n2 - common;

        int m = nums1.length / 2;
        if (n1 > m) {
            int mn = Math.min(n1 - m, common);
            ans -= n1 - mn - m;
            common -= mn;
        }

        if (n2 > m) {
            n2 -= Math.min(n2 - m, common);
            ans -= n2 - m;
        }

        return ans;
    }

}
