package org.sherlockyb.leetcode.math.LetterCombinationOfPhoneNumber_17;

import java.util.*;

/**
 * Created by yangbing on 2017/6/5.
 */
public class Solution {

    private static final Map<Character, String> digitToNumbers = new HashMap<>();

    static {
        digitToNumbers.put('1', "@");
        digitToNumbers.put('2', "abc");
        digitToNumbers.put('3', "def");
        digitToNumbers.put('4', "ghi");
        digitToNumbers.put('5', "jkl");
        digitToNumbers.put('6', "mno");
        digitToNumbers.put('7', "pqrs");
        digitToNumbers.put('8', "tuv");
        digitToNumbers.put('9', "wxyz");
        digitToNumbers.put('0', " ");
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return Collections.emptyList();
        }
        if (digits.contains("1") || digits.contains("0")) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        permutation(digits, 0, sb, result);

        return result;
    }

    private void permutation(String digits, int level, StringBuilder sb,List<String> result) {
        if (level >= digits.length()) {
            return ;
        }
        String numbers = digitToNumbers.get(digits.charAt(level));
        for (int i = 0; i < numbers.length(); i++) {
            sb.append(numbers.charAt(i));
            if (level == digits.length()-1) {
                result.add(sb.toString());
            } else {
                permutation(digits, level+1, sb, result);
            }
            sb.deleteCharAt(level);
        }
    }
}
