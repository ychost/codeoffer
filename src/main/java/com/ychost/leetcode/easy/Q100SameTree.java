package com.ychost.leetcode.easy;

import com.ychost.codeoffer.model.TreeNode;

/**
 * @author ychost
 * @date 2018/9/7
 */
public class Q100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
