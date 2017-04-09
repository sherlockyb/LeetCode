package org.sherlocky.leetcode.string.regularExpressionMatching;

/**
 * Created by yangbing on 2017/4/8.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (p == null) {
            return s == null? true: false;
        }
        if ("".equals(p)) {
            return "".equals(s) ? true: false;
        }
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        } else {
            while (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
    }
}
