### 41. First Missing Positive

Given an unsorted integer array `nums`, return the smallest missing positive integer.

You must implement an algorithm that runs in `O(n)` time and uses constant extra space.

 

**Example 1:**

```
Input: nums = [1,2,0]
Output: 3
```

**Example 2:**

```
Input: nums = [3,4,-1,1]
Output: 2
```

**Example 3:**

```
Input: nums = [7,8,9,11,12]
Output: 1
```

 

**Constraints:**

- `1 <= nums.length <= 5 * 10^5`
- `-2^31 <= nums[i] <= 2^31 - 1`

#### 思路（[代码](Solution.java)）

最直观的思路就是从小到大排序，然后从 0 到 `nums.length` 遍历，找出第一个 `nums[i]!=i+1` 的元素，如果能找到，i+1就是所求；如果没找到，也就是 `nums` 刚好包含了 `1~n` 的整数序列，则 `nums.length+1` 就是所求。

但是题目限制 `O(N)` 的时间复杂度，通用的排序算法也就只能快到 `O(N*logN)`，所以是不适用的。

而能想到的 `O(N)` 的排序算法，是基于数组下标的归位排序：

> 辅助一个长度为 `M` 的数组 `s` ，数组元素初始化为 0 或 -1（取决于待排元素中是否有 0 ） ，对于每个待排元素 `nums[i]`，以 `nums[i]` 作为下标填充数组，至于所填的值，可以是 `nums[i]` 本身（`s[nums[i]] = nums[i]`），也可以是计数（`s[nums[i]] += 1`，为了应对待排元素有重复元素的情况），当所有元素都填充后，因为数组的下标是严格递增的，从 下标0 到 `nums.length` 扫描非 0 或 -1 元素，得到的序列就是从小到大递增了。
>
> 但是数组访问不能越界，即要满足 `0 <= nums[i] < M`，所以该算法的限制条件为所有待排元素是非负数且大小不能超过 `M-1`。

回到本题中，由于 `nums` 本身就是数组，所以可以省去 `O(N)` 的辅助空间，正好满足 `O(1)` 辅助空间的要求。

剩下就是 `nums[i]` 的大小范围问题，`-2^31 <= nums[i] <= 2^31 - 1` 显然不符合条件。但我们从本题需求出发，要找最小 miss 正整数，从 1 到 `nums.length`，即便 `nums` 一个不 miss，也顶多涵盖 `1~nums.length` 列表，这样的话 `nums.length+1` 则是我们要找的；一旦有 miss，则最小 miss 数肯定在 `1~nums.length` 之间。也就是说对于 `nums[i] > nums.length` 或 `nums[i] <= 0` 的元素不可能是我们寻找的目标，可以直接忽略，这样一来剩下的元素就符合范围要求了，然后直接用上述排序方式就OK了。

注意边界：最小 miss 数为 1 和 `nums.length+1` 的情况。