package com.zzh.数据结构_邓俊辉.chapter6_图;

/**
 * @author zhangzhihao
 * @date 2020/7/26 16:22
 */
public class Vertex<V> {
    /**
     * 数据
     */
    V data;
    /**
     * 出入度数
     */
    int inDegree, outDegree;
    /**
     * 状态
     */
    VStatus status;
    /**
     * 时间标签
     */
    int dTime, fTime;
    /**
     * 在遍历树中的父节点
     */
    int parent;
    /**
     * 在遍历树中的优先级(最短通路,极短跨边等)
     */
    int priority;

    public Vertex(V d) {
        data = d;
        inDegree = 0;
        outDegree = 0;
        status = VStatus.UNDISCOVERED;
        dTime = -1;
        fTime = -1;
        parent = -1;
        priority = Integer.MAX_VALUE;
    }

    public enum VStatus {
        UNDISCOVERED, DISCOVERED, VISITED
    }
}
