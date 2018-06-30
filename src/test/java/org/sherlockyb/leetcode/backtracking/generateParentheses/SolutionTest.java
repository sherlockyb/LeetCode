package org.sherlockyb.leetcode.backtracking.generateParentheses;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by yangbing on 2017/7/30.
 */
public class SolutionTest {
    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void generateParenthesis() {
        System.out.println("3:" + solution.generateParenthesis(3));
        System.out.println("4: " + solution.generateParenthesis(4));
    }
}
