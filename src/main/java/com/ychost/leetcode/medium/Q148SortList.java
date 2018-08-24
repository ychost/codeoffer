package com.ychost.leetcode.medium;

import com.ychost.codeoffer.model.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ychost
 * @date 2018/8/22
 */
public class Q148SortList {
    public ListNode sortList(ListNode head){
        if(head == null ||head.next == null){
            return head;
        }
        ListNode fast=head,slow=head,pre=null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        // head --->pre--->slow--->fast
        pre.next = null;
        // 分治前半部分 head ---> pre
        ListNode l1 = sortList(head);
        // 分治后半部分 slow ---> fast
        ListNode l2 = sortList(slow);
        // 将两个有序链表 l1,l2 归并
        return merge(l1,l2);
    }

    ListNode merge(ListNode l1,ListNode l2){
        ListNode head = null,p = null;
        while(l1!=null && l2 != null){
            ListNode node;
            if(l1.val<l2.val){
                node=l1;
                l1=l1.next;
            }else{
                node = l2;
                l2 = l2.next;
            }
            if(p == null){
                head = node;
            }else{
                p.next = node;
            }
            p=node;
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }
        return head;
    }


}
