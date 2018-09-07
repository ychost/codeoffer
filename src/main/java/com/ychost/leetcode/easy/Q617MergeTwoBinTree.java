package com.ychost.leetcode.easy;

import com.ychost.codeoffer.model.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ychost
 * @date 2018/9/7
 */
public class Q617MergeTwoBinTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(t1);
        queue.offer(t2);
        while (!queue.isEmpty()){
            int size = queue.size() /2 ;
            for (int i = 0; i < size; i++) {
                TreeNode node1 = queue.poll();
                TreeNode node2 = queue.poll();
                    node1.val += node2.val;
                    if(node1.left != null && node2.left != null){
                        queue.offer(node1.left);
                        queue.offer(node2.left);
                    }else if(node1.left == null){
                        node1.left = node2.left;
                    }
                    if(node1.right != null && node2.right != null){
                        queue.offer(node1.right);
                        queue.offer(node2.right);
                    }else if(node1.right == null){
                        node1.right = node2.right;
                    }
                }
        }
        return t1;
    }
}
