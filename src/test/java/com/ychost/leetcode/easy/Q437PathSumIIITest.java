package com.ychost.leetcode.easy;

import com.ychost.codeoffer.model.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/9/7
 */
public class Q437PathSumIIITest {

    @Test
    public void pathSum() {
        TreeNode root = TreeNode.create(new Integer[]{10,3,-3,3,2,11,3,-2,null,1});
        System.out.println(new Q437PathSumIII().pathSum(root,8));
    }
}