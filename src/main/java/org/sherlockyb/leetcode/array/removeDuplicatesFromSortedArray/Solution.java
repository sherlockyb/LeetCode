package org.sherlockyb.leetcode.array.removeDuplicatesFromSortedArray;

/**
 * Created by yangbing on 2018/10/22.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) {
            return nums.length;
        }
        int newIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[newIdx] == nums[i]) {
                continue;
            }
            nums[++newIdx] = nums[i];
        }
        return newIdx + 1;
    }
}
