package org.sherlockyb.leetcode.array.searchInRotatedSortedArray;

import java.util.Arrays;

/**
 * Created by yangbing on 2018/11/17.
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0: -1;
        }
        // nums.length >= 2
        int pivot = locatePivot(nums, 0, nums.length-1);
        int result;
        if (pivot == -1) {
            result = Arrays.binarySearch(nums, target);
            return result >= 0 ? result: -1;
        }
        int leftIdx = Arrays.binarySearch(nums, 0, pivot, target);
        if (leftIdx >= 0) {
            return leftIdx;
        }

        int rightIdx = Arrays.binarySearch(nums, pivot, nums.length, target);
        if (rightIdx < 0) {
            return -1;
        }
        return rightIdx;
    }

    public int locatePivot(int[] nums, int start, int end) {
        if (end == start + 1) {
            // 只包含两个元素
            return nums[start] < nums[end] ? -1: end;
        }
        int midpoint = (start + end + 1) / 2;
        if (nums[start] < nums[midpoint]) {
            return locatePivot(nums, midpoint, end);
        } else {
            return locatePivot(nums, start, midpoint);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5, 1, 2, 3, 4};
        System.out.println(new Solution().locatePivot(nums, 0, nums.length-1));
        System.out.println(new Solution().search(nums, 2));
    }
}
