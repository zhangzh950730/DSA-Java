package com.zzh.leetcode._001_100;

import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Deque;

public class _42_trap {
    public static void main(String[] args) {
        _42_trap trap = new _42_trap();
        int[] height;
        int ans;

        height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        ans = trap.trap(height);
        Assert.assertEquals(6, ans);
    }

    public int trap(int[] height) {
        return trap2(height);
    }

    /**
     * 方法一：前后缀分解
     */
    public int trap1(int[] height) {
        int n = height.length;
        int[] preMax = new int[n]; // 存储i的所有前缀中的最大值
        preMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            preMax[i] = Math.max(height[i], preMax[i - 1]);
        }

        int[] sufMax = new int[n]; // 存储i的所有后缀中的最大值
        sufMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMax[i] = Math.max(height[i], sufMax[i + 1]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 将每个位置可容纳的雨水累计至ans中
            // 前后缀最大值中的小者, 即为当前i可容纳水的面积, 再减去i挡板的面积
            ans += Math.min(preMax[i], sufMax[i]) - height[i];
        }
        return ans;
    }

    /**
     * 方法二：相向双指针
     */
    public int trap2(int[] height) {
        int ans = 0, preMax = 0, sufMax = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            if (preMax < sufMax) {
                ans += preMax - height[left++];
            } else {
                ans += sufMax - height[right--];
            }
        }
        return ans;
    }

    /**
     * 方法三：单调栈
     */
    public int trap3(int[] height) {
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[i] >= height[st.peek()]) {
                int bottomH = height[st.pop()];
                if (st.isEmpty()) {
                    break;
                }
                int left = st.peek();
                int dh = Math.min(height[left], height[i]) - bottomH; // 面积的高
                ans += dh * (i - left - 1);
            }
            st.push(i);
        }
        return ans;
    }

}
