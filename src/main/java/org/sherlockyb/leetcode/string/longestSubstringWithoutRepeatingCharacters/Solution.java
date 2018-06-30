package org.sherlockyb.leetcode.string.longestSubstringWithoutRepeatingCharacters;

/**
 * @author yangbing
 * @version 1.0.0
 * @since 2017-4-1
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int maxL = -1;
        int start = 0, end = 0, cursor = 1;
        while (cursor < s.length()) {
            boolean exist = false;
            int i = start;
            for (; i <= end; i++) {
                if (s.charAt(cursor) == s.charAt(i)) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                end++;
            } else {
                start = i + 1;
                end = cursor;
            }
            cursor++;
            int curL = end - start + 1;
            maxL = curL > maxL ? curL : maxL;
        }

        return maxL;
    }
}
