### 22. Merge k Sorted Lists

Merge *k* sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

#### 思路（[代码](https://github.com/sherlockyb/LeetCode/blob/master/src/main/java/org/sherlockyb/leetcode/linkedlist/mergekSortedLists/Solution.java)）

作为[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/description/)的扩展，最直接的解法无非就是将2扩展成K即可，但这种解法问题是结果列表每增加一个元素，就需要K次比较，其复杂度为*O(K\*(L1+L2+...+Ln))*，Ln为每个列表的长度。可采用分治法思想，将K的列表拆分成两拨，各自递归拆分合并后，再合并这两个有序列表，时间复杂度为*O(logK\*(L1+L2+...+Ln))*，logK即为K个列表二分拆分的二叉树层级数。