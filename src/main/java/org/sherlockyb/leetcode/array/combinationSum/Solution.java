package org.sherlockyb.leetcode.array.combinationSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> results = new ArrayList<>();
        int[] coefficients = new int[candidates.length];
        sum(candidates, coefficients, 0, target, results);

        return results;
    }

    private void sum(int[] candidates, int[] coefficients, int i, int target, List<List<Integer>> results) {
        if (i >= coefficients.length) {
            return;
        }

        for (coefficients[i] = 0; coefficients[i] <= target; coefficients[i]++) {
            // 将后续系数重置
            for (int j = i+1; j < coefficients.length; j++) {
                coefficients[j] = 0;
            }

            // 裁支
            int partialResult = partialSum(candidates, coefficients, i);
            if (partialResult == target) {
                List<Integer> result = new ArrayList<>(coefficients.length);
                for (int j = 0; j < coefficients.length; j++) {
                    if (coefficients[j] == 0) {
                        continue;
                    }
                    for (int k = 0; k < coefficients[j]; k++) {
                        result.add(candidates[j]);
                    }
                }
                results.add(result);
                return;
            } else if (partialResult > target) {
                return;
            }

            sum(candidates, coefficients,i+1, target, results);
        }
    }

    private int partialSum(int[] candidates, int[] coefficients, int i) {
        int sum = 0;
        for (int j = 0; j <= i; j++) {
            sum += candidates[j] * coefficients[j];
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = new int[] {1, 2, 3};
        System.out.println(solution.combinationSum(candidates, 50));
    }
}
