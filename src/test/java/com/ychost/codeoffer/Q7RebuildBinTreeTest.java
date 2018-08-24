package com.ychost.codeoffer;

import com.ychost.codeoffer.model.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/7
 */
public class Q7RebuildBinTreeTest {

    @Test
    public void reConstructBinaryTree() {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode root = new Q7RebuildBinTree().reConstructBinaryTree(pre,in);
        System.out.println(root.val);
    }
}