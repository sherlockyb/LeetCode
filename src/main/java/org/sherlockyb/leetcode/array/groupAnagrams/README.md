### 49. Group Anagrams

Given an array of strings `strs`, group **the anagrams** together. You can return the answer in **any order**.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

**Example 1:**

```
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

**Example 2:**

```
Input: strs = [""]
Output: [[""]]
```

**Example 3:**

```
Input: strs = ["a"]
Output: [["a"]]
```

 

**Constraints:**

- `1 <= strs.length <= 104`
- `0 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters.

#### 思路（[代码](Solution.java)）

将多个字符串按照 anagrams 分组，第一时间想到的是用类型为 `<String, List<String>>` 的Hashmap，将属于同一组 anagrams 的字符串放到同一个list。

剩下的问题就是如何快速判断两个字符串为 anagrams，很自然地想到，先将俩字符串中的字符各自排序，然后直接比较字符串是否相等来判断是否是 anagrams。

如果说字符串中字符无任何限制，那排序只能采用常规 `N*log(N)` 的排序算法。但我们注意到 `strs[i]` 的字符是有限制的，即只能是小写字母，对于这种由有限范围元素组成的数组，可以采用基于数组下标的 `O(N)` 排序。