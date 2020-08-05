/*
926. 将字符串翻转到单调递增
如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。

我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。

返回使 S 单调递增的最小翻转次数。

 

示例 1：

输入："00110"
输出：1
解释：我们翻转最后一位得到 00111.
*/
class Solution {
    public int minFlipsMonoIncr(String S) {
        int[][] dp = new int[S.length()+1][2];
        for(int i = 1; i <= S.length(); i ++){
            if(S.charAt(i-1) == '0'){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.min(dp[i-1][0] , dp[i-1][1])+1;
            }else{
                dp[i][0] = dp[i-1][0]+1;
                dp[i][1] = Math.min(dp[i-1][0] , dp[i-1][1]);
            }
        }
        return Math.min(dp[S.length()][0],dp[S.length()][1]);
    }
}