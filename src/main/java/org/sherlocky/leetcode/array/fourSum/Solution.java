package org.sherlocky.leetcode.array.fourSum;

import java.util.*;

/**
 * Created by yangbing on 2017/6/7.
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        // 先排好序
        Arrays.sort(nums);

        // 用于判重
        Set<Integer> firstExistNumbers = new HashSet<>();
        Set<Integer> secondExistNumbers = new HashSet<>();
        Set<Integer> thirdExistNumbers = new HashSet<>();
        Set<Integer> forthExistNumbers = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (firstExistNumbers.contains(nums[i])) {
                continue;
            }
            firstExistNumbers.add(nums[i]);
            int threeSum = target - nums[i];
            secondExistNumbers.clear();
            for (int j = i+1; j < nums.length - 2; j++) {
                if (secondExistNumbers.contains(nums[j])) {
                    continue;
                }
                secondExistNumbers.add(nums[j]);
                int twoSum = threeSum - nums[j];
                int k = j+1, m = nums.length-1;
                int sum = 0;
                thirdExistNumbers.clear();
                forthExistNumbers.clear();
                while (k < m) {
                    sum = nums[k] + nums[m];
                    if (sum == twoSum) {
                        if (thirdExistNumbers.contains(nums[k])) {
                            k++;
                            continue;
                        }
                        if (forthExistNumbers.contains(nums[m])) {
                            m--;
                            continue;
                        }
                        thirdExistNumbers.add(nums[k]);
                        forthExistNumbers.add(nums[m]);
                        List<Integer> quad = new ArrayList<>(4);
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[k]);
                        quad.add(nums[m]);
                        result.add(quad);
                        k++;
                        m--;
                    } else if (sum < twoSum) {
                        k++;
                    } else {
                        m--;
                    }
                }
            }
        }

        return result;
    }
}
