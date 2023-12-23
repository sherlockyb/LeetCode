### 46. Permutations

Given an array `nums` of distinct integers, return *all the possible permutations*. You can return the answer in **any order**.

 

**Example 1:**

```
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

**Example 2:**

```
Input: nums = [0,1]
Output: [[0,1],[1,0]]
```

**Example 3:**

```
Input: nums = [1]
Output: [[1]]
```

 

**Constraints:**

- `1 <= nums.length <= 6`
- `-10 <= nums[i] <= 10`
- All the integers of `nums` are **unique**.

#### 思路（[代码](Solution.java)）

##### 朴素的思路：穷举遍历

对于N 个不同元素的排列组合，公式为 `N!=N*(N-1)*...2*1`，从公式的由来去思考排列组合的过程：

> 将 N 个元素依次排列到 N 个位置，对于第 1 个位置，从 N 个元素中任选一个放入，有 N 种选择，选择之后；接着，对于第 2 个位置，从剩下的 `N-1` 个元素中任选一个放入，有 `N-1` 种选择，选择之后；接着，对于第 3 个位置……
>
> 从而总的排列组合数就是上述公式了。

用递归实现上述过程。

