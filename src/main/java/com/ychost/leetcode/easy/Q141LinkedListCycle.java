package com.ychost.leetcode.easy;

import com.ychost.codeoffer.model.ListNode;

/**
 * @author ychost
 * @date 2018/8/4
 */
public class Q141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode faster = head,slower =head;
        while(faster.next != null && faster.next.next!=null){
            faster = faster.next.next;
            slower = slower.next;
            if(faster == slower){
                return true;
            }
        }
        return false;
    }
}
