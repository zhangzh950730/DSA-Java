package com.zzh.algs4.chapter4.section2;

import com.zzh.algs4.chapter4.section1.Graph;

import java.util.Stack;

/**
 * @author ZhangZhiHao
 * @date 2021/7/27 11:19
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
            onStack[v] = false;
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        Digraph digraph = new Digraph(6);
        digraph.addEdge(0, 5);
        digraph.addEdge(3, 5);
        digraph.addEdge(4, 3);
        digraph.addEdge(5, 4);
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        System.out.println("directedCycle = " + directedCycle);
    }

}
