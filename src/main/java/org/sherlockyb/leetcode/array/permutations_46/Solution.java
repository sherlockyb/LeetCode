package org.sherlockyb.leetcode.array.permutations_46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sherlockyb
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        final List<List<Integer>> results = new ArrayList<>();
        resolver(nums, 0, results);

        return results;
    }

    /***
     * @param nums 原数组
     * @param start 当前填充的位置
     * @param results 可变更的最终结果
     */
    private void resolver(final int[] nums, int start, final List<List<Integer>> results) {
        if (start >= nums.length) {
            return;
        }
        if (start == nums.length - 1) {
            results.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);                       // 将元素nums[i]放置到start位置
            resolver(nums, start + 1, results);    // 继续填充后续位置
            /**
             * 回溯，将最初 start 位置的元素归位。但实际上这一步并不是必要的，只要确保[start, nums.length-1] 之间每个元素都往 start 位置放置过一次就是OK的，而nums数组
             * 最初 start 位置的元素被置换到哪了，并不重要
             */
            swap(nums, start, i);
        }
    }

    private void swap(final int[] nums, final int origin, final int dest) {
        int temp = nums[origin];
        nums[origin] = nums[dest];
        nums[dest] = temp;
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int[] nums1 = new int[] {1};
        final int[] nums2 = new int[] {1, 2};
        final int[] nums3 = new int[] {1, 2, 3};
        final int[] nums4 = new int[] {1, 2, 3, 4};

        System.out.println(solution.permute(nums1));
        System.out.println(solution.permute(nums2));
        System.out.println(solution.permute(nums3));
        System.out.println(solution.permute(nums4));
    }
}
