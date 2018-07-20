package org.sherlockyb.leetcode.linkedlist.reverseNodesInkGroup;

import org.junit.Before;
import org.junit.Test;
import org.sherlockyb.leetcode.linkedlist.ListNode;

/**
 * Created by yangbing on 2018/7/19.
 */
public class SolutionTest {

    private Solution solution;

    @Before
    public void setup() {
        this.solution = new Solution();
    }

    @Test
    public void testReverseKGroup() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        head = this.solution.reverseKGroup(head, 2);

        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
