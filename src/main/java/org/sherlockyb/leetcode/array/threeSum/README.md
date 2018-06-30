### 15. 3Sum

Given an array *S* of *n* integers, are there elements *a*, *b*, *c* in *S* such that *a* + *b* + *c* = 0? Find all unique triplets in the array which gives the sum of zero.

**Note:** The solution set must not contain duplicate triplets.

```
For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```
#### 思路（[代码](https://github.com/sherlock-y/LeetCode/blob/master/src/main/java/org/sherlocky/leetcode/array/threeSum/Solution.java)）

就是[Two Sum](https://leetcode.com/problems/two-sum/#/description)的变体，区别就是在本题中target是变化的，是数组中其中一个元素的相反数。参照Two Sum的思路，相对于它，多了一道循环。这里的一个难点就是三元组的去重问题，首先得让三元组有序，一种方式是直接对三元组本身排序，另一种较好的方案是先对整个输入数字排序，让其有序，使得得到的三元组也是有序的。保证三元组有序后，就剩下去重的问题了，这里并不需要逐个比较三元组的每个元素，因为ArrayList的toString用的是","分隔符对元素进行拼接得到String，”,“不会出现在整数元素中，因此串相同，元组就相同，直接通过List的String形式是否相同就能判定两个整数三元组是否重复。