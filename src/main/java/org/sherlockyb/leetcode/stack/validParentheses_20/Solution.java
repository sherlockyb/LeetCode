package org.sherlockyb.leetcode.stack.validParentheses_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by yangbing on 2017/6/12.
 */
public class Solution {
    private static final Map<Character, Character> pair = new HashMap<>();
    static {
        pair.put(')', '(');
        pair.put('}', '{');
        pair.put(']', '[');
    }
    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char ch, preCh;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch); break;
                case ')':
                case '}':
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    preCh = stack.peek();
                    if (preCh == pair.get(ch)) {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                    break;
                default: stack.push(ch);
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
