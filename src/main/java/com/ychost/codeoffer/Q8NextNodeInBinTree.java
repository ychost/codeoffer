package com.ychost.codeoffer;

import com.ychost.codeoffer.model.TreeLinkNode;
import sun.reflect.generics.tree.Tree;

/**
 * 剑指Offer 第 8 题，二叉树的下一个节点
 *
 * @author ychost
 * @date 2018/7/7
 */
public class Q8NextNodeInBinTree {
    /**
     * 中序遍历的下一个节点，next 指向的是父节点
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null){
            return null;
        }
        TreeLinkNode nextNode = null;
        // 右节点不为空
        if(pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            nextNode = node;
        }else if(pNode.next != null){
           TreeLinkNode parent = pNode.next ;
           TreeLinkNode current = pNode;
           while(parent != null &&current == parent.right){
              current = parent;
              parent = parent.next;
           }
           nextNode = parent;
        }
        return nextNode;
    }
}
