package com.zzh.algs4.chapter4.section4;

import java.util.ArrayList;

/**
 * @author ZhangZhiHao
 * @date 2021/7/29 9:23
 */
public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private ArrayList<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (ArrayList<DirectedEdge>[]) new ArrayList[V];
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

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        ArrayList<DirectedEdge> list = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                list.add(e);
            }
        }
        return list;
    }

}
