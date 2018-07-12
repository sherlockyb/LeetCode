package org.sherlockyb.leetcode.linkedlist.addTwoNumbers;

import org.sherlockyb.leetcode.linkedlist.ListNode;


/**
 * Created by yangbing on 2017/3/30.
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode rPrev = result;
        ListNode rCurrent = result;
        int carry = 0;
        while (l1 != null && l2 != null) {
            if (rCurrent == null) {
                rCurrent = new ListNode(0);
                rPrev.next = rCurrent;
            }
            int sum = l1.val + l2.val + carry;
            carry = 0;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            }
            rCurrent.val = sum;
            l1 = l1.next;
            l2 = l2.next;
            rPrev = rCurrent;
            rCurrent = rCurrent.next;
        }

        ListNode rest = l1 == null ? l2: l1;
        while (rest != null) {
            if (rCurrent == null) {
                rCurrent = new ListNode(0);
                rPrev.next = rCurrent;
            }
            int sum = rest.val + carry;
            carry = 0;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            }
            rCurrent.val = sum;
            rest = rest.next;
            rPrev = rCurrent;
            rCurrent = rCurrent.next;
        }

        // last carry, easily to be ignored!
        if (carry > 0) {
            if (rCurrent == null) {
                rCurrent = new ListNode(0);
                rPrev.next = rCurrent;
            }
            rCurrent.val = carry;
        }

        return result;
    }
}
