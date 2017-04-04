package org.sherlocky.leetcode.math.reverseInteger;

/**
 * Created by yangbing on 2017/4/4.
 */
public class Solution {
    public int reverse(int x) {
        if (x == 0){
            return 0;
        }
        String str = Integer.toString(x);
        int start = 0;
        StringBuilder sBuilder = new StringBuilder(str.length());
        if (str.startsWith("-")) {
            start = 1;
            sBuilder.append("-");
        }
        for (int i = str.length()-1; i >= start; i--) {
            sBuilder.append(str.charAt(i));
        }
        String result = sBuilder.toString();

        // valid range
        String maxStr = Integer.toString(Integer.MAX_VALUE);
        String minStr = Integer.toString(Integer.MIN_VALUE);
        StringBuilder alignStr = new StringBuilder(minStr.length());
        if (result.startsWith("-")) {
            for (int i = 0, j = 1; i < minStr.length(); i++) {
                if (i == 0) {
                    alignStr.append("-");
                } else if (i < 1 + minStr.length() - result.length()) {
                    alignStr.append("0");
                } else {
                    alignStr.append(result.charAt(j++));
                }
            }
            if (minStr.compareTo(alignStr.toString()) < 0) {
                return 0;
            }
        } else {
            for (int i = 0, j = 0; i < maxStr.length(); i++) {
                if (i < maxStr.length() - result.length()) {
                    alignStr.append("0");
                } else {
                    alignStr.append(result.charAt(j++));
                }
            }
            if (maxStr.compareTo(alignStr.toString()) < 0) {
                return 0;
            }
        }

        return Integer.valueOf(result);
    }
}
