/*
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
	//时间O(mn)空间O(mn)
    public int maximalSquare1(char[][] matrix) {
        //dp[i][j] 表示以ij处为正方形右下角的最大边长
        //dp[i][j] = 1 + Math.min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])
        int row = matrix.length;
        if (row == 0 || matrix == null) {
            return 0;
        }
        int col = matrix[0].length;
        int max = 0;

        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else{
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                    }
                } 
                max =  dp[i][j] > max ? dp[i][j] : max;
            }
        }
        return max * max;
    }
	
	
	//时间O(mn)空间O(n)
	public int maximalSquare2(char[][] matrix) {
		//创建一维数组表示每一行，prv变量表示左上方
        int row = matrix.length;
        if (row == 0 || matrix == null) {
            return 0;
        }
        int col = matrix[0].length;
        int max = 0;

        int[] dp = new int[col];
        int prv = 0; //相当于dp[i-1][j-1]

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    prv = dp[j]; // 要在dp[j]覆盖前更新prv的值
                    dp[j] = matrix[i][j] - '0';
                } else{
                    if (matrix[i][j] == '0') {
                        prv = dp[j];
                        dp[j] = 0;
                        
                    } else {
                        int tmp = dp[j];
                        dp[j] = 1 + Math.min(Math.min(dp[j],dp[j-1]),prv); 
                        prv = tmp; 
                    }
                } 
                max =  dp[j] > max ? dp[j] : max;
            }
        }
        return max * max;
    }
}