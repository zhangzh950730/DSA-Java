package com.zzh.数据结构_邓俊辉.chapter8_高级搜索树;

import java.util.Collections;

/**
 * B-树
 *
 * @author zhangzhihao
 * @date 2020/8/3 10:58
 */
public class BTree<T> {
    protected int _size;
    protected int _order;
    protected BTNode<T> _root;
    protected BTNode<T> _hot;

    protected void solveOverflow(BTNode<T> node) {
        //TODO
    }

    protected void solveUnderflow(BTNode<T> node) {
        //TODO
    }

    public BTNode<T> search(T e) {
        BTNode<T> v = _root;
        _hot = null;
        while (v != null) {
            int r = Collections.binarySearch(v.key, e, null);
            if (0 <= r && e == v.key.get(r)) {
                return v;
            }
            _hot = v;
            v = v.child.get(r + 1);
        }
        return null;
    }

    public boolean insert(T e) {
        BTNode<T> v = search(e);
        if (v != null) {
            return false;
        }
        int r = Collections.binarySearch(_hot.key, e, null);
        _hot.key.add(r + 1, e);
        _hot.child.add(r + 2, null);
        _size++;
        solveOverflow(_hot);
        return true;
    }

    public boolean remove(T e) {
        BTNode<T> v = search(e);
        if (v == null) {
            return false;
        }
        int r = Collections.binarySearch(v.key, e, null);
        if (v.child.get(0) != null) {
            BTNode<T> u = v.child.get(r + 1);
            while (u.child.get(0) != null) {
                u = u.child.get(0);
            }
            v.key.set(r, u.key.get(0));
            v = u;
            r = 0;
        }
        v.key.remove(r);
        v.child.remove(r + 1);
        _size--;
        solveUnderflow(v);
        return true;
    }

}
