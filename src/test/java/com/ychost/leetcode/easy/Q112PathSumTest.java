package com.ychost.leetcode.easy;

import com.ychost.codeoffer.model.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/9/7
 */
public class Q112PathSumTest {

    @Test
    public void hasPathSum() {
        TreeNode root = TreeNode.create(new Integer[]{1,2});
        System.out.println(new Q112PathSum().hasPathSum(root,2));
    }
}