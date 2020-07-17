package com.zzh.数据结构_邓俊辉.chapter1_绪论.A_计算;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法有穷性验证
 * 例: 42,7,27
 *
 * 此算法不能确定存在n,使程序无穷运行,所以不是真正的算法
 *
 * @author zhangzhihao
 * @date 2020/7/17 12:24
 */
public class Hailstone {

    private static List<Integer> hailstone(Integer n) {
        final var result = new ArrayList<Integer>();
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            result.add(n);
        }
        return result;
    }

    public static void main(String[] args) {
        var hailstone = hailstone(42);
        System.out.println(hailstone);
        hailstone = hailstone(7);
        System.out.println(hailstone);
        hailstone = hailstone(27);
        System.out.println(hailstone);
        hailstone = hailstone(63434);
        System.out.println(hailstone);
        var n = 1;
        while (true) {
            hailstone = hailstone(n++);
            System.out.println(n + " : " + hailstone.size());
        }
    }
}
