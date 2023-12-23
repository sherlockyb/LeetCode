package org.sherlockyb.leetcode.string.substringWithConcatenationOfAllWords_30;

import java.util.*;

/**
 * Created by yangbing on 2018/11/2.
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0) {
            return Collections.emptyList();
        }
        int wordLen = words[0].length();
        if (s.length() < wordLen * words.length) {
            return Collections.emptyList();
        }
        Set<Character> initials = new HashSet<>();
        Map<String, Integer> word2num = new HashMap<>();
        for (String word: words) {
            initials.add(word.charAt(0));
            Integer cnt = word2num.get(word);
            if (cnt == null) {
                word2num.put(word, 1);
            } else {
                word2num.put(word, cnt + 1);
            }
        }
        List<Integer> startIndices = new ArrayList<>();
        int upperBound = s.length() - wordLen*words.length;
        Map<String, Integer> word2cnt = new HashMap<>();
        for (int i = 0; i <= upperBound; i++) {
            if (!initials.contains(s.charAt(i))) {
                continue;
            }
            for (int j = 0; j < words.length; j++) {
                String word = s.substring(i+j*wordLen, i+(j+1)*wordLen);
                if (!word2num.containsKey(word)) {
                    break;
                }
                Integer count = word2cnt.get(word);
                if (count == null) {
                    word2cnt.put(word, 1);
                } else {
                    word2cnt.put(word, count + 1);
                }
            }
            int hitWordNum = 0;
            for (Map.Entry<String, Integer> entry: word2num.entrySet()) {
                if (!entry.getValue().equals(word2cnt.get(entry.getKey()))) {
                    break;
                }
                hitWordNum++;
            }
            if (hitWordNum == word2num.size()) {
                startIndices.add(i);
            }
            // 重置
            word2cnt.clear();
        }

        return startIndices;
    }
}
