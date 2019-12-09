import java.util.*;
/*

动态规划算法。dp[i][j]代表用前i个数字凑到j最多有多少种方案。
dp[i][j]=dp[i-1][j];   //不用第i个数字能凑到j的最多情况
dp[j][j]+=dp[i-1][j-value[i]];  //用了i时，只需要看原来凑到j-value[i]的最多情况即可。并累加
dp[0]=1;  //初始化，表示凑到0永远有1种方案。
*/
public class NumSumCount{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int[] value = new int[n];
        long[] dp = new long[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            value[i] = in.nextInt();
            for (int j = sum; j >= 0; j--) {
                if (j >= value[i]) {
                    dp[j] += dp[j - value[i]];
                }
            }
            for(int a = 0; a < sum+ 1; a++){
                System.out.print(dp[a]);

            }System.out.println();
        }

        //System.out.println(dp[sum]);
    }
}

