package com.ychost.leetcode.medium;

import com.ychost.codeoffer.model.ListNode;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/8/10
 */
public class Q328OddEvenListTest {

    @Test
    public void oddEvenList() {
        Map<Integer,ListNode> map= ListNode.create(new int[]{1,2,3,4,5});
        ListNode list = new Q328OddEvenList().oddEvenList(map.get(1));
        ListNode.print(list);
    }
}