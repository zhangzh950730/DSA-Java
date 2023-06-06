package com.zzh.geektime.数据结构与算法之美.array;

import com.zzh.util.ArrayUtils;

import java.util.Arrays;

/**
 * @author zhangzhihao
 * @date 2020/6/22 17:20
 */
public class ArraySortDemo {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{4, 5, 2, 7, 8, 0};
        Arrays.sort(nums);
        ArrayUtils.print(nums);
    }
}
