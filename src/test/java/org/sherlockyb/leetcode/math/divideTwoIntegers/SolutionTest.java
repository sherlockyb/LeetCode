package org.sherlockyb.leetcode.math.divideTwoIntegers;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by yangbing on 2018/11/1.
 */
public class SolutionTest {
    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void divide() {
        System.out.println(solution.divide(-2147483648, -1));
    }
}
