/*
给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。

示例 1:
输入:

"bbbab"
输出:

4
一个可能的最长回文子序列为 "bbbb"。

示例 2:
输入:

"cbbd"
输出:

2
一个可能的最长回文子序列为 "bb"。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
	//最长子序列不需要连续
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (s == null || n == 0) {
            return 0;
        }

        //dp[i][j] 表示字符串从i到j的最长回文子序列
        int[][]dp = new int[n][n];
        for (int i = 0; i < n; i ++) {
            dp[i][i] = 1;
        }

        for (int i = n-1; i >= 0; i --){
            for (int j = i + 1; j < n; j ++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;//如果i，j位置的元素相同，那么就相当于i+1到j-1的长度加2
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]); //如果不相同，就相当于找i~j-1和i+1到j的最长长度
                }
            }
        }
        return dp[0][n-1];
    }
}