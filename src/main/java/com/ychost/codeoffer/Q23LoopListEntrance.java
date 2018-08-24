package com.ychost.codeoffer;

import com.ychost.codeoffer.model.ListNode;

/**
 * 剑指Offer 面试题23 链表中的环的入口
 * @author ychost
 * @date 2018/7/14
 */
public class Q23LoopListEntrance {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null){
            return null;
        }
        ListNode faster = pHead,slower = pHead;
        if(faster.next == null){
            return null;
        }
        do{
           faster = faster.next.next;
           slower = slower.next;
        }
        while((faster != slower) && faster != null && faster.next !=null );
        if(faster == null){
            return null;
        }
        slower = pHead;
        while(slower != faster){
            faster = faster.next;
            slower = slower.next;
        }

        return faster;
    }
}
