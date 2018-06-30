### 12. Integer to Roman

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

#### 思路（[代码](https://github.com/sherlock-y/LeetCode/blob/master/src/main/java/org/sherlocky/leetcode/math/integerToRoman/Solution.java)）

题目常规，搞清楚了罗马数字的体系就迎刃而解了。介绍如下，[参考](http://iask.sina.com.cn/b/1775817.html)：

+ 罗马数字共有七个字面：I(1)，V(5)，X(10)，C(100)，D(500)，M(1000)
+ 按照如下规则即可表示任意正整数：
  1. 重复次数：一个罗马数字重复几次，就表示这个数的几倍。
  2. 右加左减：在一个较大的罗马数字的右边拼接一个较小的罗马数字，表示的结果是大数字加小数字。反之，较大的数字在较小数字的右边，表示的结果是大数字减去小数字。但是，左减不能跨越等级。比如99不能用IC表示，要用XCIX表示。
  3. 加线乘千：在一个罗马数字的上方加一条横线或在右下方写M，则表示该数字乘以1000。同理，若上方有两条横线，则乘以两次1000，即1000000.
  4. 单位限制：同样的单位只能连续出现3次，如40不能表示为XXXX，而应该是XL。

