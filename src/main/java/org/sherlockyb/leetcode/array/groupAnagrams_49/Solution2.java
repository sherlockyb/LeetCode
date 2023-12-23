package org.sherlockyb.leetcode.array.groupAnagrams_49;

import java.util.*;

/**
 * @author sherlockyb
 */
public class Solution2 {

    private static final int jdkSortMaxThreshold = 10;

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return Collections.singletonList(Collections.singletonList(strs[0]));
        }

        final HashMap<String, List<String>> anagrams2items = new HashMap<>();
        final int[] assistChars = new int[26];
        for (String str : strs) {
            final String sortedStr;
            if (str.length() <= jdkSortMaxThreshold) {
                sortedStr = getSortedStrByJdkSort(str);
            } else {
                sortedStr = getSortedStrByArrayIndexSort(str, assistChars);
            }

            final List<String> items = anagrams2items.computeIfAbsent(sortedStr, k -> new ArrayList<>());
            items.add(str);
        }

        return new ArrayList<>(anagrams2items.values());
    }

    private String getSortedStrByJdkSort(final String originStr) {
        final char[] chars = originStr.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private String getSortedStrByArrayIndexSort(final String originStr, final int[] assistChars) {
        reset(assistChars);
        for (int i = 0; i < originStr.length(); i++) {
            assistChars[originStr.charAt(i) - 'a'] += 1;
        }

        final StringBuilder sortedChars = new StringBuilder(originStr.length());
        for (int i = 0; i < assistChars.length; i++) {
            if (assistChars[i] == 0) {
                continue;
            }
            for (int j = 0; j < assistChars[i]; j++) {
                sortedChars.append('a' + i);
            }
        }

        return sortedChars.toString();
    }

    private void reset(final int[] assistChars) {
        Arrays.fill(assistChars, 0);
    }
}
