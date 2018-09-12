package com.ychost.leetcode.medium;

import com.ychost.codeoffer.model.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ychost
 * @date 2018/9/7
 */
public class Q113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        return result;
    }

    int count = 0;
    void count(TreeNode root,int sum){
        if(root == null){
            return;
        }
        if(root.val == sum){
            count+=1;
        }
        count(root.left,sum-root.val);
    }


}
