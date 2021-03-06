/*
编写一个程序，找出第 n 个丑数。

丑数就是只包含质因数 2, 3, 5 的正整数。

示例:

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:  

1 是丑数。
n 不超过1690。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ugly-number-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int nthUglyNumber(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0,i3 = 0,i5 = 0; 
        for(int i = 1; i < n; i ++) {
            dp[i] = Math.min(Math.min(2*dp[i2],3*dp[i3]),5*dp[i5]);
            if (dp[i] == 2*dp[i2]) {
                i2 ++;
            }
            if (dp[i] == 3*dp[i3]) {
                i3 ++;
            }
            if (dp[i] == 5*dp[i5]){
                i5 ++;
            }
        }
        return dp[n-1];
    }
}