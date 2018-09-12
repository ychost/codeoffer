package com.ychost.leetcode.easy;

import com.ychost.codeoffer.model.TreeNode;

import java.util.Stack;

/**
 * @author ychost
 * @date 2018/9/10
 */
public class Q572SubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null){
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()){
           TreeNode node = stack.pop();
           if(node.right != null){
               stack.push(node.right);
           }
           if(node.left != null){
               stack.push(node.left);
           }
           if(node.val == t.val){
               if(valid(node,t)){
                   return true;
               }
           }
        }
        return false;
    }

    boolean valid(TreeNode father,TreeNode son){
        if(father == null && son == null){
            return true;
        }
        if(father == null || son == null){
            return false;
        }
        if(father.val != son.val){
            return false;
        }
        return valid(father.left,son.left) && valid(father.right,son.right);
    }

}
