package org.sherlocky.leetcode.math.romanToInteger;

/**
 * Created by yangbing on 2017/4/11.
 */
public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        if (s == null || "".equals(s)) {
            return result;
        }
        int idx = 0;
        // 处理1000量级
        while (idx < s.length() && s.charAt(idx) == 'M') {
            result += 1000;
            idx++;
        }
        // 处理100、10和1量级
        int[] pair = new int[] {idx, result};
        doProcess(pair, s, 100, 'C', 'M', 'D');
        doProcess(pair, s, 10, 'X', 'C', 'L');
        doProcess(pair, s, 1, 'I', 'X', 'V');

        return pair[1];
    }

    private void doProcess(
            int[] pair,                         //pair[0] = idx; pair[idx] = result
            String s,                           //源罗马字符串
            int magnitude,                      //当前量级：比如10
            char magnitudeLiteral,              //当前量级对应的字面，如X（对应上面的10）
            char doubleMagnitudeLiteral,        //当前量级乘以10后对应的字面，如C（100）
            char dHalfMagnitudeLiteral) {       //当前量级乘以10后的一半对应字面，如L（50）
        if (pair[0] < s.length()) {
            if (s.charAt(pair[0]) == magnitudeLiteral) {
                if (pair[0]+1 < s.length()) {
                    if (s.charAt(pair[0]+1) == doubleMagnitudeLiteral) {
                        pair[1] += 9*magnitude;
                        pair[0] += 2;
                    } else if (s.charAt(pair[0]+1) == dHalfMagnitudeLiteral) {
                        pair[1] += 4*magnitude;
                        pair[0] += 2;
                    } else if (s.charAt(pair[0]+1) == magnitudeLiteral){
                        pair[1] += magnitude;
                        pair[0]++;
                        while (pair[0] < s.length() && s.charAt(pair[0]) == magnitudeLiteral) {
                            pair[1] += magnitude;
                            pair[0]++;
                        }
                    } else {
                        pair[1] += magnitude;
                        pair[0]++;
                    }
                } else {
                    pair[1] += magnitude;
                    pair[0]++;
                }
            } else if (s.charAt(pair[0]) == dHalfMagnitudeLiteral) {
                pair[1] += 5*magnitude;
                pair[0]++;
                while (pair[0] < s.length() && s.charAt(pair[0]) == magnitudeLiteral) {
                    pair[1] += magnitude;
                    pair[0]++;
                }
            }
        }
    }
}
