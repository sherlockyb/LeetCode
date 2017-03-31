package org.sherlocky.leetcode.array.twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yb on 2017/3/30.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return null;

        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer diff = target - nums[i];
            Integer idx = numToIndex.get(diff);
            if (idx != null && idx != i) {
                int[] result = new int[2];
                result[0] = i;
                result[1] = idx;
                return result;
            }

        }
        return null;
    }
}
