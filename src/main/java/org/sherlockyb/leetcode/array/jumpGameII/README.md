### 45. Jump Game II

Given an array of non-negative integers `nums`, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

**Example 1:**

```
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

**Example 2:**

```
Input: nums = [2,3,0,1,4]
Output: 2
```

 

**Constraints:**

- `1 <= nums.length <= 104`
- `0 <= nums[i] <= 1000`

#### 思路（[代码](Solution.java)）

最直观的第一版思路肯定是穷举剪枝。

先看起始位置 0 处的值 `a0`，根据 `Constraints` 可知 `a0` 为小于 1000 的非负数，当 `a0` 为 0 时，是无法往下一个位置跳的，此时只有当数组 `nums` 只有一个元素，也就是 0 为 last index 时，才有唯一的最小解 0，否则该位置就是走不通，得换个别的位置跳；当 `a0` 大于 0 时，表示从当前位置可跳 `0,1,..., a0` 等步数从而到达 `0,1,..., a0`等多个位置，那我们就得逐个分析跳往每一个位置的情况。假设从位置 0 跳往 last index 的最小步数为 `rs0`，

跳 0 步时，到达位置 0，表示不移动，此时若 last index 为0，则直接返回0，否则无解

跳 1 步时，到达位置 1，用掉了 1 步，然后就得看从位置 1 处跳到 last index 的最小步数，假设是 `rs1`，那此时总的最小步数就是 `1 + rs1`。

跳 2 步时，到达位置 2，用掉了 2 步，然后就看从位置 2 处跳到 last index 的最小步数，假设是 `rs2`，那该情况下，总的最小步数就是 `2 + rs2`。

以此类推，然后比较所有情况的最小步数，取最小值即可。



但通常情况下，上述直观的算法会超时，因为多了太多重复计算。

我们可以看下 `rs1` 的计算过程，

> 若 `a1` 为 0，则只有当前位置为last index时，`rs1` 才有唯一解0；否则该位置走不通，`rs1` 无合法值
>
> 若 `a1` 大于 0，则从当前位置是可以跳往位置 2的，会花掉一步，此时总的最小步数，则直接是 `1 + rs2`；假设能跳到位置 3，会花掉 2 步，则取值是 `2 + rs3`

从上述过程其实就能发现，我们在计算 `rs1` 的时候也用到了 `rs2` 的值，如同计算 `rs0` 时用到了该值一样。也就是说计算 `rs(i)` 时，会用到后面 `rs(i+1), rs(i+1),..., rs(N-1)` 的子最优解，这些都重复计算了。而对于这种父问题的解可由子问题的解表示的，自然而然能想到用动态规划来提速。



所以最终的思路就是从数组 `nums` 尾部开始，计算 `rs(N-1)`，然后再基于前者的结果计算 `rs(N-2)`，然后再基于已有的结果计算 `rs(N-3)`，以此类推，最终计算出 `rs0`。