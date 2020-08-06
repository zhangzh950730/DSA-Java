package com.zzh.数据结构_邓俊辉.chapter8_高级搜索树;

import com.zzh.数据结构_邓俊辉.chapter5_二叉树.BinNode;
import com.zzh.数据结构_邓俊辉.chapter5_二叉树.BinNodeColor;
import com.zzh.数据结构_邓俊辉.chapter7_二叉搜索树.BST;

import javax.swing.*;

/**
 * @author zhangzhihao
 * @date 2020/8/5 14:40
 */
public class RedBlackTree extends BST {

    @Override
    public BinNode<Integer> insert(Integer e) {
        BinNode<Integer> x = search(e);
        if (x != null) {
            return x;
        }
        x = new BinNode<>(e, _hot, -1, BinNodeColor.RED);
        _size++;
        BinNode<Integer> xOld = x;
        solveDoubleRed(x);
        return xOld;
    }

    @Override
    public boolean remove(Integer e) {
        BinNode<Integer> x = search(e);
        if (x == null) { //保证被删除节点存在
            return false;
        }
        BinNode<Integer> r = removeAt(x); //r为删除节点的后继节点
        if (--_size <= 0) { //若删除后为空树,可直接返回
            return true;
        }
        if (_hot == null) { //若被删除的是根,则
            _root.color = BinNodeColor.BLACK; //将其至黑
            updateHeight(_root); //并更新全树黑高度
            return true;
        }

        // 至此,原x现r必非根

        if (blackHeightUpdated(_hot)) { //若父亲及祖先依然平衡,则无需调整
            return true;
        }

        if (isRed(r)) { //如果被删除后继节点为红,只需转变为黑
            r.color = BinNodeColor.BLACK;
            r.height++;
            return true;
        }
        // x与r都为黑,执行双黑调整
        solveDoubleBlack(r);
        return true;
    }

    private boolean blackHeightUpdated(BinNode<Integer> x) {
        x.height = (isRed(x) ? stature(x.lChild) : stature(x.lChild) + 1);
        return stature(x.lChild) == stature(x.rChild) && x.height > 0;
    }

    protected void solveDoubleRed(BinNode<Integer> x) {
        if (isRoot(x)) { //若已递归至树根,则将其转黑,整数高度也随之递增
            _root.color = BinNodeColor.BLACK;
            _root.height++;
            return;
        }
        BinNode<Integer> p = x.parent;
        if (isBlack(p)) return;  //若p为黑,可终止调整

        BinNode<Integer> g = p.parent; //既然p为红,则x的祖父必然存在,且为黑
        BinNode<Integer> u = uncle(x); //以下,视x叔父u的颜色分别处理
        if (isBlack(u)) { //u为黑色时
            if (isLChild(x) == isLChild(p)) { //若x与p同侧
                p.color = BinNodeColor.BLACK;
            } else {
                x.color = BinNodeColor.BLACK;
            }
            g.color = BinNodeColor.RED;
            BinNode<Integer> gg = g.parent; //曾祖父
            BinNode<Integer> r = rotateAt(x); //重构
            r.parent = gg;
        } else { //u为红色
            p.color = BinNodeColor.BLACK;
            p.height++;
            u.color = BinNodeColor.BLACK;
            u.height++;
            if (!isRoot(g)) {
                g.color = BinNodeColor.RED;
            }
            solveDoubleRed(g);
        }
    }

    private BinNode<Integer> uncle(BinNode<Integer> x) {
        BinNode<Integer> p = x.parent;
        BinNode<Integer> g = p.parent;
        return g.lChild == p ? g.rChild : g.lChild;
    }

    protected void solveDoubleBlack(BinNode<Integer> r) {
        BinNode<Integer> p = r != null ? r.parent : _hot;
        if (p == null) { //r的父亲
            return;
        }
        BinNode<Integer> s = r == p.lChild ? p.rChild : p.lChild; //r的兄弟
        if (isBlack(s)) { //兄弟s为黑
            BinNode<Integer> t = null; //s的红孩子(若左右孩子皆红,左者优先;皆黑时为null)
            if (isRed(s.rChild)) {
                t = s.rChild;
            }
            if (isRed(s.lChild)) {
                t = s.lChild;
            }
            if (t != null) { //黑s有红孩子:BB-1
                BinNodeColor oldColor = p.color; //备份原来局部子树的根节点颜色
                BinNode<Integer> b = rotateAt(t);// 旋转
                if (b.hasLChild()) {
                    b.lChild.color = BinNodeColor.BLACK;
                    updateHeight(b.lChild);
                }
                if (b.hasRChild()) {
                    b.rChild.color = BinNodeColor.BLACK;
                    updateHeight(b.rChild);
                }
                b.color = oldColor;
                updateHeight(b);
            } else { //黑s无红孩子
                s.color = BinNodeColor.RED; //s转红
                s.height--;
                if (isRed(p)) { //BB-2R
                    p.color = BinNodeColor.BLACK; //p转黑,但黑高度不变
                } else { //BB-2B
                    p.height--;
                    solveDoubleBlack(p);
                }
            }

        } else { //兄弟s为红:BB-3
            // s,p互换颜色
            s.color = BinNodeColor.BLACK;
            p.color = BinNodeColor.RED;

            BinNode<Integer> t = isLChild(s) ? s.lChild : s.rChild; //取t与其父s同侧
            p = rotateAt(t); //旋转
            _hot = p;
            solveDoubleBlack(r);
        }
    }

    @Override
    public int updateHeight(BinNode<Integer> x) {
        x.height = Math.max(stature(x.lChild), stature(x.rChild));
        if (isBlack(x)) {
            x.height++;
        }
        return x.height;
    }

    private boolean isBlack(BinNode<Integer> x) {
        return x.color == BinNodeColor.BLACK;
    }

    private boolean isRed(BinNode<Integer> x) {
        return x.color == BinNodeColor.RED;
    }

}
