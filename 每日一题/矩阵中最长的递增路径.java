/*
329. 矩阵中的最长递增路径
给定一个整数矩阵，找出最长递增路径的长度。

对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。

示例 1:

输入: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
输出: 4 
解释: 最长递增路径为 [1, 2, 6, 9]。
示例 2:

输入: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
输出: 4 
解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
*/

class Solution {
    int row,col;
    int[][] memo;
    int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        row = matrix.length;
        col = matrix[0].length;
        memo = new int[row][col];
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                memo[i][j] = dfs(matrix,i,j);
                max = Math.max(max,memo[i][j]);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix,int row, int col) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        ++ memo[row][col];
        for (int i = 0; i < 4; i ++) {
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length && matrix[newRow][newCol] > matrix[row][col]) {
                memo[row][col] = Math.max(memo[row][col],dfs(matrix,newRow,newCol) + 1) ;
            }
        }
        return memo[row][col];
    }
}


