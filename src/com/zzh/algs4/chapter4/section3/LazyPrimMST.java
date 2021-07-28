package com.zzh.algs4.chapter4.section3;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ZhangZhiHao
 * @date 2021/7/27 16:51
 */
public class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;
    private PriorityQueue<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new PriorityQueue<>();
        marked = new boolean[G.V()];
        mst = new LinkedList<>();
        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.offer(e);
            if (!marked[v]) {
                visit(G, v);
            }
            if (!marked[w]) {
                visit(G, w);
            }
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.offer(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        // TODO: 2021/7/27
        return -1;
    }
}
