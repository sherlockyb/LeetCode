package org.sherlockyb.leetcode.backtracking.nQueens_51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author biyang
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        final List<List<String>> results = new ArrayList<>();
        final char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solver(n, board, 0, results);

        return results;
    }

    private void solver(final int n, final char[][] board, final int curRow, final List<List<String>> results) {
        if (curRow >= n) {
            return;
        }

        for (int curCol = 0; curCol < board[curRow].length; curCol++) {
            // column check
            boolean columnExistQ = false;
            for (int row = 0; row < curRow; row++) {
                if (board[row][curCol] == 'Q') {
                    columnExistQ = true;
                    break;
                }
            }
            if (columnExistQ) {
                continue;
            }

            // left diagonal check
            boolean diagonalExistQ = false;
            for (int row = curRow - 1, col = curCol - 1; row >= 0 && col >= 0; row--, col--) {
                if (board[row][col] == 'Q') {
                    diagonalExistQ = true;
                    break;
                }
            }
            if (diagonalExistQ) {
                continue;
            }
            // right diagonal check
            for (int row = curRow - 1, col = curCol + 1; row >= 0 && col < n; row--, col++) {
                if (board[row][col] == 'Q') {
                    diagonalExistQ = true;
                    break;
                }
            }
            if (diagonalExistQ) {
                continue;
            }

            // it's safe to place Q
            board[curRow][curCol] = 'Q';
            if (curRow == n - 1) {
                // all rows has been placed Q
                results.add(
                    Arrays.stream(board)
                        .map(String::new)
                        .collect(Collectors.toList())
                );
            }

            solver(n, board, curRow + 1, results);
            // rollback the position placed Q
            board[curRow][curCol] = '.';
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }
}
