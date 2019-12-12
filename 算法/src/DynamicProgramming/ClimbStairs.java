package DynamicProgramming;
/*
动态规划题目三：
* 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
* 每次你可以爬 1 或 2 个台阶。
* 你有多少种不同的方法可以爬到楼顶呢？*/
public class ClimbStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2; i < n + 1; i++){
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(5));
    }
}
