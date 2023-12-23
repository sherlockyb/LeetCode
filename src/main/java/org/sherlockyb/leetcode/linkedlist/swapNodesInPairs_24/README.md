### 24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

**Example:**

```java
Given 1->2->3->4, you should return the list as 2->1->4->3.
```

**Note:**

- Your algorithm should use only constant extra space.
- You may **not** modify the values in the list's nodes, only nodes itself may be changed.

#### 思路（[代码](https://github.com/sherlockyb/LeetCode/blob/master/src/main/java/org/sherlockyb/leetcode/linkedlist/swapNodesInPairs/Solution.java)）

主要考察基本的链表操作，唯一需要注意的细节就是当交换节点对同时有前置节点和后置节点的情况，例如：

对于链表`1->2->3->4`，操作2、3节点时，需要注意1、4节点的next指针变化。