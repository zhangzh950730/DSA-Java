package com.zzh.algs4.chapter4.section3;

import com.zzh.algs4.chapter1.section5.UnionFind;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ZhangZhiHao
 * @date 2021/7/28 16:54
 */
public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new LinkedList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (Edge e : G.edges()) {
            pq.offer(e);
        }
        UnionFind uf = new UnionFind(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) {
                continue;
            }
            uf.union(v, w);
            mst.offer(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
