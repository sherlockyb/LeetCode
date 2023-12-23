package org.sherlockyb.leetcode.math.palindromeNumber_9;

/**
 * Created by yangbing on 2017/4/6.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int reverse = 0, oneValue;
        int temp = x;
        while (temp > 0) {
            oneValue = temp % 10;
            if (reverse > Integer.MAX_VALUE / 10 || reverse*10 > Integer.MAX_VALUE - oneValue) {
                return false;
            }
            reverse = reverse*10 + oneValue;
            temp /= 10;
        }
        if (x == reverse) {
            return true;
        }

        return false;
    }
}
