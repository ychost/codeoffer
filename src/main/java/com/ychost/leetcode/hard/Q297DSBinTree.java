package com.ychost.leetcode.hard;

import com.ychost.codeoffer.model.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author ychost
 * @date 2018/9/5
 */
public class Q297DSBinTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<Object> queue = new LinkedList<>();
        queue.offer(root);
        Object NULL = new Object();
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Object o= queue.poll();
                if(o instanceof TreeNode) {
                    TreeNode node = (TreeNode) o;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }else{
                        queue.offer(NULL);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }else{
                        queue.offer(NULL);
                    }
                    list.add(node.val);
                }else{
                    list.add(null);
                }
            }
        }
        return Arrays.toString(list.toArray());
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()){
            return null;
        }
        data = data.substring(1,data.length()-1);
        String[] strs = data.split(",\\s*");
        if(strs.length == 0){
            return null;
        }
        Integer[] array = new Integer[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].startsWith("n")){
                array[i] = null;
            }else {
                array[i] = Integer.parseInt(strs[i]);
            }
        }
        return build(array);
    }

    TreeNode build(Integer[] array){
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < array.length && !queue.isEmpty(); i+=2) {
            TreeNode node = queue.poll();
            if(array[i] != null) {
                TreeNode left = new TreeNode(array[i]);
                node.left = left;
                queue.offer(left);

            }
             if(i+1<array.length && array[i+1] != null) {
                TreeNode right = new TreeNode(array[i+1]);
                node.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}
