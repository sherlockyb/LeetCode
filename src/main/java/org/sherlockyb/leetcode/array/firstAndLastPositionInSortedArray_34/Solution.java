package org.sherlockyb.leetcode.array.firstAndLastPositionInSortedArray_34;

/**
 * @author yangbing
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return new int[] {-1, -1};
        }

        int firstIdx = findFirstOrLast(nums, 0, nums.length-1, target, true);
        int lastIdx = findFirstOrLast(nums, 0, nums.length-1, target, false);

        return new int[] {firstIdx, lastIdx};
    }

    private int findFirstOrLast(int[] nums, int start, int end, int target, boolean first) {
        if (start > end) {
            return -1;
        }

        int midpoint = (start + end) / 2;
        if (target < nums[midpoint]) {
            return findFirstOrLast(nums, start, midpoint - 1, target, first);
        } else if (target == nums[midpoint]) {
            if (start == end) {
                return start;
            }

            if (first) {
                return findFirstOrLast(nums, start, midpoint, target, first);
            } else {
                // 特殊情况处理：由于截除，start==midpoint时，会造成死循环，比如start=1，end=2
                if (start == midpoint) {
                    if (nums[end] == target) {
                        return end;
                    } else {
                        end--;
                    }
                }

                return findFirstOrLast(nums, midpoint, end, target, first);
            }
        } else {
            return findFirstOrLast(nums, midpoint + 1, end, target, first);
        }
    }
}