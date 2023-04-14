package com.zzh.demo;

/**
 * @author ZhangZhiHao
 */
public class BinaryDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            System.out.print("i:" + i + " ");
            System.out.print(i & 1);
            System.out.print(" ");
            System.out.print(i & 2);
            System.out.print(" ");
            System.out.println(i & 4);
        }
    }
}
