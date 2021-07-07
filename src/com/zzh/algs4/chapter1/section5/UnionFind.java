package com.zzh.algs4.chapter1.section5;

import com.zzh.algs4.std.StdIn;
import com.zzh.algs4.std.StdOut;

/**
 * @author ZhangZhiHao
 * @date 2021/6/28 11:23
 */
public abstract class UnionFind {

    /**
     * 分量id,以触点作为索引
     */
    protected int[] id;

    /**
     * 分量数量
     */
    protected int count;

    /**
     * 初始化N个触点
     */
    public UnionFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * 连通分量的数量
     */
    public int count() {
        return count;
    }


    /**
     * p和q是否存在于同一个分量中
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * p(0到N-1)所在的分量的标识符
     */
    public abstract int find(int p);

    /**
     * 在p和q之间添加一条连接
     */
    public abstract void union(int p, int q);


}
