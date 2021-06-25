package com.zzh.数据结构_邓俊辉.chapter1_绪论.A_计算;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法有穷性验证,模拟冰雹的下落过程
 * 例: 42,7,27
 * <p>
 * 此算法不能确定存在n,使程序无穷运行,所以不是真正的算法
 *
 * @author zhangzhihao
 */
public class Hailstone {

    public static void main(String[] args) {
        List<Integer> hailstone = hailstone(42);
        System.out.println(hailstone);
        hailstone = hailstone(7);
        System.out.println(hailstone);
        hailstone = hailstone(27);
        System.out.println(hailstone);
        hailstone = hailstone(63434);
        System.out.println(hailstone);
        Integer n = 1;
        while (true) {
            hailstone = hailstone(n++);
            System.out.println(n + " : " + hailstone.size());
        }
    }

    private static List<Integer> hailstone(Integer n) {
        final List<Integer> result = new ArrayList<>();
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
}
