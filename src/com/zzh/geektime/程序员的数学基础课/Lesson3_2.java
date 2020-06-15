package com.zzh.geektime.程序员的数学基础课;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/6/15 22:29
 */
public class Lesson3_2 {

    /**
     * 计算大于1的正整数的平方根
     *
     * @param n 待求的数
     * @param deltaThreshold 误差的阈值
     * @param maxTry 二分查找的最大次数
     *
     * @return 平方根的解
     */
    public static double getSqureRoot(int n, double deltaThreshold, int maxTry) {
        if (n <= 1) {
            return -1.0;
        }

        double min = 1.0, max = n;
        for (int i = 0; i < maxTry; i++) {
            double middle = (min + max) / 2;
            double square = middle * middle;
            double delta = Math.abs(square / n - 1);
            if (delta < deltaThreshold) {
                return middle;
            } else if (square > n) {
                max = middle;
            } else {
                min = middle;
            }
        }
        return -2.0;
    }


    public static void main(String[] args) {

        int number = 10;
        double squareRoot = getSqureRoot(number, 0.000001, 10000);
        if (squareRoot == -1.0) {
            System.out.println("请输入大于1的整数");
        } else if (squareRoot == -2.0) {
            System.out.println("未能找到解");
        } else {
            System.out.println(String.format("%d的平方根是%f", number, squareRoot));
        }
    }
}
