/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        Arrays.sort(nums);
        if (nums[0] > 0) return list;
        int n = nums.length;

        for (int i = 0; i < n; i ++) {
            if (i > 0  && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1,right = n-1;
            while(left < right) {
                int add = nums[i] + nums[left] + nums[right];
                if (add == 0) {
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left ++;
                    while (left < right && nums[right] == nums[right-1]) right --;
                    left ++;
                    right --;
                }else if (add > 0) {
                    while (left < right && nums[right] == nums[right-1]) right --;
                    right --;
                }else {
                    while (left < right && nums[left] == nums[left+1]) left ++;
                    left ++;
                }
            }
        }
        return list;
    }
}