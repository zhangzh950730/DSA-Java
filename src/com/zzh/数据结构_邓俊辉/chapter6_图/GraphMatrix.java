package com.zzh.数据结构_邓俊辉.chapter6_图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * @author zhangzhihao
 * @date 2020/7/27 11:40
 */
public class GraphMatrix<V, E> extends Graph<V, E> {
    /**
     * 顶点集合
     */
    private List<Vertex<V>> vertices;

    /**
     * 边集合
     */
    private List<List<Edge<E>>> edges;


    // 顶点的基本操作

    @Override
    int insert(V vertex) {
        for (int i = 0; i < n; i++) {
            edges.get(i).add(null);
        }
        n++;
        edges.add(new ArrayList<>(n));
        vertices.add(new Vertex<>(vertex));
        return vertices.size();
    }

    @Override
    V remove(int i) {
        // 所有出边
        for (int j = 0; j < n; j++) {
            if (exists(i, j)) {
                // 逐条删除
                edges.get(i).set(j, null);
                vertices.get(j).inDegree--;
            }
        }
        // 删除第i行
        edges.remove(i);
        n--;
        // 删除顶点i
        V vBak = vertex(i);
        vertices.remove(i);
        // 所有入边
        for (int j = 0; j < n; j++) {
            Edge<E> e = edges.get(j).remove(i);
            if (e != null) {
                vertices.get(j).outDegree--;
            }
        }
        return vBak;
    }

    @Override
    public V vertex(int i) {
        return vertices.get(i).data;
    }

    @Override
    public int inDegree(int i) {
        return vertices.get(i).inDegree;
    }

    @Override
    public int outDegree(int i) {
        return vertices.get(i).outDegree;
    }

    @Override
    public Vertex.VStatus status(int i) {
        return vertices.get(i).status;
    }

    @Override
    public int dTime(int i) {
        return vertices.get(i).dTime;
    }

    @Override
    public int fTime(int i) {
        return vertices.get(i).fTime;
    }

    @Override
    public int parent(int i) {
        return vertices.get(i).parent;
    }

    @Override
    public int priority(int i) {
        return vertices.get(i).priority;
    }

    @Override
    public int nextNeighbor(int i, int j) {
        while ((-1 < j) && !exists(i, --j)) ;
        return j;
    }

    @Override
    public int firstNeighbor(int i) {
        return nextNeighbor(i, edges.size());
    }

    // 边的操作
    @Override
    public boolean exists(int i, int j) {
        return 0 <= i && i < n
                && 0 <= j && j < n
                && edges.get(i).get(j) != null;
    }

    @Override
    public Edge.EType type(int i, int j) {
        return edges.get(i).get(j).type;
    }

    @Override
    public E edge(int i, int j) {
        return edges.get(i).get(j).data;
    }

    @Override
    public int weight(int i, int j) {
        return edges.get(i).get(j).weight;
    }

    /**
     * 新增边
     */
    @Override
    public void insert(E edge, int w, int i, int j) {
        if (exists(i, j)) {
            return;
        }
        edges.get(i).set(j, new Edge<>(edge, w));
        e++;
        vertices.get(i).outDegree++;
        vertices.get(j).inDegree++;
    }

    /**
     * 删除边
     */
    @Override
    public E remove(int i, int j) {
        E eBak = edge(i, j);
        edges.get(i).set(j, null);
        e--;
        vertices.get(i).outDegree--;
        vertices.get(j).inDegree--;
        return eBak;
    }

    @Override
    void BFS(int v, int clock) {
        Queue<Integer> queue = new LinkedList<>();
        vertices.get(v).status = Vertex.VStatus.DISCOVERED;
        queue.offer(v);
        while (!queue.isEmpty()) {
            v = queue.poll();
            vertices.get(v).dTime = ++clock;
            for (int u = firstNeighbor(v); -1 < u; u = nextNeighbor(v, u)) {
                if (Vertex.VStatus.UNDISCOVERED == status(u)) {
                    vertices.get(u).status = Vertex.VStatus.DISCOVERED;
                    queue.offer(u);
                    edges.get(v).get(u).type = Edge.EType.TREE;
                    vertices.get(u).parent = v;
                } else {
                    edges.get(v).get(u).type = Edge.EType.CROSS;
                }
            }
            vertices.get(v).status = Vertex.VStatus.VISITED;
        }
    }

    private Edge.EType status(int v, int u) {
        return null;
    }
}