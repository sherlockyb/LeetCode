package org.sherlockyb.leetcode.string.implementStrStr;

/**
 * Created by yangbing on 2018/10/25.
 */
public class SolutionKmp {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if ("".equals(haystack)) {
            return -1;
        }
        int[] nexts = getNexts(needle);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = nexts[j];
                while (j >= 0) {
                    if (haystack.charAt(i) == needle.charAt(j)) {
                        i++;
                        j++;
                        break;
                    }
                    j = nexts[j];
                }
                if (j == -1) {
                    j = 0;
                    i++;
                }
            }
        }
        if (j == needle.length()) {
            return i-j;
        }
        return -1;
    }

    private int[] getNexts(String needle) {
        int[] nexts = new int[needle.length()];
        nexts[0] = -1;
        for (int i = 1; i < nexts.length; i++) {
            if (i == 1) {
                nexts[i] = 0;
                continue;
            }
            int k = nexts[i-1];
            if (needle.charAt(i-1) == needle.charAt(k)) {
                nexts[i] = k + 1;
            } else {
                // 在子串i~k中，找最长匹配
                do {
                    k = nexts[k];
                    if (k == -1) {
                        nexts[i] = 0;
                        break;
                    }
                    if (needle.charAt(i-1) == needle.charAt(k)) {
                        nexts[i] = k + 1;
                        break;
                    }
                } while (k >=-1);
            }
        }
        return nexts;
    }
}
