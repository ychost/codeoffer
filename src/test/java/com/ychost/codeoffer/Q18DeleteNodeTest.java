package com.ychost.codeoffer;

import com.ychost.codeoffer.model.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/8
 */
public class Q18DeleteNodeTest {

    @Test
    public void deleteDuplication() {
        ListNode pHead = new ListNode(1);
        ListNode pointer = pHead;
        int[] array = new int[]{1,1,2,2,3,3,4,5,5};
        for (int i = 0; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            pointer.next = node;
            pointer = node;
        }
        pHead = pHead.next;
        System.out.println("----before----");
        ListNode.print(pHead);
        pHead =new Q18DeleteNode().deleteDuplication(pHead);
        System.out.println("-----after-----");
        ListNode.print(pHead);
    }

}