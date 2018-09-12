package com.ychost.leetcode.easy;

import com.ychost.codeoffer.model.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ychost
 * @date 2018/9/7
 */
public class Q538ConvBST2GreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

}
