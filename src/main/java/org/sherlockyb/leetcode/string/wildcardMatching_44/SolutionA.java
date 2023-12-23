package org.sherlockyb.leetcode.string.wildcardMatching_44;

/**
 * @author biyang
 */
class SolutionA {
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

        char pChar = p.charAt(0);
        char pLastChar = p.charAt(p.length() - 1);

        if (pLastChar != STAR) {
            if (pLastChar != s.charAt(s.length()-1) && pLastChar != QUESTION) {
                return false;
            }
        }

        if (pChar != STAR) {
            return (pChar == s.charAt(0) || pChar == QUESTION) &&
                subMatch(s.length() > 1 ? s.substring(1) : "", p.length() > 1 ? p.substring(1) : "");
        } else {
            // 从s的当前元素开始，一直到末尾
            for (int i = 0; i <= s.length(); i++) {
                if (subMatch(i < s.length() ? s.substring(i) : "", p.substring(1))) {
                    return true;
                }
            }
            return false;
        }
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
}
