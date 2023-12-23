### 22. Generate Parentheses

Given *n* pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given *n* = 3, a solution set is:

```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

### 思路（[代码](https://github.com/sherlockyb/LeetCode/blob/master/src/main/java/org/sherlockyb/leetcode/backtracking/generateParentheses/Solution.java)）

回溯法+分支裁剪。分支裁剪的关键，就是定义各种约束条件，然后把不符合条件的分支裁掉，降低问题的可行解空间大小。

对于本问题，通过**枚举实例观察规律**得知，在逐个字符生成有效结果串的过程中，约束条件如下：

1. 当前新增字符只能是"("或")".
2. 当**匹配剩余左括号**（为了叙述方便，称之为**MLB**）个数为0时，当前新增字符只能是"("。这里解释下**MLB**，即在当前已生成的字符串中，去掉所有配对的左括号和右括号后剩余的左括号。举个栗子，当前字符串为"()(()"，则MLB的个数为1。很明显，当其个数为0时，说明左括号和右括号正好全部一一匹配，后续新增字符就只能是"("了.
3. 当MLB的个数大于等于**剩余有效位置数**（目标字符串长度-当前已生成字符串长度）时，新增字符只能是")"；否则新增字符可以是"("或")".
4. 当前字符串长度等于目标长度时，将其添加到有效结果中，并回溯到上一步

定义好如上约束条件后，剩下的事情就是写递归代码实现了。

