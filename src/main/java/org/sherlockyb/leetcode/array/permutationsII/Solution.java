package org.sherlockyb.leetcode.array.permutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sherlockyb
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return Collections.emptyList();
        }

        // 先排序，让相同的元素靠在一起，这样当处理待交换元素之间的重复情况时，只需要判断相邻元素即可
        Arrays.sort(nums);

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
            if (i != start && (nums[start] == nums[i] || nums[i] == nums[i - 1])) {
                /**
                 * 对于重复的 M 个元素，放入同一位置并不能产生新的排列，只需选一个放入一次，需要忽略其余 M-1 个相同元素填充该位置所产生的所有排列
                 * 元素重复有两种情况：
                 * 1. 当前start位置的元素与后续待交换的元素有重复，直接用 nums[start] == nums[i] 判断即可
                 * 2. 后续待交换元素，相互之间有重复，用 nums[i] == nums[i - 1] 来判断start位置之后的序列是否有重复元素的前提是整个序列是有序的，这样相同元素才会相邻，
                 *    所以才需要在最开始sort一下
                 */

                // continue;     // 不能直接continue，不然会影响回溯：一旦有元素跳过了下面的交换，那么回溯到上层时，nums就无法恢复成最初的序列
                currentExistDuplication = true;
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
