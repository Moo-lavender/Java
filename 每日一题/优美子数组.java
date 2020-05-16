/*
1248. 统计「优美子数组」
给你一个整数数组 nums 和一个整数 k。

如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。

请返回这个数组中「优美子数组」的数目。

 

示例 1：

输入：nums = [1,1,2,1,1], k = 3
输出：2
解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
示例 2：

输入：nums = [2,4,6], k = 1
输出：0
解释：数列中不包含任何奇数，所以不存在优美子数组。
示例 3：

输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
输出：16
 

提示：

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
*/
class Solution {
	//执行用时 :60 ms, 在所有 Java 提交中击败了5.16%的用户
	//内存消耗 :49.6 MB, 在所有 Java 提交中击败了100.00%的用户
    public int numberOfSubarrays1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }

        int count = 0;
        int prv = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] % 2 != 0) {
                prv += 1;
            } 
            if (map.containsKey(prv-k)) {
                count += map.get(prv-k);
            }
            if (map.containsKey(prv)) {
                map.put(prv,map.get(prv)+1);
            }else{
                map.put(prv,1);
            }
        }
        return count;
    }
	
	//执行用时 :3 ms, 在所有 Java 提交中击败了100.00%的用户
	//内存消耗 :48.5 MB, 在所有 Java 提交中击败了100.00%的用户
	public int numberOfSubarrays2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }

        int count = 0;
        int prv = 0;
        //下标为前缀和，值为个数
        int[] arr = new int[nums.length+1];
        arr[0] = 1;
        for (int i = 0; i < nums.length; i ++) {
            prv += (nums[i] & 1); 
            arr[prv] ++;
            if (prv >= k) {
                count += arr[prv-k];
            }
        }
        return count;
    }
	
}