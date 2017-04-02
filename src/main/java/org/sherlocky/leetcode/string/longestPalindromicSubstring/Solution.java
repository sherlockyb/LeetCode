package org.sherlocky.leetcode.string.longestPalindromicSubstring;

/**
 * Created by yangbing on 2017/4/2.
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int maxL = -1, curL;
        int maxIdxS = 0, maxIdxE = 0;
        int step;
        for (int i = 0; i < s.length(); i++) {
            // odd plalindrome
            step = 0;
            while (i-step >=0 && i+step < s.length()) {
                if (s.charAt(i-step) == s.charAt(i+step)) {
                    step++;
                } else {
                    break;
                }

            }
            curL = (step-1)*2 + 1;
            if (curL > maxL) {
                maxIdxS = i-(step-1);
                maxIdxE = i+step-1;
                maxL = curL;
            }

            // even plalindrome
            step = 0;
            while (i-step >= 0 && i+step+1 < s.length()) {
                if (s.charAt(i-step) == s.charAt(i+step+1)) {
                    step++;
                } else {
                    break;
                }
            }
            curL = step*2;
            if (curL > maxL) {
                maxIdxS = i-(step-1);
                maxIdxE = i+step;
                maxL = curL;
            }
        }

        return s.substring(maxIdxS, maxIdxE+1);
    }
}
