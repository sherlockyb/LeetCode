### 18. 4Sum

Given an array *S* of *n* integers, are there elements *a*, *b*, *c*, and *d* in *S* such that *a* + *b* + *c* + *d* = target? Find all unique quadruplets in the array which gives the sum of target.

**Note:** The solution set must not contain duplicate quadruplets.

```
For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
```

#### 思路（[代码](https://github.com/sherlock-y/LeetCode/blob/master/src/main/java/org/sherlocky/leetcode/array/fourSum/Solution.java)）

沿用[3Sum](https://github.com/sherlock-y/LeetCode/tree/master/src/main/java/org/sherlocky/leetcode/array/threeSum)的思路，只不过相对于它多了层循环嵌套。