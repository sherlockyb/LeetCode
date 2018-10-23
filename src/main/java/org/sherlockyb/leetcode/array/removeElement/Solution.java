package org.sherlockyb.leetcode.array.removeElement;

/**
 * Created by yangbing on 2018/10/23.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null) return 0;
        int newIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[newIdx++] = nums[i];
        }
        return newIdx;
    }
}
