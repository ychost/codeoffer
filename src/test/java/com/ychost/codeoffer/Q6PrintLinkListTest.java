package com.ychost.codeoffer;

import com.ychost.codeoffer.model.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/7
 */
public class Q6PrintLinkListTest {

    @Test
    public void printListFromTailToHead() {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2};
        ListNode header = null,node=null;
        for (int val : array) {
            ListNode cur= new ListNode(val);
            if(header == null){
                header = cur;
            }else{
                node.next = cur;
            }
            node = cur;
        }

        ArrayList<Integer> list = new Q6PrintLinkList().printListFromTailToHead(header);
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i).intValue(),array[array.length -i -1]);
        }
    }
}