package com.zzh.geektime.程序员的数学基础课;

import static com.zzh.geektime.程序员的数学基础课.Lesson1_1.decimalToBinary;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/6/15 22:25
 */
public class Lesson1_3 {

    /**
     * @return 二进制按位“或”的结果
     */
    public static int or(int num1, int num2) {

        return (num1 | num2);

    }

    /**
     * @return 二进制按位“与”的结果
     */
    public static int and(int num1, int num2) {

        return (num1 & num2);

    }

    /**
     * @return 二进制按位“异或”的结果
     */

    public static int xor(int num1, int num2) {

        return (num1 ^ num2);

    }


    public static void main(String[] args) {

        int a = 53;
        int b = 35;

        System.out.println(String.format("数字%d(%s)和数字%d(%s)的按位‘或’结果是%d(%s)",
                a, decimalToBinary(a), b, decimalToBinary(b), or(a, b), decimalToBinary(Lesson1_3.or(a, b)))); //获取十进制数53和35的按位“或”

        System.out.println(String.format("数字%d(%s)和数字%d(%s)的按位‘与’结果是%d(%s)",
                a, decimalToBinary(a), b, decimalToBinary(b), and(a, b), decimalToBinary(Lesson1_3.and(a, b))));  //获取十进制数53和35的按位“与”

        System.out.println(String.format("数字%d(%s)和数字%d(%s)的按位‘异或’结果是%d(%s)",
                a, decimalToBinary(a), a, decimalToBinary(a), xor(a, a), decimalToBinary(Lesson1_3.xor(a, a))));  //获取十进制数53和35的按位“异或”

    }


}