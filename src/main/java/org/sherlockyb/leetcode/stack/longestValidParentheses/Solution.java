package org.sherlockyb.leetcode.stack.longestValidParentheses;

/**
 * Created by yangbing on 2018/11/12.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        if (s.length() == 2) {
            return s.equals("()") ? 2:0;
        }
        if (s.charAt(s.length()-1) == '(') {
            return longestValidParentheses(s.substring(0, s.length()-1));
        }
        // 最长合法括号包含最后一个字符，与不包含最后一个字符，两者取较大
        return Math.max(longestValidParentheses(s.substring(0, s.length()-1)), containEndMaxLen(s));
    }

    /**
     * 进入此函数的s，必须以')'结尾，否则直接返回0
     * @param s
     * @return
     */
    private int containEndMaxLen(String s) {
        if (s.length() <= 1 || s.charAt(s.length()-1) == '(') {
            return 0;
        }
        if (s.charAt(s.length()-2) == '(') {
            return containEndMaxLen(s.substring(0, s.length()-2)) + 2;
        }
        int rightParenthesisNum = 2;
        int parenthesisPairNum = 0;
        for (int i = s.length()-3; i >= 0; i--) {
            switch (s.charAt(i)) {
                case '(':
                    rightParenthesisNum--;
                    parenthesisPairNum++;
                    if (rightParenthesisNum == 0) {
                        return containEndMaxLen(s.substring(0, s.length()-parenthesisPairNum*2)) + parenthesisPairNum*2;
                    }
                    break;
                case ')':
                    rightParenthesisNum++;
                    break;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        int a = new Solution().longestValidParentheses("(()()())");
        int a = new Solution().longestValidParentheses("))))((()((");
        System.out.println(a);
    }
}
