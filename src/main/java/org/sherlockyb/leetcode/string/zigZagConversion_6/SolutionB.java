package org.sherlockyb.leetcode.string.zigZagConversion_6;

/**
 * Created by yangbing on 2017/4/4.
 */
public class SolutionB {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 0 || numRows <= 0) {
            return "";
        }
        if (numRows == 1)
            return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        int curRow = 0;
        boolean down = true;            //default move direction
        for (int i = 0; i < s.length(); i++) {
            if (rows[curRow] == null) {
                rows[curRow] = new StringBuilder();
            }
            if (curRow == numRows-1) {
                down = false;
            }
            if (curRow == 0) {
                down = true;
            }
            rows[curRow].append(s.charAt(i));
            curRow += down? 1: -1;
        }

        StringBuilder result = new StringBuilder(s.length());
        for (StringBuilder sBuilder: rows) {
            if (sBuilder == null) {
                // rest rows have not be reached
                break;
            }
            result.append(sBuilder);
        }
        return new String(result);
    }
}
