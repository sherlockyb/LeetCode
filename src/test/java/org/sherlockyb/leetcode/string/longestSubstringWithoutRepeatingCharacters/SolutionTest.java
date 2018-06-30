package org.sherlockyb.leetcode.string.longestSubstringWithoutRepeatingCharacters;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yangbing
 * @since 2017-4-1
 * @version 1.0.0
 */
public class SolutionTest {
	private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void lengthOfLongestSubstring() {
//    	String s = "pp";
//    	String s = "abcabcbb";
//    	String s = "bbbbb";
//    	String s = "pwwkew";
    	String s = "becwefb";
    	System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
