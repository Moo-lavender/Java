/*
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

 

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
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

class Solution {
	//一、递归方法
    public int minimumTotal1(List<List<Integer>> triangle) {
        return dfs(triangle,0,0);
    }
    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) return 0;
        return Math.min(dfs(triangle,i+1,j),dfs(triangle,i+1,j+1)) + triangle.get(i).get(j);
    }
	//二、动态规划——自底向上（二维数组）
	Integer[][] memo;
    public int minimumTotal2(List<List<Integer>> triangle) {
        int m = triangle.size();
        memo = new Integer[m][m];
        for (int j = 0;j < m; j ++) {
            memo[m-1][j] = triangle.get(m-1).get(j);
        }
        dfs(triangle,m-2);
        return  memo[0][0];
    }

    private void dfs(List<List<Integer>> triangle, int i) {
        if (i < 0) {
            return;
        }
        for (int j = 0; j < triangle.get(i).size(); j++) {
            memo[i][j] = Math.min(memo[i+1][j],memo[i+1][j+1]) + triangle.get(i).get(j);
        }
        dfs(triangle,i-1);
    }
	//三、动态规划——自底向上（一维数组）
	Integer[] memo;
    public int minimumTotal3(List<List<Integer>> triangle) {
        int m = triangle.size();
        memo = new Integer[m];
        for (int j = 0;j < m; j ++) {
            memo[j] = triangle.get(m-1).get(j);
        }
        dfs(triangle,m-2);
        return  memo[0];
    }

    private void dfs(List<List<Integer>> triangle, int i) {
        if (i < 0) {
            return;
        }
        for (int j = 0; j < triangle.get(i).size(); j++) {
            memo[j] = Math.min(memo[j],memo[j+1]) + triangle.get(i).get(j);
        }
        dfs(triangle,i-1);
    }
}

