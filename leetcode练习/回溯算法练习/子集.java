/*
78. 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        back(nums,0);
        return res;
    }

    private void back(int[] nums, int index) {
        res.add(new ArrayList(tmp));

        for (int i = index; i < nums.length; i ++) {
            tmp.add(nums[i]);
            back(nums,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}