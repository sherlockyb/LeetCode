package org.sherlockyb.leetcode.array.jumpGameII_45;

/**
 * @author sherlockyb
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        final int[] rs = new int[nums.length];
        // rs[rs.length - 1]会由于数组默认初始化被初始化为0，我们用-1表示走不通


        for (int i = nums.length-2; i >=0 ; i--) {
            if (nums[i] == 0) {
                rs[i] = -1;
            } else if (nums[i] >= nums.length-1 - i){
                rs[i] = 1;
            } else {
                int minJumpCount = Integer.MAX_VALUE;
                for (int stepLen = 1; stepLen <= nums[i]; stepLen++) {
                    final int nextJumpIdx = i + stepLen;
                    if (rs[nextJumpIdx] == -1) {
                        // 此处不通，需跳过
                        continue;
                    } else if (rs[nextJumpIdx] < minJumpCount) {
                        minJumpCount = rs[nextJumpIdx];
                    }
                }
                if (minJumpCount == Integer.MAX_VALUE) {
                    // 说明后续位置都走不通，那当前位置也记为走不通
                    rs[i] = -1;
                } else {
                    rs[i] = 1 + minJumpCount;
                }
            }
        }

        return rs[0];
    }
}
