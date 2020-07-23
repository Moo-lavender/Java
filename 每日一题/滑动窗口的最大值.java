/*
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
	//暴力
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i ++) {
            int left = i, right = i+k;
            int max = nums[left];
            for (int j = left; j < right; j ++) {
                max = Math.max(max,nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
	//单调队列
	
}