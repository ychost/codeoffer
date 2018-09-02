package com.ychost.leetcode.medium;

import com.ychost.codeoffer.model.RandomListNode;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class Q138CopyRandomPointerTest {

    @Test
    public void copyRandomList2() {
       Map<Integer,RandomListNode> map = RandomListNode.create(new int[]{1});
       RandomListNode cp = new Q138CopyRandomPointer().copyRandomList2(map.get(1));
        System.out.println(cp);
        System.out.println(cp == map.get(1));
    }
}