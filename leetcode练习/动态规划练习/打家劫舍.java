/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:

输入: [1,2,3,1]
输出: 4
解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 2:

输入: [2,7,9,3,1]
输出: 12
解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int rob(int[] nums) {
		//0 不偷 1偷
        int[][] dp = new int[nums.length][2];
        if (nums.length > 0){//第一天偷的话的金钱 不偷的话为0，默认就是0，不用处理。
            dp[0][1] = nums[0];
        }else {
            return 0;
        }
        for (int i = 1; i <nums.length ; i++) {
            dp[i][1] = dp[i-1][0]+nums[i];
            dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
        }
        return Math.max(dp[nums.length-1][1],dp[nums.length-1][0]);
    }
    public int rob2(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int prv = 0; //到达第i-1家时，得到的最大利益
        int cur = nums[0]; //到达第i家时得到的最大利益
        for (int i = 1; i < nums.length; i ++) {
            int tmp = prv;
            prv = cur;
            cur = Math.max(tmp + nums[i],cur);
        }
        return prv > cur ? prv : cur;
    }
}