### 40. Combination Sum II

Given a collection of candidate numbers (`candidates`) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sum to `target`.

Each number in `candidates` may only be used **once** in the combination.

**Note:** The solution set must not contain duplicate combinations.

 

**Example 1:**

```
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
```

**Example 2:**

```
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
```

 

**Constraints:**

- `1 <= candidates.length <= 100`
- `1 <= candidates[i] <= 50`
- `1 <= target <= 30`

#### 思路（[代码](Solution.java)）

[Combination Sum](https://leetcode.com/problems/combination-sum/) 的简化版，相当于 candidates 中每个元素的出现次数从任意次简化为0/1次。

其实可以直接复用其代码，只不过将循环的target改为1就行。但是考虑到0或1，写成循环有点怪怪的，用if-else更合适，从而成为了 [代码](Solution.java) 里面的样子。