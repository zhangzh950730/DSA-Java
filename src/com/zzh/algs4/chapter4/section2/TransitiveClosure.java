package com.zzh.algs4.chapter4.section2;

/**
 * @author ZhangZhiHao
 * @date 2021/7/28 10:24
 */
public class TransitiveClosure {
    private DirectedDFS[] all;

    public TransitiveClosure(Digraph G) {
        all = new DirectedDFS[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v] = new DirectedDFS(G, v);
        }
    }

    boolean reachable(int v, int w) {
        return all[v].marked(w);
    }
}
