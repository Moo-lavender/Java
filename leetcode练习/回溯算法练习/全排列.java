/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>(); //结果集
    List<Integer> tmp = new ArrayList<>();  //已选择
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        back(nums);
        return res;
    }
    public void back(int[] nums) {
        if (nums.length == tmp.size()) {
            res.add(new ArrayList<>(tmp));
            return ;
        }
        for (int i = 0;i < nums.length; i ++) {
            if (tmp.contains(nums[i])) {
                continue;
            }
            tmp.add(nums[i]); //选择
            back(nums);       //回溯
            tmp.remove(tmp.size()-1); //撤销选择
        }
    }
}