### 28. Wildcard Matching

Given an input string (`s`) and a pattern (`p`), implement wildcard pattern matching with support for `'?'` and `'*'` where:

- `'?'` Matches any single character.
- `'*'` Matches any sequence of characters (including the empty sequence).

The matching should cover the **entire** input string (not partial).

 

**Example 1:**

```
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
```

**Example 2:**

```
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
```

**Example 3:**

```
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
```

#### 思路

- [x] **算法一，递归回溯，见[代码](SolutionA.java)**

  主要是对`*`的处理，需要穷举其匹配源字符串s中从空串到全部字符串的所有情况，即递归+回溯，**但很不幸，结果超时了**，具体可见https://leetcode.com/submissions/detail/378420685/。

- [x] **算法二，空间换时间，用DP代替递归回溯，避免重复计算，见[代码](Solution.java)**

  DP的关键在于以下几点：
    1、dp[i][j]的含义要搞清楚
    2、第一行（dp[0][0...j]）和第一列（dp[0...i][0]）的初始化
    3、找到dp[i][j]与dp[i-1][j-1]、dp[i-1][j]、dp[i][j-1]的递推关系
