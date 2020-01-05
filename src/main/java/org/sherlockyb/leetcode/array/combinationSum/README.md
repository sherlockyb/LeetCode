### 39. Combination Sum

Given a **set** of candidate numbers (`candidates`) **(without duplicates)** and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sums to `target`.

The **same** repeated number may be chosen from `candidates` unlimited number of times.

**Note:**

- All numbers (including `target`) will be positive integers.
- The solution set must not contain duplicate combinations.

**Example 1:**

```
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
```

**Example 2:**

```
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```

#### 思路（[代码](Solution.java)）

这种排列组合类的题，比较直接的思路就是暴力穷举+剪枝。

具体思路：在加和组成target的加数中，candidates中每一个元素都可能出现0到target次，因此可以定义一个跟candidates同等大小的系数数组coefficients，数组中每一个元素，都从0到target逐渐遍历，所有求和等于target的组合都是符合条件的系数组合，找到这些系数组合，就能得到最终的加数组合列表。

思路是自然的，但代码如何实现呢？最坏的时间复杂度为*O(target^N)*，N是coefficients的大小。如果N是确定的，我们可以写N层嵌套循环，然后在循环的每一层判断当前子序列的求和是否达到target，如果超过target，就剪枝直接回溯到上层循环。

但问题是N是不确定的，编程语言还没法支持我们可以直接动态地写N层嵌套循环，那有没有其他间接地方式来实现“N层嵌套”的效果呢？有的，那就是递归。

接下来问题就转变为如何将“N层嵌套”转为递归。指导思想：

> N层嵌套之间不同的部分，作为递归的参数，参数的变化与嵌套之间的变化对应；N层嵌套之间相同的部分作为递归的内容，随着递归的进行，重复执行

如果对上面的套路不熟悉，我们不妨一步步来。

我们先尝试把“N层嵌套”写出来，看看是什么样子，对于本问题，代码大致如下：

```java
for(coefficients[0] = 0; coefficients[0] <= target; coefficients[0]++) {
    if(partialSum(candidates, coefficients, 0, target, results)) {
        return ;
    }
    for(coefficients[1] = 0; coefficients[1] <= target; coefficients[1]++) {
        if(partialSum(candidates, coefficients, 1, target, results)) {
            return ;
        }
        for(coefficients[2] = 0; coefficient[2] <= target; coefficients[2]++)
            ...
    }
}

private boolean partialSum(int[] candidates, int[] coefficients, int i, int target, List<List<Integer>> results) {
    // 对candidates中前i个元素（包含i）按照coefficients中前i个系数进行求和，如果等于target，则将当前系数组合对应的加数组合添加到结果results中；如果大于target，则无需进行后续的操作，直接剪枝
}
```

根据上述指导思想，“N层嵌套”之间变化的部分是coefficients的下标，从0~N变化，则递归函数中加一个int类型的下标变量`i`，取值从0开始，每次递归时向上累加；“N层嵌套”之间相同的部分，则是for循环语句和`partialSum`的调用处理，将它们作为递归函数的主体内容，这样就可以得到递归代码如下：

```java
private void sum(int[] candidates, int[] coefficients, int i, int target, List<List<Integer>> results) {
    if(i >= coefficients.length) {
        // 递归终止条件
        return;
    }
    for(coefficients[i] = 0; coefficients[i] <= target; coefficients[i]++) {
        if(partialSum(candidates, coefficients, i, target, results)) {
            return;
        }
        sum(candidates, coefficients, i+1, target, results);
    }
}
```

##### 优化的空间

上述递归的代码实现，存在比较多的重复计算，主要是`partialSum`中，计算前`i`个元素的组合求和时，实际上前`i-1`个元素的所有组合求和在上一层递归中已经计算过了，这里又会算一遍。对于这种可以利用子最优解的结果的情况，会很自然地想到动态规划，用空间换时间，把当前前`i`个元素的所有组合求和都存下来，这样对于每一种组合的求和，只用算一次。