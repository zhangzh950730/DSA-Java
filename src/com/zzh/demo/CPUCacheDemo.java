package com.zzh.demo;

/**
 * @author ZhangZhiHao
 */
public class CPUCacheDemo {

    public static void main(String[] args) {
        int[] arr = new int[64 * 1024 * 1024];
        // 循环1
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) arr[i] *= 3;
        System.out.println("循环1花费时间: " + (System.currentTimeMillis() - start));
        // 循环2
        start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i += 16) arr[i] *= 3;
        System.out.println("循环2花费时间: " + (System.currentTimeMillis() - start));
    }
}
