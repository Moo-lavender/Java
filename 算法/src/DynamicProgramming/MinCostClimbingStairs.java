package DynamicProgramming;
/*
动态规划题目七：
Leetcode 746 使用最小花费爬楼梯
*
数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
*/
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {0,0,1,1};
        System.out.println(minCostClimbingStairs(cost));
    }

    //二维数组 时间O(N)空间O(N)
    public static int minCostClimbingStairs(int[] cost) {
        int[][] dp  = new int[cost.length + 1][2];
        //当前站在i楼梯上时所需要的最小体力
        //1 站在   0  不站在
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = cost[0];
        dp[1][1] = 0;
        for(int i = 2; i < cost.length + 1; i++){
            dp[i][0] = dp[i-1][1] + cost[i-1];
            dp[i][1] = Math.min(dp[i-1][1]+cost[i-1],dp[i-2][1]+cost[i-2]);
        }
        int result = Math.min(dp[cost.length ][0],dp[cost.length][1]);
        return result;
    }

    //一维数组 时间O(N)空间O(N) 但是执行时间变少了
    public static int minCostClimbingStairs2(int[] cost){
        //dp数组的每一个元素表示到达当前楼层所需的最小花费
        //也就是dp的第i个值是不包含cost[i]的，因为还没从第i层走出去，没消耗体力
        //dp的长度=cost+1，dp的最后一个元素就是到达楼顶所需的最小花费
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;//因为最开始可以选择起点，而选择起点是不消耗体力的
        for(int i=2; i<dp.length; i++){
            //要么从第i-2层走到第i层，从要么第i-1层走到第i层
            dp[i] = Math.min(dp[i-2]+cost[i-2], dp[i-1]+cost[i-1]);
        }
        return dp[dp.length-1];
    }

}
