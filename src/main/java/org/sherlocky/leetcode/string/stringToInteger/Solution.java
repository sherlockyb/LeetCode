package org.sherlocky.leetcode.string.stringToInteger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yangbing on 2017/4/4.
 */
public class Solution {
    private  static Pattern pattern = Pattern.compile("^[ ]*[-+]?[0-9]*[\\s]*");

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        // valid regal
        Matcher m = pattern.matcher(str);
        if (!m.find()) {
//            throw new IllegalArgumentException("invalid format input: " + str);
            return 0;
        }
        // remove whitespace
        str = str.replaceAll("\\s*", "");

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
            prev = result;
            result *= 10;
            if (result/10 != prev) {
                String errorMsg = negative ? "underflow": "overflow";
//                throw new RuntimeException(errorMsg);
                return negative ? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
            charValue = str.charAt(start) - '0';
            if (negative && result > Integer.MIN_VALUE*-1 - charValue) {
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
