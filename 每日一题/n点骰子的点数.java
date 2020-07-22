/*
把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。

 

你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

 

示例 1:

输入: 1
输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
示例 2:

输入: 2
输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 

限制：

1 <= n <= 11

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

class Solution {
    //dp[i][j]表示投出i个骰子，j点数出现的次数
    public double[] twoSum(int n) {
        if (n <= 0) return new double[]{};
        int[][] dp = new int[15][70];
        for (int j = 1; j <= 6; j ++) {   //第一个骰子掷出的各个点数的次数
            dp[1][j] = 1;
        }
        
        for (int i = 2; i <= n; i ++) {    //第i个筛子
            for (int j = i; j <= i*6; j ++) {  //各个点数
                for (int t = 1; t <= 6; t++) {//第i个骰子可能掷出的点数
                    if (j-t <= 0) break;
                    dp[i][j] += dp[i-1][j-t];
                }
            }
        }

        double sum = Math.pow(6,n);
        double[] res = new double[6*n-n+1];
        for (int j = n; j <= 6*n; j ++) {
            res[j-n] = dp[n][j]*1.0/sum;
        }
        return res;
    }
}
