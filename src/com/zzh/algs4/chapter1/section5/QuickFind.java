package com.zzh.algs4.chapter1.section5;

import com.zzh.algs4.std.StdIn;
import com.zzh.algs4.std.StdOut;

/**
 * @author ZhangZhiHao
 * @date 2021/6/28 12:36
 */
public class QuickFind extends UnionFind {

    /**
     * 初始化N个触点
     *
     * @param N
     */
    public QuickFind(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }
}
