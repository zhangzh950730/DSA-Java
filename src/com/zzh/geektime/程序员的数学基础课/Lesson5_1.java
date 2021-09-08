package com.zzh.geektime.程序员的数学基础课;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lesson5_1 {

    public static long[] rewards = {1, 2, 5, 10};  // 四种面额的纸币

    /**
     * @param totalReward-奖赏总金额，result-保存当前的解
     * @return void
     * @Description: 使用函数的递归（嵌套）调用，找出所有可能的奖赏组合
     */

    public static void get(long totalReward, ArrayList<Long> result) {

        // 当totalReward = 0时，证明它是满足条件的解，结束嵌套调用，输出解
        if (totalReward == 0) {
            System.out.println(result);
        }
        // 当totalReward < 0时，证明它不是满足条件的解，不输出
        else if (totalReward >= 0) {
            for (long reward : rewards) {
                ArrayList<Long> newResult = (ArrayList<Long>) (result.clone());  // 由于有4种情况，需要clone当前的解并传入被调用的函数
                newResult.add(reward);            // 记录当前的选择，解决一点问题
                get(totalReward - reward, newResult);    // 剩下的问题，留给嵌套调用去解决
            }
        }

    }

    public static void main(String[] args) {
        int totalReward = 10;
        get(totalReward, new ArrayList<>());
    }

}