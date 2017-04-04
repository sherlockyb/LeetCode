package org.sherlocky.leetcode.string.zigZagConversion;

/**
 * Created by yangbing on 2017/4/3.
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 0 || numRows <= 0) {
            return "";
        }
        if (numRows == 1)
            return s;
        char[] result = new char[s.length()];
        int rIdx = 0;
        int headLetterIdx, step1, step2;
        for (int i = 0; i < numRows; i++) {
            headLetterIdx = i;
            step1 = numRows-i%(numRows-1)-1 + numRows-i%(numRows-1)-2 + 1;
            step2 = numRows-(numRows-1-i)%(numRows-1)-1 + numRows-(numRows-1-i)%(numRows-1)-2 + 1;

            boolean step1Flag = true;
            while (headLetterIdx < s.length()) {
                result[rIdx++] = s.charAt(headLetterIdx);
                if (step1Flag) {
                    headLetterIdx += step1;
                    step1Flag = false;
                } else {
                    headLetterIdx += step2;
                    step1Flag = true;
                }
            }
        }

        return new String(result);
    }
}
