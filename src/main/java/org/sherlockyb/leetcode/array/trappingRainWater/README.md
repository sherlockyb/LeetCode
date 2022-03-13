### 42. Trapping Rain Water

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png)

```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
```

**Example 2:**

```
Input: height = [4,2,0,3,2,5]
Output: 9
```

 

**Constraints:**

- `n == height.length`
- `1 <= n <= 2 * 104`
- `0 <= height[i] <= 105`

#### 思路（[代码](Solution.java)）

该题考查两点：

* 如何将实际问题转换为数学语言来描述
* 分而治之思想

从示例图可看出，蓄水池是分段的，由多个凹槽组成，只有凹槽才能够蓄水。凹槽的样子是两端高，中间低，用数学语言描述就是，凹槽对应的区间，两端必然由最大高度和次大高度的柱形组成，次大高度决定了蓄水池的水平高度，而蓄水池的容量计算则是由次大高度与两端之间的其余柱形高度的差的和。

蓄水池的特点是最高柱形 h1 会把蓄水池隔为两个区间 A 和 B，总蓄水容量则是 A 和 B 的蓄水量加和。对于区间A，区间内的最高柱形 h2 依旧会将其分隔为两个更小的左右子区间 C 和 D，对于 D 区间，已经明确了最大高度 h1 和 次大高度 h2，按照上述规则可直接计算出该区间的蓄水量；对于 C 区间，因为次高度还未确定，所以需要继续递归上述过程。

以此类推，按照自上而下分而治之的策略进行递归就行。