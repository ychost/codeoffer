package com.ychost.leetcode.easy;

import com.ychost.codeoffer.model.TreeNode;

/**
 * @author ychost
 * @date 2018/9/7
 */
public class Q437PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        return getSum(root,sum) +pathSum(root.left,sum) +pathSum(root.right,sum);
    }

    int getSum(TreeNode node,int sum){
        if(node== null){
            return 0;
        }
        return (node.val == sum ? 1 : 0) + getSum(node.left,sum-node.val) + getSum(node.right,sum-node.val);
    }
}
