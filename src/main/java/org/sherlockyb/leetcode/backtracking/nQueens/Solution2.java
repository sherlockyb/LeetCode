package org.sherlockyb.leetcode.backtracking.nQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author biyang
 */
public class Solution2 {
    public List<List<String>> solveNQueens(int n) {
        final List<List<String>> results = new ArrayList<>();
        final char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        final boolean[][] leftDiagonalExistQ = new boolean[n][n];
        final boolean[][] columnExistQ = new boolean[n][n];
        final boolean[][] rightDiagonalExistQ = new boolean[n][n];

        solver(n, board, 0, leftDiagonalExistQ, columnExistQ, rightDiagonalExistQ, results);

        return results;
    }

    private void solver(final int n, final char[][] board, final int curRow, final boolean[][] leftDiagonalExistQ,
        final boolean[][] columnExistQ, final boolean[][] rightDiagonalExistQ, final List<List<String>> results) {
        if (curRow >= n) {
            return;
        }

        for (int curCol = 0; curCol < board[curRow].length; curCol++) {
            // 下面这一步初始化很关键。因为我们每次回溯的时候只会回溯当前位置[curRow, curCol]的Q填充和对应flag，对于下方剩余行列flag不会进行
            // 回溯，因而经过多次递归之后，特定位置的flag已经不是最初的默认值false了，要么在每次进入到该位置的最开始时初始化为false（就像现在这
            // 样），要么在下面的if后直接else置为false
            leftDiagonalExistQ[curRow][curCol] = false;
            columnExistQ[curRow][curCol] = false;
            rightDiagonalExistQ[curRow][curCol] = false;

            if (curRow > 0 && curCol > 0 && leftDiagonalExistQ[curRow - 1][curCol - 1]) {
                leftDiagonalExistQ[curRow][curCol] = true;
            }
            if (curRow > 0 && columnExistQ[curRow - 1][curCol]) {
                columnExistQ[curRow][curCol] = true;
            }
            if (curRow > 0 && curCol < n - 1 && rightDiagonalExistQ[curRow - 1][curCol + 1]) {
                rightDiagonalExistQ[curRow][curCol] = true;
            }

            if (leftDiagonalExistQ[curRow][curCol] || columnExistQ[curRow][curCol] || rightDiagonalExistQ[curRow][curCol]) {
                continue;
            }

            // it's safe to place Q
            board[curRow][curCol] = 'Q';
            leftDiagonalExistQ[curRow][curCol] = true;
            columnExistQ[curRow][curCol] = true;
            rightDiagonalExistQ[curRow][curCol] = true;

            // update remaining columns of flag metric
            if (curRow > 0) {
                for (int remainingCol = curCol + 1; remainingCol < n; remainingCol++) {
                    leftDiagonalExistQ[curRow][remainingCol] = leftDiagonalExistQ[curRow - 1][remainingCol - 1];
                    columnExistQ[curRow][remainingCol] = columnExistQ[curRow - 1][remainingCol];
                    if (remainingCol < n - 1) {
                        rightDiagonalExistQ[curRow][remainingCol] = rightDiagonalExistQ[curRow - 1][remainingCol + 1];
                    }
                }
            }

            if (curRow == n - 1) {
                // all rows has been placed Q
                results.add(
                    Arrays.stream(board)
                        .map(String::new)
                        .collect(Collectors.toList())
                );
            }

            solver(n, board, curRow + 1, leftDiagonalExistQ, columnExistQ, rightDiagonalExistQ, results);
            // rollback the position placed Q and existFlags
            board[curRow][curCol] = '.';
            leftDiagonalExistQ[curRow][curCol] = false;
            columnExistQ[curRow][curCol] = false;
            rightDiagonalExistQ[curRow][curCol] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().solveNQueens(6));
    }
}
