package com.ychost.leetcode.medium;

import com.ychost.codeoffer.model.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/9/7
 */
public class Q113PathSumIITest {

    @Test
    public void pathSum() {
        TreeNode root = TreeNode.create(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1 });
        System.out.println(new Q113PathSumII().pathSum(root,22));
    }
}