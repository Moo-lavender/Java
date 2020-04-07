/*
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int row = triangle.size();
        int col = triangle.get(row - 1).size();

        int[][] dp = new int[row][col];  //dp[i][j]表示从头到i，j位置的路径最短
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < row; i ++) {
            for (int j = 0; j < triangle.get(i).size(); j ++) {
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];
                }else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
                }else { 
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j-1],dp[i-1][j]);
                }
            }
        } 
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < col; j ++) {
            int tmp = dp[row-1][j];
            if (tmp < min) {
                min = tmp;
            }
        }
        return min;
    }
}