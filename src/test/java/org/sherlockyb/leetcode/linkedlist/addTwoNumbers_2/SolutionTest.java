package org.sherlockyb.leetcode.linkedlist.addTwoNumbers_2;

import org.junit.Before;
import org.junit.Test;
import org.sherlockyb.leetcode.linkedlist.ListNode;

/**
 * Created by yangbing on 2017/3/30.
 */
public class SolutionTest {
    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void addTowNumbers() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);

        //construct list
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(3);
        l1.next = node12;
        node12.next = node13;

        ListNode node22 = new ListNode(6);
        ListNode node23 = new ListNode(4);
        l2.next = node22;
        node22.next = node23;

        ListNode result = solution.addTwoNumbers(l1, l2);
        ListNode p = result;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    @Test
    public void addTowNumbers1() {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);

        //construct list
        ListNode node12 = new ListNode(9);
        ListNode node13 = new ListNode(9);
        l1.next = node12;
        node12.next = node13;

        ListNode node22 = new ListNode(9);
        ListNode node23 = new ListNode(9);
        ListNode node24 = new ListNode(9);
        l2.next = node22;
        node22.next = node23;
        node23.next = node24;

        ListNode result = solution.addTwoNumbers(l1, l2);
        ListNode p = result;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
