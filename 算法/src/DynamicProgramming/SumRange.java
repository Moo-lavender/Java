package DynamicProgramming;
/*
动态规划题目六：
303区域和检索——数组不可变
* 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
* 你可以假设数组不可变。
* 会多次调用 sumRange 方法*/

public class SumRange {
    /*二维数组——超过内存了
   private int[][] dp;
    public SumRange(int[] nums) {
        dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++){
            for(int j = i;j < nums.length; j++){
                if(i == j){
                    dp[i][j] = nums[i];
                }else{
                    dp[i][j] = dp[i][j-1] + nums[j];
                }
            }
        }
    }

    public int sumRange(int i, int j) {
       return dp[i][j];
    }
    */
//一维数组
    private int[] dp;
    public SumRange(int[] nums) {
        dp = new int[nums.length];
        if(nums.length == 0){
            return;
        }
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = dp[i- 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0){
            return dp[j];
        }else{
            return dp[j] - dp[i - 1];
        }
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
 /*
 -2   0   3   -5     2    -1

dp[0][0] = nums[0];
dp[i][i] = nums[i];
if(i > j){

}
dp[i][j] = dp[i][j- 1] + nums[j];
     -2   0   3   -5    2    -1

i j   0   1   2    3    4    5
 0   -2  -2   1   -4   -2    -3
 1    0   0   3   -2    0    -1
 2    0   0   3   -2    0    -1
 3    0   0   0   -5   -3    -4
 4    0   0   0    0    2    -1
 5    0   0   0    0    0    -1
 */

