package org.sherlockyb.leetcode.linkedlist.swapNodesInPairs;

import org.sherlockyb.leetcode.linkedlist.ListNode;

/**
 * Created by yangbing on 2018/7/12.
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head.next;
        if (second == null) {
            return first;
        }
        ListNode swapFirst = first;             // 交换节点A
        ListNode swapSecond = second;           // 交换节点B
        ListNode swapSuffix = swapSecond.next;  // 交换节点的后置节点

        // 第一波交换
        swapFirst.next = swapSuffix;
        swapSecond.next = swapFirst;

        ListNode swapPrefix = swapFirst;        // 记录后续交换节点的初始前置节点
        ListNode newHead = swapSecond;          // 保存新链表的头结点

        // 探测后续交换的可能性
        while (swapSuffix != null) {
            swapFirst = swapSuffix;
            swapSecond = swapFirst.next;
            if (swapSecond == null) {
                // 是否有第二个交换节点，没有直接跳出
                break;
            }
            // 满足交换条件
            swapSuffix = swapSecond.next;
            swapFirst.next = swapSuffix;
            swapSecond.next = swapFirst;
            if (swapPrefix != null) {
                swapPrefix.next = swapSecond;
            }
            // 本轮的交换后的第二个节点，即是次轮交换的前置节点
            swapPrefix = swapFirst;
        }

        return newHead;
    }
}