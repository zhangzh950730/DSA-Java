package com.zzh.geektime.程序员的数学基础课;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/6/15 22:23
 */
public class Lesson1_2 {

    public static int leftShift(int num, int m) {
        return num << m;
    }

    public static int rightShift(int num, int m) {
        return num >>> m;
    }


    public static void main(String[] args) {

        int num = 53;
        int m = 1;
        System.out.println(String.format("数字%d的二进制向左移%d位是%d", num, m, Lesson1_2.leftShift(num, m)));   //测试向左移位
        System.out.println(String.format("数字%d的二进制向右移%d位是%d", num, m, Lesson1_2.rightShift(num, m)));   //测试向右移位

        System.out.println();

        m = 3;
        System.out.println(String.format("数字%d的二进制向左移%d位是%d", num, m, Lesson1_2.leftShift(num, m)));   //测试向左移位
        System.out.println(String.format("数字%d的二进制向右移%d位是%d", num, m, Lesson1_2.rightShift(num, m)));   //测试向右移位

    }

}
