package org.sherlocky.leetcode.array.medianOfTwoSortedArrays;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yangbing on 2017/4/2.
 */
public class SolutionTest {
    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void findMedianSortedArrays() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
     public void findMedianSortedArrays2() {
        int[] nums1 = {1};
        int[] nums2 = {1};

        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void findMedianSortedArrays3() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
