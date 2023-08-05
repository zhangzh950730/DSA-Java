package com.zzh.leetcode._201_300;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _278_firstBadVersion {
    private static boolean[] versionArray;

    public static void main(String[] args) {
        _278_firstBadVersion firstBadVersion = new _278_firstBadVersion();
        int n, bad;

        n = 5;
        versionArray = new boolean[]{false, false, false, false, true, true};
        bad = firstBadVersion.firstBadVersion(n);
        Assert.assertEquals(4, bad);
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int version) {
        return versionArray[version];
    }

}
