package com.ychost.codeoffer;

import com.ychost.codeoffer.model.TreeNode;

import javax.transaction.TransactionRequiredException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按 之 字型打印二叉树
 * @author ychost
 * @date 2018/7/8
 */
public class PrintTreeByZ {

    ArrayList<ArrayList<Integer>> printTreeByZ(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null){
           return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        boolean isLeftToRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> layerList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(isLeftToRight = !isLeftToRight) {
                    layerList.add(node.val);
                }else{
                    layerList.add(0,node.val);
                }
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
            result.add(layerList);
        }

        return result;
    }
}
