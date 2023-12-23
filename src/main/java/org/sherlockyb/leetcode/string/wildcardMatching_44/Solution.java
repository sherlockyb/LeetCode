package org.sherlockyb.leetcode.string.wildcardMatching_44;

/**
 * @author biyang
 */
public class Solution {
    private static final char STAR = '*';
    private static final char QUESTION = '?';

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        p = removeAdjacentDuplicateStar(p);

        return subMatch(s, p);
    }

    private boolean subMatch(String s, String p) {
        if (s.isEmpty()) {
            return p.isEmpty() || p.chars().allMatch(ch -> (char) ch == STAR);
        }

        if (p.isEmpty()) {
            return false;
        }

        boolean[][] matchResult = new boolean[p.length()+1][s.length()+1];
        // initialize first row: matchResult[0][0...s.length()]. as basic boolean type for Java will be initialized as false, so only need initialize
        // true element manually
        matchResult[0][0] = true;
        // initialize second row: matchResult[1][0...s.length()]
        if (p.charAt(0) == '*') {
            for (int j = 0; j <= s.length(); j++) {
                matchResult[1][j] = true;
            }
        }

        // matchResult[i][j]的含义：p[0,i]与s[0,j]两个子串是否匹配
        for (int i = 1; i <= p.length(); i++) {
            final char pChar = p.charAt(i-1);
            for (int j = 1; j <= s.length(); j++) {
                final char sChar = s.charAt(j-1);
                if (pChar == '?') {
                    matchResult[i][j] = matchResult[i-1][j-1];
                } else if (pChar == '*') {
                    // 三种bool表达式从左到右分别表示：1) *匹配0个字符；2）*匹配一个字符，即当前sChar；3）匹配2个及以上的字符，即可跳过s中的当前sChar，往左继续匹配
                    matchResult[i][j] = matchResult[i-1][j] || matchResult[i-1][j-1] || matchResult[i][j-1];
                } else {
                    matchResult[i][j] = sChar == pChar && matchResult[i-1][j-1];
                }
            }
        }

        return matchResult[p.length()][s.length()];
    }

    private String removeAdjacentDuplicateStar(String str) {
        StringBuilder sb = new StringBuilder();
        boolean hasStar = false;
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            if (str.charAt(i) == STAR) {
                if (!hasStar) {
                    sb.append(curChar);
                }
                hasStar = true;
            } else {
                sb.append(curChar);
                hasStar = false;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        final String s = "adceb";
        final String p = "*a*b";
        Solution solution = new Solution();
        System.out.println(solution.isMatch(s, p));
    }
}
