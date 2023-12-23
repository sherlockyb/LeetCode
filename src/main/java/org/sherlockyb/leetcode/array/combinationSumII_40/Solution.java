package org.sherlockyb.leetcode.array.combinationSumII_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author biyang
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(candidates);
        sum(candidates, target, 0, new ArrayList<>(), results);

        return results;
    }

    private void sum(int[] candidates, int target, int i, List<Integer> result, List<List<Integer>> results) {
        if (target == 0 && !result.isEmpty()) {
            results.add(new ArrayList<>(result));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (candidates[j] > target) {
                return;
            }
            if (j > i && candidates[j] == candidates[j-1]) {
                continue;
            }

            result.add(candidates[j]);
            sum(candidates, target - candidates[j], j+1, result, results);
            result.remove(result.size() - 1);
        }
    }
}
