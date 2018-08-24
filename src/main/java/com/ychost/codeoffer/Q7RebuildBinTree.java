package com.ychost.codeoffer;

import com.ychost.codeoffer.model.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * 剑指Offer 面试题 7，重建二叉树
 * @author ychost
 * @date 2018/7/7
 */
public class Q7RebuildBinTree {
    /**
     * 前序遍历 + 中序遍历 构建一颗二叉树
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre == null || in == null || pre.length ==0 || in.length ==0 || pre.length != in.length){
            return null;
        }
        return buildTree(pre,in,0,0,in.length-1);
    }


    public TreeNode buildTree(int[] pre,int[] in,int preStart,int inStart,int inEnd){
        if(inEnd< 0||inStart>inEnd ||preStart >= pre.length){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int valIndex = indexOf(in, root.val,0,inEnd);
        root.left = buildTree(pre,in,preStart+1,inStart,valIndex -1);
        root.right = buildTree(pre,in,preStart+valIndex - inStart +1,valIndex+1,inEnd);
        return root;
    }


    int indexOf(int[] array,int target,int start,int end){
        for (int i = start; i <= end; i++) {
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }
}
