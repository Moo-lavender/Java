/*
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :

输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
说明 :

数组的长度为 [1, 20,000]。
数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
	//执行用时 :577 ms, 在所有 Java 提交中击败了5.的用户
	//内存消耗 :41 MB, 7.69%的用户
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < n; i ++) {
            int sum = 0;
            for (int j = i; j < n; j ++) {
                sum += nums[j];
                
                if (sum == k) {
                    count ++;
                }
            }
        }
        return count;
    }
	//使用前缀和
	public int subarraySum(int[] nums, int k) {
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(0,1);
		int count = 0;
		int prv = 0;
		for (int i = 0; i < nums.length; i ++) {
			prv += nums[i];

			if (map.containsKey(prv - k)) {
				int val = map.get(prv-k);
				count += val;
			}
			if (map.containsKey(prv)) {
				map.put(prv,map.get(prv)+1);
			}else{
				map.put(prv,1);
			}
			//map.put(prv,map.getOrDefault(prv,0) + 1);
		}
		return count;
    }
	
}