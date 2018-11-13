### 32. Longest Valid Parentheses

Given a string containing just the characters `'('` and `')'`, find the length of the longest valid (well-formed) parentheses substring.

**Example 1:**

```
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
```

**Example 2:**

```
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
```

#### 思路（[代码](Solution.java)）

找最长的合法括号子串，该题是[20-Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)的进一步扩充。

那么顺着第20题的思路，首先想到的就是暴力穷举：遍历字符串`s`的所有子串，然后挨个校验是否是valid parentheses，这样做也不失为一种解决方案。但是我马上就否决了它，因为这是一个NP难问题，这种方法行不通。

对于这种情况，最有效的方法就是动态规划了。用动态规划求解的关键是能否找到递推关系，即复用子问题的解。子问题的解重叠越多，动态规划越有效。

对于一个字符串`s`，我们先看最后一个字符，记为`x`，此题目中`x`只能为`(`或`)`，我们不妨分析一下这两种情况。

- 当`x`为`(`时，按照合法括号对的规则，它是不可能与前面的字符组成合法括号对的，也就是说字符串`s`的最长合法括号对肯定不包含最后这个字符`x`，即可以得到这种情形下的递推关系：`f(n)=f(n-1)`，其中`f(n)`和`f(n-1)`表示当前字符串`s`和`s`的前`n-1`个字符的子串的最长合法括号子串的长度
- 当`x`为`)`时，它是可能与前面的字符组成合法串的。既然说到可能，那么无非就两种情况：是和否。于是分为两种情况，当`x`不与前面的字符串组成合法串，换句话说，当前字符串`s`的最长合法串不包含最后一个字符`x`时，最长合法串的长度就是`f(n-1)`；当`x`与前面的字符串组成合法串，也就是说，此时合法串必须以`x`结尾，那我们就从`x`往前遍历，如果是遇到`)`，则左括号数+1，若是遇到`(`，则会消去一个右括号，同时合法括号对数+1，停止的条件就是当前右括号数为0或达到了字符串`s`的首部。对于前者返回`f(n-括号对数*2)+括号对数*2`，对于后者则直接返回0。最后，这两种情况取较大者，就得到了`x`为`)`时的最长合法串长度了。

一步步分析下来，其实也并不难，主要就在于能否快速地找到这个突破口。

