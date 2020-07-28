package com.zzh.数据结构_邓俊辉.chapter6_图;

/**
 * @author zhangzhihao
 * @date 2020/7/26 16:01
 */
public abstract class Graph<V, E> {
    // 顶点
    int n = 0;

    abstract int insert(V vertex);

    abstract V remove(int i);

    abstract V vertex(int i);

    abstract int inDegree(int i);

    abstract int outDegree(int i);

    abstract int firstNeighbor(int i);

    abstract int nextNeighbor(int i, int j);

    abstract Vertex.VStatus status(int i);

    abstract int dTime(int i);

    abstract int fTime(int i);

    abstract int parent(int i);

    abstract int priority(int i);

    // 边
    int e = 0;

    abstract boolean exists(int i, int j);

    abstract void insert(E edge, int w, int i, int j);

    abstract E remove(int i, int j);

    abstract Edge.EType type(int i, int j);

    abstract E edge(int i, int j);

    abstract int weight(int i, int j);

    // 算法

    abstract void BFS(int v, int clock);

    abstract void DFS(int v, int clock);
}
