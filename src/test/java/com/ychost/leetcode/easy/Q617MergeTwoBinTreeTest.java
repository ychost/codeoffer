package com.ychost.leetcode.easy;

import com.ychost.codeoffer.model.TreeNode;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/9/7
 */
public class Q617MergeTwoBinTreeTest {

    @Test
    public void mergeTrees() {
        TreeNode t1 = TreeNode.create(new Integer[]{1,3,2,5});
        TreeNode t2 = TreeNode.create(new Integer[]{2,1,3,null,4,null,7});
        TreeNode root = new Q617MergeTwoBinTree().mergeTrees(t1,t2);
        System.out.println(root);
    }
}