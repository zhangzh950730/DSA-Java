package com.zzh.leetcode.竞赛.双周赛._110;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _3_minimumSeconds {

    public static void main(String[] args) {
        _3_minimumSeconds minimumSeconds = new _3_minimumSeconds();
        List<Integer> nums;
        int ans;

        nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(1);
        nums.add(2);
        ans = minimumSeconds.minimumSeconds(nums);
        Assert.assertEquals(1, ans);

        nums = new ArrayList<>();
        nums.add(2);
        nums.add(1);
        nums.add(3);
        nums.add(3);
        nums.add(2);
        ans = minimumSeconds.minimumSeconds(nums);
        Assert.assertEquals(2, ans);

        nums = new ArrayList<>();
        nums.add(5);
        nums.add(5);
        nums.add(5);
        nums.add(5);
        ans = minimumSeconds.minimumSeconds(nums);
        Assert.assertEquals(0, ans);

    }

    public int minimumSeconds(List<Integer> nums) {
        // 统计每个数字,出现在哪些索引处
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = pos.getOrDefault(nums.get(i), new ArrayList<>());
            list.add(i);
            pos.put(nums.get(i), list);
        }

        int ans = nums.size(), n = nums.size();
        for (List<Integer> list : pos.values()) { //遍历每个数字出现的索引列表
            list.add(list.get(0) + n); //可能为环形数字, 故此处设置i+n表示最长路径需要n次,
            int max = -1;
            for (int i = 1; i < list.size(); i++) { //遍历每个数字的索引列表, 取最大的两索引差, 即为当前数字最长扩散次数
                max = Math.max(max, (list.get(i) - list.get(i - 1)) / 2);
            }
            ans = Math.min(ans, max); //最后结果为所有数字的最大扩散次数中的最小值
        }
        return ans;
    }
}
