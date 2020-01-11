public class FindGreatestSumOfSubArray {
    public int findGreatestSumOfSubArray(int[] array) {
        //设置dp数组中以i结尾的最大数组和
        int[] dp = new int[array.length];
        int max = array[0];
        dp[0] = array[0];
        for(int i = 1; i < array.length; i++){
            int add = dp[i-1]+array[i];
            dp[i] = add > array[i] ? add : array[i];
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}