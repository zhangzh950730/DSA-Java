package com.zzh.数据结构_邓俊辉.chapter8_高级搜索树;

import java.util.ArrayList;
import java.util.List;

/**
 * B-树节点类
 *
 * @author zhangzhihao
 * @date 2020/8/3 14:16
 */
public class BTNode<T> {
    BTNode parent;
    List<T> key = new ArrayList<>();
    List<BTNode<T>> child = new ArrayList<>();

    public BTNode() {
        parent = null;
        child.add(0, null);
    }

    public BTNode(T e, BTNode<T> lc, BTNode<T> rc) {
        parent = null;
        key.add(0, e);
        child.add(0, lc);
        child.add(1, rc);
        if (lc != null) {
            lc.parent = this;
        }
        if (rc != null) {
            rc.parent = this;
        }
    }
}
