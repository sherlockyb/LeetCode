package org.sherlockyb.leetcode.array.threeSum_15;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by yangbing on 2017/4/20.
 */
public class SolutionTest {
    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void threeSum() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }
}
