package org.sherlockyb.leetcode.string.longestCommonPrefix;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by yangbing on 2017/4/12.
 */
public class SolutionTest {
    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void longestPalindrome() {
        System.out.println(solution.longestCommonPrefix(new String[] {"abc", "abeee", ""}));
    }

    @Test
    public void longestPalindrome2() {
        System.out.println(solution.longestCommonPrefix(new String[] {"abc", "abeee", "e"}));
    }
}
