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

逐行填充，穷举+剪枝。

填充第 `curRow` 行第 `curCol` 列时，判断前 `row-1` 行中，以当前位置 `board[curRow][curCol]` 往上方辐射的垂直、左对角线和右对角线上有无已填充的 Q，一旦发现有，则继续当前行的下一个列位置，直到最后一行。当所有行都填充了一个 Q 时，就得到一个有效解，把所有解都收齐即可，见[代码](Solution.java)。