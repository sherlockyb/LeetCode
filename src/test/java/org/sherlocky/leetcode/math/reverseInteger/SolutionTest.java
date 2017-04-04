package org.sherlocky.leetcode.math.reverseInteger;

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
    public void reverse() {
        int x = 123;
        System.out.println(solution.reverse(x));
        Assert.assertEquals(321, solution.reverse(x));

        int x2 = -123;
        System.out.println(solution.reverse(x2));
        Assert.assertEquals(-321, solution.reverse(x2));
    }

    @Test
    public void reverse2() {
        int x = 2147483647;
        System.out.println(solution.reverse(x));
        Assert.assertEquals(0, solution.reverse(x));

        int x2 = -2147483648;
        System.out.println(solution.reverse(x2));
        Assert.assertEquals(0, solution.reverse(x2));
    }
}
