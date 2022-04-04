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

#### 思路

将多个字符串按照 anagrams 分组，第一时间想到的是用类型为 `<String, List<String>>` 的Hashmap，将属于同一组 anagrams 的字符串放到同一个list。

剩下的问题就是如何快速判断两个字符串为 anagrams，很自然地想到，先将俩字符串中的字符各自排序，然后直接比较字符串是否相等来判断是否是 anagrams。

如果说字符串中字符无任何限制，那排序只能采用常规 `N*log(N)` 的排序算法，见[代码1](Solution.java)。但我们注意到 `strs[i]` 的字符是有限制的，即只能是小写字母，对于这种由有限范围元素组成的数组，可以采用基于数组下标的 `O(N)` 排序。

到这里，其实我们还可以做更精细的优化。当我们采用基于数组下标的排序时，由于只有26个小写字母，所以只需要大小为 26 的辅助数组 assistChars，当我们遍历完待排序字符串中的每个字符，填充好 assistChars 后，我们无论如何都需要再遍历一遍 assistChars 来得到排序后的字符串，该操作需 26 次计算，那么排序的总计算量就是 `strs[i].length + 26`。假设是长度为 4 字符串，则计算量为 30；而此时如果直接用 `N*log(N)` 的常规排序时，则仅需要 8 的计算量，比前者要少，并且也省去了额外数组空间。但如果是长度为 16 的字符串，前者计算量为 42，而后者计算量为 64，又反超了前者。

经过计算，当待排字符串的长度小于或等于10时，更适用于 `N*log(N)` 的排序；而大于10时，则适用于 `O(N)` 的排序，我们需要根据字符串长度的不同，而选择不同的排序算法。**这个其实也是受 JDK 排序算法 `Arrays.sort(...arrs)` 和 `Collections.sort(...list)`  的思想启发，中庸之道，多种排序算法组合，各取所长，以达到收益最大化**。见[代码2](Solution2.java)