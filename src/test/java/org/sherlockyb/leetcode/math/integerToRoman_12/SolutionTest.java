package org.sherlockyb.leetcode.math.integerToRoman_12;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yangbing on 2017/4/10.
 */
public class SolutionTest {
    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void intToRoman() {
        int num = 123;
        System.out.println(solution.intToRoman(num));
        Assert.assertEquals("CXXIII", solution.intToRoman(num));
    }

    @Test
    public void intToRoman2() {
        int num = 999;
        System.out.println(solution.intToRoman(num));
        Assert.assertEquals("CMXCIX", solution.intToRoman(num));
    }

    @Test
    public void intToRoman3() {
        int num = 1;
        System.out.println(solution.intToRoman(num));
        Assert.assertEquals("I", solution.intToRoman(num));
    }
}
