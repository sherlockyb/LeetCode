package org.sherlockyb.leetcode.string.stringToInteger_8;

/**
 * Created by yangbing on 2017/4/4.
 */
public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        // remove whitespace
        str = str.trim();

        boolean negative = false;
        int start = 0;
        if (str.startsWith("-")) {
            negative = true;
            start = 1;
        } else if (str.startsWith("+")) {
            negative = false;
            start = 1;
        }
        int prev, result = 0;
        int charValue;
        for (; start < str.length(); start++) {
            char curChar = str.charAt(start);
            if (curChar < '0' || curChar > '9') {
                break;
            }
            prev = result;
            result *= 10;
            if (result/10 != prev) {
                String errorMsg = negative ? "underflow": "overflow";
//                throw new RuntimeException(errorMsg);
                return negative ? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
            charValue = curChar - '0';
            if (negative && result*-1 < Integer.MIN_VALUE + charValue) {
//                throw new RuntimeException("underflow");
                return Integer.MIN_VALUE;
            }
            if (!negative && result > Integer.MAX_VALUE - charValue) {
//                throw new RuntimeException("overflow");
                return Integer.MAX_VALUE;
            }
            result += charValue;
        }

        return negative? result*(-1): result;
    }
}
