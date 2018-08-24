package com.ychost.codeoffer;

import com.ychost.codeoffer.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指Offer 第6题，从尾到头打印链表
 */
public class Q6PrintLinkList {
    ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        reverseLinkList(listNode,list);
        return list;
    }

    void reverseLinkList(ListNode node,List<Integer> list){
        if (node != null) {
            reverseLinkList(node.next,list);
            list.add(node.val);
        }
    }
}
