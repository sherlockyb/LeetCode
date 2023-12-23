package org.sherlockyb.leetcode.array.firstMissingPositive_41;

import java.util.Arrays;

/**
 * @author biyang
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int notExistDefaultValue = -1;
        int minPositiveNumber = Arrays.stream(nums).filter(value -> value > 0)
            .min().orElse(notExistDefaultValue);

        if (minPositiveNumber == notExistDefaultValue || minPositiveNumber > 1) {
            return 1;
        }

        int i = 0;
        while (i < nums.length){
            if (nums[i] <= 0 || nums[i] > nums.length) {
                i++;
                continue;
            }

            if (nums[i]-1 != i && nums[i] != nums[nums[i]-1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i+1;
            }
        }

        return nums.length+1;
    }
}
