package org.sherlockyb.leetcode.string.implementStrStr;

/**
 * Created by yangbing on 2018/10/25.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if ("".equals(haystack)) {
            return -1;
        }
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            boolean find = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    find = false;
                    break;
                }
            }
            if (find) {
                return i;
            }
        }
        return -1;
    }
}
