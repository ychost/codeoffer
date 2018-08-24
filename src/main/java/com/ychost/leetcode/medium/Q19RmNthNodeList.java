package com.ychost.leetcode.medium;

import com.ychost.codeoffer.model.ListNode;

/**
 * @author ychost
 * @date 2018/8/22
 */
public class Q19RmNthNodeList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        while(n--!=0 && p1 != null){
            p1 = p1.next;
        }
        if(p1 == null){
            return head.next;
        }
        while(p1.next != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        p2.next = p2.next.next;
        return head;
    }
}
