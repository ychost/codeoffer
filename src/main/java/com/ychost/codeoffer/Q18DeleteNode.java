package com.ychost.codeoffer;

import com.ychost.codeoffer.model.ListNode;

/**
 * 剑指Offer 面试题 18，删除链表的节点
 * @author ychost
 * @date 2018/7/8
 */
public class Q18DeleteNode {
    void deleteNode(ListNode header,ListNode delNode){
        if(delNode.next != null){
            delNode.val = delNode.next.val;
            delNode.next = delNode.next.next;
        }else if(header == delNode){
           header.next = null;
           header = null;
        }else {
            ListNode pointer = header;
            while(pointer != null && pointer.next != delNode){
                pointer = pointer.next;
            }
            if(pointer != null){
                pointer.next = null;
            }
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null){
            return pHead;
        }
        ListNode pointer = pHead;
        ListNode pre = null;
        ListNode next = pointer.next;
        while (next != null){
            if(pointer.val == next.val){
                int val = pointer.val;
                while(pointer != null && pointer.val == val){
                    pointer = pointer.next;
                }
                if(pointer == null){
                    if(pre == null) {
                        return null;
                    }
                   pre.next =null;
                   return pHead;
                }
                if(pre != null){
                    pre.next = pointer;
                }else{
                    pHead = pointer;
                }
            }else {
                pre = pointer;
                pointer = next;
            }
            next = pointer.next;
        }

        return pHead;
    }
}
