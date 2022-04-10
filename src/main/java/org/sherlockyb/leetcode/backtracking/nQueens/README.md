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

从第一版的解题过程中会发现，当我们判断位置 `board[curRow][curCol]`  上方的垂直、左右对角线上有无 Q 时，每次都是从第 0 行到第 `curRow-1` 行逐个判断，其实第 0 行到第 `curRow-2` 行是否有 Q 的情况，在填充第 `curRow-1` 行时已经判断过，以此类推，有非常多的重复计算。我们可以用 3 个大小为 n 的行数组 leftDiagonalExistQ、columnExistQ 和 rightDiagonalExistQ 来分别存储当前行的每个位置上方的左对角线、垂直和右对角线方向是否有Q，这样当填充下一行时，可以直接利用三个数组的信息来判断，并且还要针对下一行更新三个数组，以便下下行使用。

> 具体而言，对于位置 `board[curRow][curCol]` ，当判断左对角线是否有 Q 时，可直接根据其左上方的位置是否是 Q 以及 `leftDiagonalExistQ[curCol-1]` 是否为true 来判断其上方整个对角线是否有 Q。这里解释下对于数组 `leftDiagonalExistQ` 为何是取 `curCol-1`，因为 `leftDiagonalExistQ[curCol-1]` 正是表示位置 `board[curRow-1][curCol-1]` 的上方左对角线是否有 Q，而该位置正处于位置 `board[curRow][curCol]` 的左上方，二者共一条左对角线。再加上该位置本身是否为 Q，则完整包含了位置 `board[curRow][curCol]` 上方的左对角线是否包含 Q的情况。
>
> 对于另外的垂直和右对角线两个方向，是同样的道理，就不复述了。
>
> 至于三个辅助数组的更新，则是根据上一行的每个位置是否是 Q 并结合数组当前的值进行更新。

对于三个辅助数组的更新，有个细节要注意，

> 由于存在覆盖问题，所以三个辅助数组的更新方向各有讲究。对于左对角线，``leftDiagonalExistQ` 针对当前行的第 `col` 列的值依赖针对上一行时前一列 `col-1` 的值，如果从左到右，则针对当前行填充位置 `curCol` 的数组值时，会覆盖针对上一行同样列位置的数组值，那当填充第 `curCol+1` 列时，针对上一行第 `curCol` 列的值是不对的，故应该从右到左；对于右对角线，则相反；对于垂直方向，因为没有前后列依赖关系，故两种方向都行。

见[代码2](Solution2.java)。