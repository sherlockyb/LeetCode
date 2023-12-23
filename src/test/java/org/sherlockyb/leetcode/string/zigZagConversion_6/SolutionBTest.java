package org.sherlockyb.leetcode.string.zigZagConversion_6;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yangbing on 2017/4/4.
 */
public class SolutionBTest {
    private SolutionB solutionB;

    @Before
    public void setup(){
        solutionB = new SolutionB();
    }

    @Test
    public void convert() {
        String s = "PAYPALISHIRING";
        System.out.println(solutionB.convert(s, 3));

        String s2 = "AB";
        Assert.assertEquals("AB", solutionB.convert(s2, 1));

        String s3 = "A";
        Assert.assertEquals("A", solutionB.convert(s3, 1));
    }

    @Test
    public void convert2() {
        String s = "PAYPALISHIRING";
        System.out.println(solutionB.convert(s, 4));
        Assert.assertEquals("PINALSIGYAHRPI", solutionB.convert(s, 4));

        String s2 = "PAYPAL";
        Assert.assertEquals("PALYAP", solutionB.convert(s2, 4));
    }
}
