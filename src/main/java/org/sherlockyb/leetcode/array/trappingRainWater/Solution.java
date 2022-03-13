package org.sherlockyb.leetcode.array.trappingRainWater;

/**
 * @author biyang
 */
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int maxIdx = maxIdx(height, 0,  height.length - 1);
        return subTrap(height, 0, height.length - 1, maxIdx);
    }

    private int subTrap(int[] height, int start, int end, int maxIdx) {
        if (start < 0 || end >= height.length || maxIdx < start || maxIdx > end) {
            return 0;
        }

        int leftMaxIdx = maxIdx(height, start, maxIdx - 1);
        int leftMaxHeight = leftMaxIdx == -1 ? 0 : height[leftMaxIdx];
        int leftWaterCount = sumWater(height, leftMaxIdx+1, maxIdx-1, leftMaxHeight);

        int rightMaxIdx = maxIdx(height, maxIdx+1, end);
        int rightMaxHeight = rightMaxIdx == -1 ? 0 : height[rightMaxIdx];
        int rightWaterCount = sumWater(height, maxIdx+1, rightMaxIdx-1, rightMaxHeight);

        return subTrap(height, start, leftMaxIdx, leftMaxIdx) +
            subTrap(height, rightMaxIdx, end, rightMaxIdx) +
            leftWaterCount + rightWaterCount;
    }

    private int sumWater(int[] height, int start, int end, int maxHeight) {
        if (maxHeight <= 0) {
            return 0;
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += maxHeight - height[i];
        }

        return sum;
    }

    private int maxIdx(int[] numbers, int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                index = i;
            }
        }

        return index;
    }
}
