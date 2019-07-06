package org.sherlockyb.leetcode.array.validSudoku;

/**
 * @author yangbing
 */
public class Solution {
    private int[] filter = new int[10];

    public boolean isValidSudoku(char[][] board) {
        return isValidLine(board) && isValidSubBox(board);
    }
    
    private boolean isValidLine(char[][] board) {
        // 横线
        for (int i = 0; i < board.length; i++) {
            clearFilter(filter);
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int number = board[i][j] - '0';
                if (filter[number] == 1) {
                    return false;
                }

                filter[number] = 1;
            }
        }
        
        // 竖线
        for (int j = 0; j < board[0].length; j++) {
            clearFilter(filter);
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int number = board[i][j] - '0';
                if (filter[number] == 1) {
                    return false;
                }

                filter[number] = 1;
            }
        }

        return true;
    }

    private boolean isValidSubBox(char[][] board) {
        // 9x9小方格
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                clearFilter(filter);
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[k+i*3][l+j*3] == '.') {
                            continue;
                        }
                        int number = board[k+i*3][l+j*3] - '0';
                        if (filter[number] == 1) {
                            return false;
                        }

                        filter[number] = 1;
                    }
                }
            }
        }

        return true;
    }

    private void clearFilter(int[] filter) {
        for (int i = 0; i < filter.length; i++) {
            filter[i] = 0;
        }
    }
}