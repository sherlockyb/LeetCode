package org.sherlockyb.leetcode.linkedlist.reverseNodesInkGroup;

import org.sherlockyb.leetcode.linkedlist.ListNode;

/**
 * Created by yangbing on 2018/7/20.
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 0) {
            throw new RuntimeException("invalid k");
        }
        if (k <= 1) {
            return head;
        }
        ListNode p =  head;
        ListNode kthNode = reachKthNode(p, k);
        ListNode headPrefix = null;
        if (kthNode == null) {
            return p;
        }
        // 保留第一次交换后的头结点
        ListNode newHead = kthNode;
        ListNode tailSuffix;
        while (kthNode != null) {
            tailSuffix = kthNode.next;
            reverseSubLinkedList(p, kthNode, headPrefix);
            // 易错点：容易赋值为kthNode，而忽略了此时p->...>kthNode子链表已经倒序，p才是下一个子链表的前置节点
            headPrefix = p;
            p = tailSuffix;
            kthNode = reachKthNode(p, k);
        }
        return newHead;
    }

    private ListNode reachKthNode(ListNode head, int k) {
        int len = 0;
        while (head != null) {
            len++;
            if (len >= k) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 将指定的子链表反序
     * @param head 链表首节点A, NotNull
     * @param tail 链表尾节点B, NotNull
     * @param headPrefix 节点A的前置节点
     */
    private void reverseSubLinkedList(ListNode head, ListNode tail, ListNode headPrefix) {
        if (head == null || tail == null) {
            throw new IllegalArgumentException("invalid head or tail");
        }
        ListNode tailSuffix = tail.next;
        ListNode p1 = head;
        ListNode p2 = head.next;

        ListNode p3 = null;
        while (p1 != tail) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = tailSuffix;
        if (headPrefix != null) {
            headPrefix.next = p1;
        }
    }
}