package org.sherlocky.leetcode.dynamicProgramming.containerWithMostWater;

/**
 * Created by yangbing on 2017/4/9.
 */
public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxA = -1, tempA;
        int start = 0, end = n-1;
        while (start < end) {
            tempA = Math.min(height[start], height[end]) * (end-start);
            if (tempA > maxA) {
                maxA = tempA;
            }
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxA;
    }
}
