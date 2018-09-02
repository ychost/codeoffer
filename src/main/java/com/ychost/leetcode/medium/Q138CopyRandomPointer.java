package com.ychost.leetcode.medium;

import com.ychost.codeoffer.model.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class Q138CopyRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode p = head;
        while (p!=null){
            if(!map.containsKey(p)){
                RandomListNode cp = new RandomListNode(p.label);
                map.put(p,cp);
            }
            if(p.random != null && !map.containsKey(p.random)){
                RandomListNode rp = new RandomListNode(p.random.label);
                map.put(p.random,rp);
            }
            p = p.next;
        }
        p = head;
        while (p != null){
            if(p.next != null) {
                map.get(p).next = map.get(p.next);
            }
            if(p.random != null){
                map.get(p).random = map.get(p.random);
            }
            p = p.next;
        }

        return map.get(head);
    }
    public RandomListNode copyRandomList2(RandomListNode head) {
        if(head == null){
            return null;
        }
        RandomListNode p = head;
        // copy node
        while (p!= null){
           RandomListNode orgNext = p.next;
           RandomListNode cp = new RandomListNode(p.label);
           cp.next = orgNext;
           p.next = cp;
           p = orgNext;
        }
        // link random
        p = head;
        while (p != null && p.next != null){
            RandomListNode cp = p.next;
            RandomListNode orgNext = p.next.next;
            if(p.random != null){
                cp.random = p.random.next;
            }
            p = orgNext;
        }
        // link next
        p = head;
        RandomListNode ch = null;
        while (p != null && p.next != null){
            RandomListNode cp = p.next;
            RandomListNode orgNext = p.next.next;
            if(cp.next != null){
                cp.next = cp.next.next;
            }
            if(ch == null){
                ch = cp;
            }
            p.next = orgNext;
            p = orgNext;
        }
        return ch;
     }
}
