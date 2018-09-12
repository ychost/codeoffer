package com.ychost.leetcode.easy;

import com.ychost.codeoffer.model.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/9/7
 */
public class Q538ConvBST2GreaterTreeTest {

    @Test
    public void calc() {
        TreeNode root = TreeNode.create(new Integer[]{9,7,13,4,8});
        Map<TreeNode,Integer> map = new HashMap<>();

    }

    @Test
    public void convertBST() {
        TreeNode root = TreeNode.create(new Integer[]{0,-1,2,-3,null,null,4});
        root = new Q538ConvBST2GreaterTree().convertBST(root);
        System.out.println(root);
    }
}