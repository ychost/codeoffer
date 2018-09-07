package com.ychost.leetcode.hard;

import com.ychost.codeoffer.model.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/9/5
 */
public class Q297DSBinTreeTest {

    @Test
    public void build() {
        Integer[] array = new Integer[]{1,2,3,null,null,4,5};
        Q297DSBinTree bs = new Q297DSBinTree();
        TreeNode root =  bs.build(array);
        String str = bs.serialize(root);
        TreeNode d = bs.deserialize("[1,null,2]");
        System.out.println(str);
    }
}