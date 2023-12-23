package org.sherlockyb.leetcode.string.longestPalindromicSubstring_5;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by yangbing on 2017/4/2.
 */
public class SolutionTest {
    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void longestPalindrome() {
//    	String s = "a";
//    	String s = "aa";
    	String s = "bbbbb";
//    	String s = "pwwkew";
//        String s = "babad";
        System.out.println(solution.longestPalindrome(s));
    }
}
