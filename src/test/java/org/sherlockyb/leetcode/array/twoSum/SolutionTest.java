package org.sherlockyb.leetcode.array.twoSum;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yangbing on 2017/3/30.
 */
public class SolutionTest {
    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
     public void twoSum() {
        int[] nums = {2, 7, 11, 15};
//        int target = 22;
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }

    @Test
    public void twoSum2() {
        int[] nums = {3, 2, 4, 8};
        int target = 6;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
