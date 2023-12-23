package org.sherlockyb.leetcode.linkedlist.mergekSortedLists_22;

import org.sherlockyb.leetcode.linkedlist.ListNode;

import java.util.Arrays;

/**
 * Created by yangbing on 2017/8/13.
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return new ListNode(-1);
        }
        if (lists.length == 1) return lists[0];

        if (lists.length % 2 == 0) {
            ListNode subList1 = mergeKLists(Arrays.copyOfRange(lists, 0, lists.length/2));
            ListNode subList2 = mergeKLists(Arrays.copyOfRange(lists, lists.length/2, lists.length));
            return mergeTwoLists(subList1, subList2);
        } else {
            ListNode subList1 = mergeKLists(Arrays.copyOfRange(lists, 0, (lists.length-1)/2));
            ListNode subList2 = mergeKLists(Arrays.copyOfRange(lists, (lists.length-1)/2, (lists.length-1)));
            return mergeTwoLists(lists[lists.length-1], mergeTwoLists(subList1, subList2));
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
