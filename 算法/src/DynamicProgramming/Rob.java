package DynamicProgramming;
/*
动态规划题目六：
打家劫舍
* 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
* 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
* 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
* 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
*/
public class Rob {
    public int rob(int[] nums) {
//0 不偷 1偷
        int[][] dp = new int[nums.length][2];
        if (nums.length > 0){//第一天偷的话的金钱 不偷的话为0，默认就是0，不用处理。
            dp[0][1] = Math.max(0,nums[0]);
        }else {
            return 0;
        }
        for (int i = 1; i <nums.length ; i++) {
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][0]+nums[i]/*上次不偷+这次偷*/);
            dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
        }
        return Math.max(dp[nums.length-1][1],dp[nums.length-1][0]);
    }
}
