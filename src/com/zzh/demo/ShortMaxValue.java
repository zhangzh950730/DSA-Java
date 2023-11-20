package com.zzh.demo;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class ShortMaxValue {
    public static void main(String[] args) {
        Short number = 0;
        while (true) {
            if (number < 0) number = 0;
            System.out.println("number = " + number++);
        }
    }
}
