package org.sherlockyb.leetcode.array.permutationsII;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sherlockyb
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return Collections.emptyList();
        }

        final List<List<Integer>> results = new ArrayList<>();
        solver(nums, 0, results, false);
        return results;
    }

    private void solver(final int[] nums, int start, final List<List<Integer>> results, boolean prevExistDuplication) {
        if (start >= nums.length) {
            return;
        }
        if (start == nums.length - 1) {
            if (!prevExistDuplication) {
                results.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            boolean currentExistDuplication = false;
            if (i != start) {
                /**
                 * 对于重复的 M 个元素，放入同一位置并不能产生新的排列，只需选一个放入一次，需要忽略其余 M-1 个相同元素填充该位置所产生的所有排列
                 * 且不能直接continue来忽略 nums[i]，不然会影响回溯：一旦有元素跳过了下面的 swap，那么回溯到上层时，nums就无法恢复成最初的序列，故需要通过标志位
                 * 往下透传，在最后添加结果时过滤
                 */
                for (int j = start; j < i; j++) {
                    if (nums[i] == nums[j]) {
                        currentExistDuplication = true;
                        break;
                    }
                }

                // continue;
            }
            swap(nums, start, i);
            // 一旦 prevExistDuplication 为 true，即上层的递归出现重复，那么后续的子序列递归全部忽略；只有当上层递归没有重复元素时，当前层的判断才会影响下一代递归
            solver(nums, start + 1, results, prevExistDuplication || currentExistDuplication);
            swap(nums, start, i);
        }
    }

    private void swap(final int[] nums, int origin, int dest) {
        final int temp = nums[origin];
        nums[origin] = nums[dest];
        nums[dest] = temp;
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int[] nums1 = new int[] {2,2,1,1};
        final int[] nums2 = new int[] {1,1,1};
        final int[] nums3 = new int[] {2,1,1,3,1};
        final int[] nums4 = new int[] {-1,-1,0,0,1,1,2};
        System.out.println(solution.permuteUnique(nums1));
        System.out.println(solution.permuteUnique(nums2));
        System.out.println(solution.permuteUnique(nums3));
        System.out.println(solution.permuteUnique(nums4).size());
    }
}
