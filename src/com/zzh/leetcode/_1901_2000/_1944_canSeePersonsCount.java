package com.zzh.leetcode._1901_2000;

import com.zzh.util.ArrayUtils;

import java.util.Stack;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1944_canSeePersonsCount {
    public static void main(String[] args) {
        _1944_canSeePersonsCount canSeePersonsCount = new _1944_canSeePersonsCount();
        int[] ans = canSeePersonsCount.canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9});
        ArrayUtils.print(ans);
    }

    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();          // 单调栈
        int[] res = new int[n];                     // 结果数组
        // 逆序遍历，生成单调递减栈
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] > st.peek()) {
                // 每次弹出的元素，都是heights[i]右侧比它小，且两者之间没有大于二者的元素
                res[i]++;
                st.pop();
            }
            if (!st.isEmpty()) res[i]++;    // 栈不为空，栈顶元素为heights[i]右侧首个大于它的元素，这个元素也是可见的
            st.push(heights[i]);        // 当前元素入栈
        }
        return res;
    }

}
