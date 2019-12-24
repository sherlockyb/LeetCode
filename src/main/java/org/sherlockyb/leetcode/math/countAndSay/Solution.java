package org.sherlockyb.leetcode.math.countAndSay;

public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }

        String result = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char cur = result.charAt(0);
        int count = 1;
        for (int i = 1; i < result.length(); i++) {
            if (result.charAt(i) != cur) {
                sb.append(count).append(cur);
                cur = result.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count).append(cur);

        return sb.toString();
    }
}
