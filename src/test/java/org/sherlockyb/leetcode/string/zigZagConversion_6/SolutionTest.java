package org.sherlockyb.leetcode.string.zigZagConversion_6;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yangbing on 2017/4/3.
 */
public class SolutionTest {
    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void convert() {
    	String s = "PAYPALISHIRING";
        System.out.println(solution.convert(s, 3));

        String s2 = "AB";
        Assert.assertEquals("AB", solution.convert(s2, 1));
    }

    @Test
    public void convert2() {
        String s = "PAYPALISHIRING";
        System.out.println(solution.convert(s, 4));
        Assert.assertEquals("PINALSIGYAHRPI", solution.convert(s, 4));

        String s2 = "PAYPAL";
        Assert.assertEquals("PALYAP", solution.convert(s2, 4));
    }
}
