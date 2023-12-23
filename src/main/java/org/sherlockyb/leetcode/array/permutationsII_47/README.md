### 47. Permutations II

- Given a collection of numbers, `nums`, that might contain duplicates, return *all possible unique permutations **in any order**.*

   

  **Example 1:**

  ```
  Input: nums = [1,1,2]
  Output:
  [[1,1,2],
   [1,2,1],
   [2,1,1]]
  ```

  **Example 2:**

  ```
  Input: nums = [1,2,3]
  Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  ```

   

  **Constraints:**

  - `1 <= nums.length <= 8`
  - `-10 <= nums[i] <= 10`

#### 思路（[代码](Solution.java)）

##### 朴素的思路：仍然是穷举遍历

但是跟 [Permutations](https://leetcode.com/problems/permutations/) 不同的是，待排列的元素存在重复，所以要剔除重复元素对应的排列，在代码层面如何实现剔除呢？

从示例中可以看出，对于重复的多个元素，往同一个位置放多次，并不会产生新的排列，所以将某个待排列元素放置目的位置时，若之前已经放置过同样值的元素，则应忽略这样的交换带来的所有排列。