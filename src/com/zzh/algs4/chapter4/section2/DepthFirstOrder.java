package com.zzh.algs4.chapter4.section2;

import com.sun.javaws.jnl.ResourceVisitor;
import com.zzh.algs4.chapter4.section1.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ZhangZhiHao
 * @date 2021/7/27 14:35
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G) {
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        pre.offer(v);
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        post.offer(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
