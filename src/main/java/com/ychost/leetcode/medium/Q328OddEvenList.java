package com.ychost.leetcode.medium;

import com.ychost.codeoffer.model.ListNode;

/**
 * @author ychost
 * @date 2018/8/10
 */
public class Q328OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddList =head;
        ListNode evenList=head.next;
        ListNode pointer = head;
        ListNode oddPre = null;
        ListNode evenPre= null;
        int idx = 1;
        while(pointer!=null){
            ListNode next = pointer.next;
            pointer.next = null;
           if((idx & 0x01) == 1){
               if(oddPre != null){
                   oddPre.next = pointer;
               }
               oddPre = pointer;
           }else{
              if(evenPre != null){
                  evenPre.next = pointer;
              }
              evenPre = pointer;
           }
           pointer =next;
           idx+=1;
        }
        oddPre.next = evenList;
        return oddList;
    }
}
