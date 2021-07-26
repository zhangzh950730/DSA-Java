package com.zzh.algs4.chapter4.section1;

import java.util.ArrayList;

/**
 * @author ZhangZhiHao
 * @date 2021/7/26 14:35
 */
public class Graph {
    private final int V;
    private int E;
    private ArrayList<Integer>[] adj;

    /**
     * 创建一个含有v个顶点但不含有边的图
     */
    public Graph(int V) {
        this.V = V;
        this.E = 0;

        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    /**
     * 向图中添加一条边v-w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    /**
     * 和v相邻的所有顶点
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * 顶点数
     */
    public int V() {
        return V;
    }

    /**
     * 边数
     */
    public int E() {
        return E;
    }

    /**
     * 计算v的深度
     */
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (Integer w : G.adj(v)) {
            degree++;
        }
        return degree;
    }

    /**
     * 计算所有顶点的最大度数
     */
    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            int degree = degree(G, v);
            if (degree > max) {
                max = degree;
            }
        }
        return max;
    }

    /**
     * 计算所有订单的平均度数
     */
    public static double avgDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    /**
     * 计算自环的个数
     */
    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (Integer w : G.adj(v)) {
                if (v == w) {
                    count++;
                }
            }
        }
        return count / 2;
    }

    /**
     * 图的邻接表的字符串表示
     */
    @Override
    public String toString() {
        String s = V + "vertices," + E + "edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ":";
            for (Integer w : this.adj(v)) {
                s += w + "";
                s += "\n";
            }
        }
        return s;
    }

}
