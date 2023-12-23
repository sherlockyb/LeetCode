### 19. Remove Nth Node From End of List

Given a linked list, remove the *n*th node from the end of list and return its head.

For example,

```
   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
```

**Note:**
Given *n* will always be valid.
Try to do this in one pass.

#### 思路（[代码](https://github.com/sherlockyb/LeetCode/blob/master/src/main/java/org/sherlockyb/leetcode/linkedlist/removeNthNodeFromEndofList/Solution.java)）

用空间换时间，既然是倒序第n个，我自然就联想到栈结构，先顺序扫描链表逐个入栈，然后出栈并采用头插法构建链表，期间计数判断，过滤掉第n个即可。

虽然这个算法可以AC，但却没有快慢指针的方案完美，具体见[代码](https://discuss.leetcode.com/topic/7031/simple-java-solution-in-one-pass)，原来快慢指针不光是可以步长不同（针对单链表找中点问题），还可以起点不同，玩法真是多样啊，有待总结。