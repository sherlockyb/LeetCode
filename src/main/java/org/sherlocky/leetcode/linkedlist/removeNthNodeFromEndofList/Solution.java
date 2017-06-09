package org.sherlocky.leetcode.linkedlist.removeNthNodeFromEndofList;

import org.sherlocky.leetcode.linkedlist.ListNode;

import java.util.Stack;

/**
 * Created by yangbing on 2017/6/7.
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        // 出栈
        int i = 0;
        p = null;
        while (!stack.empty()) {
            i++;
            ListNode curNode = stack.pop();
            if (i == n) continue;
            curNode.next = p;
            p = curNode;
        }
        return p;
    }
}
