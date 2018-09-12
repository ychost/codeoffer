package com.ychost.leetcode.easy;

import com.ychost.codeoffer.model.TreeNode;

/**
 * @author ychost
 * @date 2018/9/7
 */
public class Q534DiameterOfBinTree {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return ans;
    }

    int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        ans = Math.max(l+r-1,ans);
        return Math.max(l,r)+1;
    }
}
