package org.sherlocky.leetcode.array.threeSum;

import java.util.*;

/**
 * Created by yangbing on 2017/4/19.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        // 先排好序
        Arrays.sort(nums);
        // 重复的数字，取最后一个下标
        Map<Integer, Integer> numToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToIdx.put(nums[i], i);
        }
        int sum, diff;
        Integer idx;
        // 用于滤重：即数组中相同的多个数，只能有一个出现在和（sum）的位置
        Set<Integer> existSums = new HashSet<>();
        // 用于三元组判重
        Set<String> entrys = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (existSums.contains(nums[i])) {
                continue;
            }
            existSums.add(nums[i]);
            // 依次以每个元素的相反数作为和，去遍历结果
            sum = -1*nums[i];
            for (int j = i+1; j < nums.length; j++) {
                diff = sum - nums[j];
                idx = numToIdx.get(diff);
                if (idx != null && idx != i && idx > j) {
                    // find one
                    List<Integer> triplet = new ArrayList<>(3);
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(diff);
                    // 判重
                    if (entrys.contains(triplet.toString())) {
                        continue;
                    }
                    entrys.add(triplet.toString());
                    result.add(triplet);
                }
            }
        }

        return result;
    }
}
