/*
给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。

示例 1:

输入: [23,2,4,6,7], k = 6
输出: True
解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
示例 2:

输入: [23,2,6,4,7], k = 6
输出: True
解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
说明:

数组的长度不会超过10,000。
你可以认为所有数字总和在 32 位有符号整数范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/continuous-subarray-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        for(int i = 0; i < nums.length-1; ++i) {
            if(nums[i] == 0 && nums[i+1] == 0)
                return true;
        }
        if(k == 0) return false;
        if(k < 0) k = -k;

        //key是前缀和%k，val是数字下标
        HashMap<Integer,Integer> map = new HashMap<>();
        int prv = 0;
        map.put(0,-1);

        for (int i = 0; i < nums.length; i ++) {
            prv += nums[i];
            int mod = prv % k;
            if(map.containsKey(mod)) {
                if(i-map.get(mod) > 1)
                    return true;
            }else {
                map.put(mod,i);
            }
        }
        return false;
    }
}