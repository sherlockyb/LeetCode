### 51. N-Queens

The **n-queens** puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.

Given an integer `n`, return *all distinct solutions to the **n-queens puzzle***. You may return the answer in **any order**.

Each solution contains a distinct board configuration of the n-queens' placement, where `'Q'` and `'.'` both indicate a queen and an empty space, respectively.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2020/11/13/queens.jpg)

```
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
```

**Example 2:**

```
Input: n = 1
Output: [["Q"]]
```

 

**Constraints:**

- `1 <= n <= 9`

#### 思路

第一版，逐行填充，穷举+剪枝。

填充第 `curRow` 行第 `curCol` 列时，判断前 `row-1` 行中，以当前位置 `board[curRow][curCol]` 往上方辐射的垂直、左对角线和右对角线上有无已填充的 Q，一旦发现有，则继续当前行的下一个列位置，直到最后一行。当所有行都填充了一个 Q 时，就得到一个有效解，把所有解都收齐即可，见[代码](Solution.java)。

第二版优化。

从第一版的解题过程中会发现，当我们判断位置 `board[curRow][curCol]`  上方的垂直、左右对角线上有无 Q 时，每次都是从第 0 行到第 `curRow-1` 行逐个判断，其实第 0 行到第 `curRow-2` 行是否有 Q 的情况，在填充第 `curRow-1` 行时已经判断过，以此类推，有非常多的重复计算。我们可以用 3 个大小为 `n x n` 的二维数组 leftDiagonalExistQ、columnExistQ 和 rightDiagonalExistQ 来分别存储每个位置上方的左对角线、垂直和右对角线方向（包括当前位置本身）是否有Q，这样当填充当前行时，可以直接利用三个数组中对应上一行的信息来判断，并且还要针对当前位置更新三个数组对应位置的值，以便下一行使用。

> 具体而言，对于位置 `board[curRow][curCol]` ，当判断左对角线是否有 Q 时，可直接根据 `leftDiagonalExistQ[curRow-1][curCol-1]` 是否为true 来判断其上方左对角线是否有 Q。而当前位置对应 `leftDiagonalExistQ[curRow][curCol]` 的值则根据其左上角位置 `leftDiagonalExistQ[curRow-1][curCol-1]` 是否为 true 以及当前位置是否填 Q 来综合判断并更新。
>
> 对于另外的垂直和右对角线两个方向，是类似的道理，就不复述了。

见[代码2](Solution2.java)。