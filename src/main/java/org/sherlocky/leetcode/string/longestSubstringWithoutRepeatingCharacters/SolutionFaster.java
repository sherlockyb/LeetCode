package org.sherlocky.leetcode.string.longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangbing
 * @since 2017-4-1
 * @version 1.0.0
 */
public class SolutionFaster {
	public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
	        return 0;
        }
        if (s.length() == 1) {
	        return 1;
        }
        int maxL = -1;
        int start = 0, end = 0, cursor = 1;
        Map<Character, Integer> charToIdx = new HashMap<>();
        charToIdx.put(s.charAt(start), 0);
        while (cursor < s.length()) {
        	boolean exist = false;
        	int i = start;
        	Integer idx = charToIdx.get(s.charAt(cursor));
        	if (idx != null && idx >= start) {
	            exist = true;
	            i = idx;
            }
        	charToIdx.put(s.charAt(cursor), cursor);
        	
	        if (!exist) {
	            end++;
            } else {
				start = i+1;
				end = cursor;
			}
	        cursor++;
	        int curL = end - start + 1;
	        maxL = curL > maxL ? curL: maxL;
        }
        
		return maxL;
    }
}
