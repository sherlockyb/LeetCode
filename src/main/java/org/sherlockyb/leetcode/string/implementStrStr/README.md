### 28. Implement strStr()

Implement [strStr()](http://www.cplusplus.com/reference/cstring/strstr/).

Return the index of the first occurrence of needle in haystack, or **-1** if needle is not part of haystack.

**Example 1:**

```
Input: haystack = "hello", needle = "ll"
Output: 2
```

**Example 2:**

```
Input: haystack = "aaaaa", needle = "bba"
Output: -1
```

**Clarification:**

What should we return when `needle` is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when `needle` is an empty string. This is consistent to C's [strstr()](http://www.cplusplus.com/reference/cstring/strstr/) and Java's [indexOf()](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexOf(java.lang.String)).

#### 思路

- [x] **算法一，暴力穷举，见[代码](Solution.java)**

  JDK中的[indexOf](http://hg.openjdk.java.net/jdk7u/jdk7u6/jdk/file/8c2c5d63a17e/src/share/classes/java/lang/String.java)就是采用的此算法！至于为何不采用[KMP](https://en.wikipedia.org/wiki/Knuth–Morris–Pratt_algorithm)或是[BM](https://zh.wikipedia.org/wiki/Boyer-Moore字符串搜索算法)等计算更高效的算法，具体可以看看这个[解释](https://stackoverflow.com/questions/19543547/why-does-string-indexof-not-use-kmp)。大师就是大师，考虑问题往往更全面，从实际应用出发，而不是一味地追求单个指标项的最大化。

- [x] **算法二，经典的KMP，见[代码](SolutionKmp.java)**

  专注于模式串的规律，利用已经匹配过的信息，确保被搜索字符串不回溯，模式串尽可能少的回溯。

- [ ] **算法三，BM（Boyer-Moore）**

- [ ] **算法四，Sunday算法**