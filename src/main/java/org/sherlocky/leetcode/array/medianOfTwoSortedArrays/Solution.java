package org.sherlocky.leetcode.array.medianOfTwoSortedArrays;

import java.util.Arrays;

/**
 * Created by yangbing on 2017/4/2.
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedNums = mergeSortedArrays(nums1, nums2);
        if (mergedNums == null) {
            return 0;
        }
        if (mergedNums.length % 2 == 0) {
            return (mergedNums[mergedNums.length/2-1] + mergedNums[mergedNums.length/2]) / 2.0;
        } else {
            return mergedNums[mergedNums.length/2] * 1.0;
        }
    }

    private int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return nums2 == null ? null: Arrays.copyOf(nums2, nums2.length);
        }
        if (nums2 == null) {
            return nums1 == null ? null: Arrays.copyOf(nums1, nums1.length);
        }

        int[] mergedNums = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            mergedNums[k++] = nums1[i] <= nums2[j] ? nums1[i++]: nums2[j++];
        }
        while (i < nums1.length) {
            mergedNums[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            mergedNums[k++] = nums2[j++];
        }

        return mergedNums;
    }
}
