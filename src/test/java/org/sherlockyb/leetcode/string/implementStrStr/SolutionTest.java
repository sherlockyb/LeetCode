package org.sherlockyb.leetcode.string.implementStrStr;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by yangbing on 2017/4/12.
 */
public class SolutionTest {
    private Solution solution;
    private SolutionKmp solutionKmp;

    @Before
    public void setup(){
        solution = new Solution();
        solutionKmp = new SolutionKmp();
    }

    @Test
    public void strStrTest() {
        System.out.println(solution.strStr("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
    }

    @Test
    public void strStrKmpTest() {
        // System.out.println(solutionKmp.strStr("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
        System.out.println(solutionKmp.strStr("aabaaabaaac", "aabaaac"));
    }
}
