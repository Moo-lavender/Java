package DynamicProgramming;
/*
动态规划题目二：
* 最大连续子数组的和
* dp数组中存放着以i为结束的最大的子数组的和
* 一定注意是以i结束 */
public class MaxArrSum {
    public static int maxArrSum(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxArrSum(nums));
    }
}
