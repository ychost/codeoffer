package com.ychost.codeoffer.model;

/**
 * @author ychost
 * @date 2018/7/7
 */
public class TreeLinkNode {
    public TreeLinkNode next = null;
    public TreeLinkNode left = null;
    public TreeLinkNode right = null;
    public int val;

    public TreeLinkNode(int x) {
        this.val = x;
    }
}
