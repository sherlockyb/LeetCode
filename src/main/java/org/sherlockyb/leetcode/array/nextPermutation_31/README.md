### 31. Next Permutation

Implement **next permutation**, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be **in-place** and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

```
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
```

#### 思路（[代码](Solution.java)）

理解清楚题目规则比较重要！重点语句：**the lexicographically next greater permutation**，在字典序上，下一个更大的元素。即不仅要找一个比它大的，而且还是当中最靠前的，即排序上紧挨着它的。

首先，找一个比当前排列在字典序上更大的排列。直观来讲，如果能找到一个高位（靠左的）比低位小的数字对，进行交换，就能得到一个更大的排列。但是题目的要求是次大，即所有比当前排列大的排列中，最小的。那么这个可交换的数字对的第一个数字就要尽可能靠右，因为过于靠左就有点“用力过猛”了。那么怎么找到第一个数字尽可能靠右的可交换数字对呢？可采用策略：从右边最后一个元素开始，在前面的子序列中找到比它小的数字，如果没有，则再以倒数第二个数字为起点继续；如果找到了，我们记为`<a1,b1>`，接着我们再看`<a1,b1>`之间的子序列，按照上述过程递归找第二个`<a2,b2>`，直到找到`<a,b>`使得`a`最靠右。

找到最合适的交换数字对`<a,b>`后，进行交换，但此时并没有完！因为这个时候该排列还不是最靠近目标排列的——交换后，数字`b`后面的子序列并不一定是最小序列，因此还需要将子序列进行升序排列，确保其最小。例如对于`1,6,2,4,5,4,2,1`，最合适的交换数字对为`<4,5>`，交换后，`5`后面的子序列为`4,4,2,1`，此时一看就不是最小的，将其升序排列之后得到`1,2,4,4`，这样就能得到最终的次大排列`1,6,2,5,1,2,4,4`

