package org.sherlockyb.leetcode.math.rotateImage;

/**
 * @author biyang
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }

        // 中心小正方形的坐标，当 N 为偶数时，中心小正方形不存在
        final boolean odd = matrix.length % 2 == 1;
        final int middle = matrix.length / 2;

        // 以对角线的方向，遍历左上顶点，从而从外到内遍历每个正方形
        for (int row = 0; row < middle; row++) {
            final int col = row;
            final int currentSquareLen = (middle - col) * 2 + (odd ? 1: 0);
            final int rightUpVertexCol = col + currentSquareLen - 1;
            final int rightDownVertexCol = rightUpVertexCol;
            final int rightDownVertexRow = row + currentSquareLen - 1;
            for (int startCol = col; startCol < col + currentSquareLen - 1; startCol++) {
                // first move
                final int firstNextRow = row + startCol - col;
                final int firstNextCol = rightUpVertexCol;
                int firstTemp = matrix[firstNextRow][firstNextCol];
                matrix[firstNextRow][firstNextCol] = matrix[row][startCol];

                // second move
                final int secondNextRow = rightDownVertexRow;
                final int secondNextCol = rightDownVertexCol - (startCol - col);
                int secondTemp = matrix[secondNextRow][secondNextCol];
                matrix[secondNextRow][secondNextCol] = firstTemp;

                // third move
                final int thirdNextRow = rightDownVertexRow - (startCol - col);
                final int thirdNextCol = col;
                int thirdTemp = matrix[thirdNextRow][thirdNextCol];
                matrix[thirdNextRow][thirdNextCol] = secondTemp;

                // forth move
                final int forthNextRow = row;
                final int forthNextCol = startCol;
                matrix[forthNextRow][forthNextCol] = thirdTemp;
            }
        }
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int[][] matrix1 = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        solution.rotate(matrix1);
    }
}
