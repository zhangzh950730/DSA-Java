package com.zzh.algs4.chapter1.section5;

/**
 * @author ZhangZhiHao
 * @date 2021/6/28 12:40
 */
public class QuickUnion extends UnionFind {

    /**
     * 初始化N个触点
     *
     * @param N
     */
    public QuickUnion(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return 0;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }
}
