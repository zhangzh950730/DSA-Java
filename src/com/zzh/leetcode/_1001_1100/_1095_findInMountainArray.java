package com.zzh.leetcode._1001_1100;


import org.junit.Assert;

import java.util.ArrayList;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1095_findInMountainArray {

    static class MountainArray extends ArrayList<Integer> {
        public Integer get(int index) {
            return super.get(index);
        }

        public int length() {
            return size();
        }
    }


    public static void main(String[] args) {
        _1095_findInMountainArray findInMountainArray = new _1095_findInMountainArray();

        MountainArray array = new MountainArray();
        array.add(0);
        array.add(1);
        array.add(2);
        array.add(4);
        array.add(3);
        array.add(2);
        array.add(1);
        int ans = findInMountainArray.findInMountainArray(3, array);
        Assert.assertEquals(4, ans);

    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        // 先使用二分法找到数组的峰值。
        int left = -1, right = mountainArr.length(), mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) left = mid;
            else right = mid;
        }
        int peak = right;

        // 在峰值左边使用二分法寻找目标值。
        int index = binarySearch(mountainArr, target, -1, peak + 1, true);
        if (index != -1) return index;

        // 如果峰值左边没有目标值，那么使用二分法在峰值右边寻找目标值。
        return binarySearch(mountainArr, target, peak, mountainArr.length(), false);
    }

    private int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean flag) {
        target *= (flag ? 1 : -1);
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int cur = mountainArr.get(mid) * (flag ? 1 : -1);
            if (cur == target) return mid;
            else if (cur < target) left = mid;
            else right = mid;
        }
        return -1;
    }
}
