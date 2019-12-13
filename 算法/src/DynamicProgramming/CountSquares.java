package DynamicProgramming;
/*
动态规划题目七：
1277 统计全为一的正方体子矩阵
* 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，
* 请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。*/
/*
* dp[i][j] = 边长分别为ij的矩阵可以由1组成的正方形的个数也等于由该矩阵组成的最大边长
* 初始化：对于第一行和第一列，最大的正方形边长就 = matrix数组中该位置的数字
* 在初始化时，如果为1，表示对于[i][j]处的正方形就可以组成边长为一的一个，此时累加
* 对于dp[0][0]如果为1，因为会重复计算，就要给数量-1
* 状态转移方程：
* [i][j] == 0 时，表示没有能组成的正方形
* [i][j] == 1 时，每一处以[i][j]元素为右下角的矩阵能组成最大正方形边长为：
* [i-1][j] [i][j-1] [i-1][j-1] 三处组成的最大边长的最小值  再＋1（该处为1可增加1个边长）
* 并且累加数量*/
public class CountSquares {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        int [][]dp = new int[m][n] ;
        for(int i = 0; i < m; i++){
            dp[i][0] = matrix[i][0];
            result += matrix[i][0];
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j];
            result += matrix[0][j];
        }
        if(matrix[0][0] == 1){
            result --;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]) + 1;
                    result += dp[i][j];
                }
            }
        }
        return result;

    }
}
