### 21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

#### 思路（[代码](https://github.com/sherlock-y/LeetCode/blob/master/src/main/java/org/sherlocky/leetcode/linkedlist/mergeTwoSortedLists/Solution.java)）

常规问题，维持两个指针，同时分别扫描两个有序表，通过比较大小来决定选取哪个指针，移动哪个指针。

吐槽：该题目的问题在于，没有指明有序表的**顺序**，是**正排**还是**倒排**？这关系到比较大小后，如何取舍的问题，不过为了AC，只能通过“Custom Testcase”测出是默认是升序，比如下面的case：

```shell
input: 
[9,2]
[5,4]
output: 
[5,4,9,2]
```



