package org.sherlockyb.leetcode.array.groupAnagrams;

import java.util.*;

/**
 * @author biyang
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return Collections.emptyList();
        }
        if (strs.length == 1) {
            return Collections.singletonList(Collections.singletonList(strs[0]));
        }

        final HashMap<String, List<String>> anagrams2items = new HashMap<>();
        for (String str : strs) {
            final char[] chars = str.toCharArray();
            Arrays.sort(chars);
            final String sortedStr = new String(chars);
            final List<String> items = anagrams2items.computeIfAbsent(sortedStr, k -> new ArrayList<>());
            items.add(str);
        }

        return new ArrayList<>(anagrams2items.values());
    }
}
