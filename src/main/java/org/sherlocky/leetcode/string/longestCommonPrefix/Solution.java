package org.sherlocky.leetcode.string.longestCommonPrefix;

/**
 * Created by yangbing on 2017/4/12.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sBuilder = new StringBuilder();
        int idx = 0;
        char curCh;
        boolean same;
        boolean shouldBreak = false;
        while (true) {
            if (idx >= strs[0].length()) {
                break;
            }
            curCh = strs[0].charAt(idx);
            same = true;
            for (int i = 1; i < strs.length; i++) {
                if (idx >= strs[i].length() || curCh != strs[i].charAt(idx)) {
                    same = false;
                    shouldBreak = true;
                    break;
                }
            }
            if (same) {
                sBuilder.append(curCh);
            }
            idx++;
            if (shouldBreak) {
                break;
            }
        }

        return sBuilder.toString();
    }
}
