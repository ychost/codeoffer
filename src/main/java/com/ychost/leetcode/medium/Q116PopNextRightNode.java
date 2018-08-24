package com.ychost.leetcode.medium;

import com.ychost.codeoffer.model.TreeLinkNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ychost
 * @date 2018/8/21
 */
public class Q116PopNextRightNode {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        Queue<TreeLinkNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeLinkNode pre = null;
            for(int i=0;i<size;i++){
                TreeLinkNode node = queue.poll();
                if(pre != null){
                    pre.next = node;
                }
                if(node.left!= null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                pre = node;
            }
        }
    }
}
