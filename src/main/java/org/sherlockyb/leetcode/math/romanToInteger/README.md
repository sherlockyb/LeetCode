### 13. Roman to Integer

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

#### 思路（[代码](https://github.com/sherlock-y/LeetCode/blob/master/src/main/java/org/sherlocky/leetcode/math/romanToInteger/Solution.java)）

罗马数字是分级的（M；C-M-D，X-C-L，I-X-V），从大到小，逐级处理即可。
