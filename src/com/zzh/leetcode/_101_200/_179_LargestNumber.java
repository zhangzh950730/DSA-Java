package com.zzh.leetcode._101_200;

import com.zzh.algs4.chapter4.section2.KosarajuSCC;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.junit.Assert;

import java.util.*;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _179_LargestNumber {

    public static void main(String[] args) {
        _179_LargestNumber largestNumber = new _179_LargestNumber();
        int[] nums;
        String ans;

        nums = new int[]{10, 2};
        ans = largestNumber.largestNumber(nums);
        Assert.assertEquals(ans, "210");

        nums = new int[]{3, 30, 34, 5, 9};
        ans = largestNumber.largestNumber(nums);
        Assert.assertEquals(ans, "9534330");


        nums = new int[]{111311, 1113};
        ans = largestNumber.largestNumber(nums);
        Assert.assertEquals(ans, "1113111311");

        nums = new int[]{0, 0};
        ans = largestNumber.largestNumber(nums);
        Assert.assertEquals(ans, "0");
    }

    public String largestNumber(int[] nums) {
        PriorityQueue<String> heap = new PriorityQueue<>((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for (int num : nums) heap.offer(String.valueOf(num));
        StringBuilder ans = new StringBuilder();
        while (!heap.isEmpty()) ans.append(heap.poll());
        if (ans.charAt(0) == '0') return "0";
        return ans.toString();
    }

    public String largestNumber1(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strings[i] = "" + nums[i];
        Arrays.sort(strings, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        StringBuilder ans = new StringBuilder();
        for (String s : strings) ans.append(s);
        if (ans.charAt(0) == '0') return "0";
        return ans.toString();
    }


}
