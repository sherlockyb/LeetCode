package org.sherlockyb.leetcode.array.threeSumClosest_16;

import java.util.Arrays;

/**
 * Created by yangbing on 2017/5/2.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int closestSum = 0;
        int diffAbs = Integer.MAX_VALUE;
        int curDiffAbs = diffAbs;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    return target;
                }
                curDiffAbs = Math.abs(sum - target);
                if (curDiffAbs < diffAbs) {
                    diffAbs = curDiffAbs;
                    closestSum = sum;
                }
            }
        }

        return closestSum;
    }
}
