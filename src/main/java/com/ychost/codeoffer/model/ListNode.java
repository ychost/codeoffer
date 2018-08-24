package com.ychost.codeoffer.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ychost
 * @date 2018/7/7
 */
public class ListNode {
   public int val;
   public ListNode next;
   public ListNode(int val){
      this.val = val;
   }

 public  static void print(ListNode header){
       if(header == null){
           return;
       }
       ListNode pointer = header;
       while(pointer.next != null){
           System.out.print(pointer.val +"->");
           pointer = pointer.next;
       }
       System.out.println(pointer.val);
   }

   public static Map<Integer,ListNode> create(int[] array){
       if(array == null ||array.length == 0){
           return null;
       }
       ListNode head = new ListNode(array[0]);
       ListNode p = head;
       Map<Integer,ListNode> map = new HashMap<>();
       map.put(array[0],head);
       for (int i = 1; i < array.length; i++) {
          ListNode node = new ListNode(array[i]);
          p.next = node;
          p = node;
          map.put(array[i],node);
       }
       return map;
   }

}
