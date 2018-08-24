package com.ychost.codeoffer;

import com.ychost.codeoffer.model.TreeNode;

/**
 * 剑指Offer 面试题 28 对称的二叉树
 * @author ychost
 * @date 2018/7/14
 */
public class SymmetricalTree {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return false;
        }
        return isMirror(pRoot.left,pRoot.right);
    }

    boolean isMirror(TreeNode left,TreeNode right){
        if(left == null) {
            return right == null;
        }
        if(right == null) {
            return  false;
        }
        return left.val == right.val && isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }
}
