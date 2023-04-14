package com.zzh.demo;

/**
 * @author ZhangZhiHao
 */
public class CPUCacheDemo2 {

    public static void main(String[] args) {
        int size = 2 << 10;
        long sum = 0;
        long usedTime1;
        long usedTime2;
        long[][] a = new long[size][size];

        System.out.println("方式一,空间局部性");
        long start = System.currentTimeMillis();
        System.out.println("start time: " + start);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum += a[i][j];
            }
        }
        System.out.println("used time: " + (usedTime1 = System.currentTimeMillis() - start));

        System.out.println("方式二,无局部性");
        start = System.currentTimeMillis();
        System.out.println("start time: " + start);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum += a[j][i];
            }
        }
        System.out.println("used time: " + (usedTime2 = System.currentTimeMillis() - start));
        System.out.println("sum = " + sum);
        System.out.println("方式一是方式二的" + (double) usedTime2 / (double) usedTime1 + "倍");
    }
}
