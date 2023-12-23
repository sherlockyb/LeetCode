package org.sherlockyb.leetcode.math.romanToInteger_13;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yangbing on 2017/4/11.
 */
public class SolutionTest {
    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void romanToInt() {
        String s = "DCXXI";
        System.out.println(solution.romanToInt(s));
        Assert.assertEquals(621, solution.romanToInt(s));
    }

    @Test
    public void romanToInt2() {
        String s = "MCMXCVI";
        System.out.println(solution.romanToInt(s));
        Assert.assertEquals(1996, solution.romanToInt(s));
    }

    @Test
    public void romanToInt3() {
        String s = "MMMCDXII";
        System.out.println(solution.romanToInt(s));
        Assert.assertEquals(3412, solution.romanToInt(s));
    }
}
