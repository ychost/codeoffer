package com.ychost.codeoffer;

import com.ychost.codeoffer.model.ListNode;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/14
 */
public class Q23LoopListEntranceTest {

    @Test
    public void entryNodeOfLoop() {
        Map<Integer,ListNode> map = ListNode.create(new int[]{1,2,3,4,5,6});
        //map.get(6).next = map.get(1);
        ListNode entry = new Q23LoopListEntrance().EntryNodeOfLoop(map.get(1));
        System.out.println(entry.val);

    }
}