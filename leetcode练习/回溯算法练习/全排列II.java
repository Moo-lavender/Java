/*

给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        back(nums);
        return res;
    }
    public void back(int[] nums) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return ;
        }

        for (int i = 0;i < nums.length; i ++) {
            if (i > 0 && nums[i] == nums[i-1] && used[i-1]) continue;
            if (!used[i]){
                used[i] = true;
                tmp.add(nums[i]);
                back(nums);
                used[i] = false;
                tmp.remove(tmp.size()-1);
            }   
        }
    }
}