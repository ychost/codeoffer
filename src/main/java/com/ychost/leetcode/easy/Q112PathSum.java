package com.ychost.leetcode.easy;

import com.ychost.codeoffer.model.TreeNode;

/**
 * @author ychost
 * @date 2018/9/7
 */
public class Q112PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
      if(root == null){
          return false;
      }
      return valid(root,sum);
    }

    boolean valid(TreeNode root,int sum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && sum == root.val){
            return true;
        }
        return valid(root.left,sum-root.val) || valid(root.right,sum-root.val);
    }
}
