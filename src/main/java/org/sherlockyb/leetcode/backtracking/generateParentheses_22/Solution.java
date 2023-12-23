package org.sherlockyb.leetcode.backtracking.generateParentheses_22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangbing on 2017/8/12.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0, 2*n, 2*n, "", result);

        return result;
    }

    private void backtrack(int matchLeftBracketNum, int activePosNum, int totalPosNum ,String str, List<String> result) {
        if (activePosNum == 0) {
            if (str.length() == totalPosNum) {
                result.add(str);
            }
            return;
        }
        if (matchLeftBracketNum == 0) {
            backtrack(matchLeftBracketNum+1, activePosNum-1, totalPosNum, str+"(", result);
        } else {
            if (matchLeftBracketNum >= activePosNum) {
                //每一个右括号都会消除一个左括号
                backtrack(--matchLeftBracketNum, --activePosNum, totalPosNum, str+")", result);
            } else {
                // "("
                backtrack(matchLeftBracketNum+1, activePosNum-1, totalPosNum, str+"(", result);
                // ")"
                backtrack(matchLeftBracketNum-1, activePosNum-1, totalPosNum, str+")", result);
            }
        }
    }
}
