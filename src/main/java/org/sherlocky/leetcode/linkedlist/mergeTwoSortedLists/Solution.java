package org.sherlocky.leetcode.linkedlist.mergeTwoSortedLists;

import org.sherlocky.leetcode.linkedlist.ListNode;

/**
 * Created by yangbing on 2017/6/13.
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1, p2 = l2;
        ListNode result = new ListNode(-1);
        ListNode p3 = result;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        while (p1 != null) {
            p3.next = p1;
            p1 = p1.next;
            p3 = p3.next;
        }
        while (p2 != null) {
            p3.next = p2;
            p2 = p2.next;
            p3 = p3.next;
        }
        return result.next;
    }
}
