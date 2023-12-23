package org.sherlockyb.leetcode.array.nextPermutation_31;

import java.util.Arrays;

/**
 * Created by yangbing on 2018/11/6.
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int range_end = nums.length-1;
        int range_start = 0;
        int final_end = -1, final_start = -1;
        while (range_end >= 1 && range_start <= nums.length - 1 && range_end > range_start) {
            int tmpStart = range_end-1;
            boolean find = false;
            while (tmpStart >= range_start) {
                if (nums[range_end] > nums[tmpStart]) {
                    final_end = range_end;
                    final_start = tmpStart;
                    range_end--;
                    range_start = tmpStart + 1;
                    find = true;
                    break;
                } else {
                    tmpStart--;
                }
            }
            if (!find) {
                range_end--;
            }
        }
        if (final_end == -1) {
            // 没找到后者比前者大的数字对，说明原列表是降序，返回原列表的逆序
            for (int i = 0, j = nums.length-1; i < j; i++, j--) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        } else {
            int tmp = nums[final_end];
            nums[final_end] = nums[final_start];
            nums[final_start] = tmp;
            // 将final_end之后的子序列调整为升序，使其最小
            Arrays.sort(nums, final_start+1, nums.length);
        }
    }
}
