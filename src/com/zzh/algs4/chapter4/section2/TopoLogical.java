package com.zzh.algs4.chapter4.section2;

/**
 * @author ZhangZhiHao
 * @date 2021/7/27 15:36
 */
public class TopoLogical {
    private Iterable<Integer> order;

    public TopoLogical(Digraph G) {
        DirectedCycle directedCycle = new DirectedCycle(G);
        if (!directedCycle.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order(){
        return order;
    }

    public boolean isDAG(){
        return order != null;
    }

}
