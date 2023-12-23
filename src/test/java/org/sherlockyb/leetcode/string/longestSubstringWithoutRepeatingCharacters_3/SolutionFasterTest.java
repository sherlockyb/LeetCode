package org.sherlockyb.leetcode.string.longestSubstringWithoutRepeatingCharacters_3;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yangbing
 * @since 2017-4-1
 * @version 1.0.0
 */
public class SolutionFasterTest {
	private SolutionFaster solutionFaster;

    @Before
    public void setup(){
    	solutionFaster = new SolutionFaster();
    }

    @Test
    public void lengthOfLongestSubstring() {
//    	String s = "pp";
//    	String s = "abcabcbb";
//    	String s = "bbbbb";
//    	String s = "pwwkew";
    	String s = "becwefb";
    	System.out.println(solutionFaster.lengthOfLongestSubstring(s));
    }
}
