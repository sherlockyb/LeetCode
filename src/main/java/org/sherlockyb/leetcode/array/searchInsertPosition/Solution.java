package org.sherlockyb.leetcode.array.searchInsertPosition;

/**
 * @author yangbing
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int index = find(nums, 0, nums.length-1, target);
        if (index < 0) {
            return -index;
        } else {
            return index;
        }
    }

    private int find(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -start;
        }

        int midpoint = (start + end) / 2;
        if (target < nums[midpoint]) {
            return find(nums, start, midpoint - 1, target);
        } else if (target == nums[midpoint]) {
            return midpoint;
        } else {
            return find(nums, midpoint + 1, end, target);
        }
    }
}