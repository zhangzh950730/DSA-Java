package com.zzh.algs4.chapter4.section2;

import java.util.ArrayList;

/**
 * @author ZhangZhiHao
 * @date 2021/7/27 10:16
 */
public class Digraph {
    private final int V;
    private int E;
    private ArrayList<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (Integer w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

}
