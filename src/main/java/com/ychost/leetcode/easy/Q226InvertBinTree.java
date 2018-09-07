package com.ychost.leetcode.easy;

import com.ychost.codeoffer.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ychost
 * @date 2018/9/7
 */
public class Q226InvertBinTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
           int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode l= node.left;
                node.left = node.right;
                node.right = l;
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }

            }
        }
        return root;
    }
}
