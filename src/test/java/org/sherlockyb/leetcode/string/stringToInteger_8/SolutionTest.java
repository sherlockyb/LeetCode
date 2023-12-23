package org.sherlockyb.leetcode.string.stringToInteger_8;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yangbing on 2017/4/4.
 */
public class SolutionTest {
    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void myAtoi() {
        String s = "123";
       Assert.assertEquals(123, solution.myAtoi(s));

        String s2 = "-13242";
        Assert.assertEquals(-13242, solution.myAtoi(s2));
    }

    @Test
     public void myAtoi2() {
        String s = "-2147483648";
        Assert.assertEquals(-2147483648, solution.myAtoi(s));

        String s2 = "2147483647";
        Assert.assertEquals(2147483647, solution.myAtoi(s2));
    }

    @Test
    public void myAtoi3() {
        String s = "-2147483649";
        Assert.assertEquals(-2147483648, solution.myAtoi(s));
    }

    @Test
    public void myAtoi4() {
        String s = "  -01033efegeageaa fewfaa1131313";
        Assert.assertEquals(-1033, solution.myAtoi(s));
    }
}
