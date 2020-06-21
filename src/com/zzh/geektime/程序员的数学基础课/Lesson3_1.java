package com.zzh.geektime.程序员的数学基础课;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/6/15 22:10
 */
public class Lesson3_1 {

    /**
     * 算算舍罕王给了多少粒麦子
     *
     * @param grid - 放到第几格
     *
     * @return long -麦粒的总数
     */
    public static long getNumberOfWheat(int grid) {
        // 麦粒总数
        long sum = 1;
        // 当前格子里的麦粒数量
        long numberOfWheatInGrid = 1;

        for (int i = 2; i <= grid; i++) {
            numberOfWheatInGrid *= 2;
            sum += numberOfWheatInGrid;
        }

        return sum;
    }

    public static void main(String[] args) {

        int grid = 63;
        long start, end = 0;
        start = System.currentTimeMillis();
        System.out.println(String.format("舍罕王给了这么多粒：%d", Lesson3_1.getNumberOfWheat(grid)));
        end = System.currentTimeMillis();
        System.out.println(String.format("耗时%d毫秒", (end - start)));

        start = System.currentTimeMillis();
        System.out.println(String.format("舍罕王给了这么多粒：%d", (long)(Math.pow(2, grid)) - 1));
        end = System.currentTimeMillis();
        System.out.println(String.format("耗时%d毫秒", (end - start)));

    }
}
