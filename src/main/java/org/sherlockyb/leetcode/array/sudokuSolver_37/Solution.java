package org.sherlockyb.leetcode.array.sudokuSolver_37;


/**
 * @author yangbing
 */
public class Solution {

    public void solveSudoku(char[][] board) {
        fillSudokuCell(board, 0, 0);
    }

    private boolean fillSudokuCell(char[][] board, int i, int j) {
        if (i == -1) {
            return true;
        }

        if (board[i][j] != '.') {
            // 非填充单元格，直接forward
            int nextI = getNextCellRowIdx(board, i, j);
            int nextJ = getNextCellColIdx(board, i, j);
            return fillSudokuCell(board, nextI, nextJ);
        }

        for (int k = 1; k <= 9; k++) {
            char digit = (char) ('0' + k);
            if (isValidCellDigit(board, i, j, digit)) {
                board[i][j] = digit;
                // forward if needed
                int nextI = getNextCellRowIdx(board, i, j);
                int nextJ = getNextCellColIdx(board, i, j);

                boolean fillSucceed = fillSudokuCell(board, nextI, nextJ);
                if (!fillSucceed) {
                    // 回溯
                    board[i][j] = '.';
                } else {
                    return true;
                }
            }
        }

        // 1~9都不行，当前单元格填充失败
        return false;
    }

    private int getNextCellRowIdx(char[][] board, int i, int j) {
        if (j != board[i].length - 1) {
            return i;
        }

        if (i == board.length - 1) {
            return -1;
        }

        return i + 1;
    }

    private int getNextCellColIdx(char[][] board, int i, int j) {
        if (j != board[i].length - 1) {
            return j + 1;
        }

        if (i == board.length - 1) {
            return -1;
        }

        return 0;
    }

    private boolean isValidCellDigit(char[][] board, int i, int j, char digit) {
        // 横向
        int rowNum = board.length;
        int colNum = board[i].length;
        for (int k = 0; k < colNum; k++) {
            if (k == j || board[i][k] == '.') {
                continue;
            }

            if (board[i][k] == digit) {
                return false;
            }
        }

        // 纵向
        for (int k = 0; k < rowNum; k++) {
            if (k == i || board[k][j] == '.') {
                continue;
            }

            if (board[k][j] == digit) {
                return false;
            }
        }

        // 3x3 subBox
        int rowStart = i/3 * 3;
        int colStart = j/3 * 3;
        for (int k = rowStart; k < rowStart + 3; k++) {
            for (int l = colStart; l < colStart + 3; l++) {
                if (k == i && l == j || board[k][l] == '.') {
                    continue;
                }

                if (board[k][l] == digit) {
                    return false;
                }
            }
        }

        return true;
    }
}