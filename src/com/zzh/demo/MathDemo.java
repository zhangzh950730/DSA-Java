package com.zzh.demo;

import java.util.Random;

/**
 * @author ZhangZhiHao
 */
public class MathDemo {

    private static final int count = 500;

    public static void main(String[] args) {
        final Random random = new Random();
        for (int i = 1; i <= count; i++) {
            int i1;
            do {
                // 第一个随机数为20以内的 且不能为0
                i1 = random.nextInt(20);
            } while (i1 <= 1 || i1 >= 19);

            final boolean b = random.nextBoolean();
            int i2;
            do {
                if (b) { //加法
                    // 第二个随机数和第一个求和不能大于20
                    i2 = random.nextInt(20 - i1);

                } else { //减法
                    // 第二个随机数不能大于第一个随机数
                    i2 = random.nextInt(i1);

                }
            } while (i2 == 0);
            if (b) {
                System.out.println(i + ". " + i1 + "+" + i2 + "=");
            } else {
                System.out.println(i + ". " + i1 + "-" + i2 + "=");
            }
        }
    }


}