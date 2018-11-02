### 30. Substring with Concatenation of All Words

You are given a string, **s**, and a list of words, **words**, that are all of the same length. Find all starting indices of substring(s) in **s** that is a concatenation of each word in **words** exactly once and without any intervening characters.

**Example 1:**

```
Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
```

**Example 2:**

```
Input:
  s = "wordgoodstudentgoodword",
  words = ["word","student"]
Output: []
```

#### 思路（[代码](Solution.java)）

s中所包含的`word`必须连续出现且各`word`仅出现一次，这一条件，让该题的难度小了不少。直接用`HashMap`存放`words`，用于快速判断s中一个等长的子串是否出现在`words`中。

##### 边界点

- words中的word可能相互有重复。