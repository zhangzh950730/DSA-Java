package com.zzh.demo;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class ByteDemo {
    public static void main(String[] args) {
        byte b;
        for (int i = 0; i < 255; i++) {
            b = (byte) i;
            System.out.println("i = " + i);
            System.out.println("b = " + b);
            System.out.println("==");
        }
    }
}
