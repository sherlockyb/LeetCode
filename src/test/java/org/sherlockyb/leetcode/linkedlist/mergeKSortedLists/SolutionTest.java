package org.sherlockyb.leetcode.linkedlist.mergeKSortedLists;

import org.junit.Before;
import org.junit.Test;
import org.sherlockyb.leetcode.linkedlist.ListNode;
import org.sherlockyb.leetcode.linkedlist.mergekSortedLists.Solution;

/**
 * Created by yangbing on 2017/8/13.
 */
public class SolutionTest {
    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void mergeKLists() {
        ListNode list1 = new ListNode(1);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(5);
        list1.next = node12;
        node12.next = node13;

        ListNode list2 = new ListNode(2);
        ListNode list22 = new ListNode(6);
        ListNode list23 = new ListNode(8);
        list2.next = list22;
        list22.next = list23;

        // 输出合并结果
        ListNode p1 = solution.mergeKLists(new ListNode[] {list1, list2});
        while (p1 != null) {
            System.out.print(p1.val + " ");
            p1 = p1.next;
        }
        System.out.println();
    }

    @Test
    public void mergeKLists2() {
        ListNode list1 = new ListNode(1);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(5);
        list1.next = node12;
        node12.next = node13;

        ListNode list2 = new ListNode(2);
        ListNode list22 = new ListNode(6);
        ListNode list23 = new ListNode(8);
        list2.next = list22;
        list22.next = list23;

        ListNode list3 = new ListNode(4);
        ListNode list32 = new ListNode(7);
        ListNode list33 = new ListNode(9);
        list3.next = list32;
        list32.next = list33;
        ListNode p1 = solution.mergeKLists(new ListNode[] {list1, list2, list3});
        // 输出合并结果
        while (p1 != null) {
            System.out.print(p1.val + " ");
            p1 = p1.next;
        }
        System.out.println();
    }
}
