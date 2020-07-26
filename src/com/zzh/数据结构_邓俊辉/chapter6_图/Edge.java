package com.zzh.数据结构_邓俊辉.chapter6_图;

/**
 * @author zhangzhihao
 * @date 2020/7/26 16:31
 */
public class Edge<E> {
    /**
     * 数据
     */
    E data;

    /**
     * 权重
     */
    int weight;

    /**
     * 状态
     */
    EStatus status;

    public Edge(E data, int weight) {
        this.data = data;
        this.weight = weight;
        status = EStatus.UNDETERMINED;
    }

    private enum EStatus {
        UNDETERMINED, TREE, CROSS, FORWARD, BACKWARD
    }
}
