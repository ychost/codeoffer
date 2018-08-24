package com.ychost.codeoffer;

import com.ychost.codeoffer.model.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/14
 */
public class SymmetricalTreeTest {

    @Test
    public void isSymmetrical() {
        TreeNode root = new TreeNode(8);
        TreeNode node6a = new TreeNode(6);
        TreeNode node6b = new TreeNode(6);
        TreeNode node5a = new TreeNode(5);
        TreeNode node5b = new TreeNode(5);
        TreeNode node7a = new TreeNode(7);
        TreeNode node7b = new TreeNode(7);
        root.left = node6a;
        root.right = node6b;
        node6a.left = node5a;
        node6a.right = node7a;
        node6b.right = node5b;
        //node6b.left = node7b;
        System.out.println(new SymmetricalTree().isSymmetrical(root));
    }
}