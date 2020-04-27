/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    boolean[] used;
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> tmp = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        Arrays.sort(nums);
        back(0,nums);
        return res;
    }
    private void back(int index,int[] nums) {
        res.add(new LinkedList<>(tmp));
        
        for (int i = index; i < nums.length; i ++) {
            if (i > index && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            if (used[i]) continue;
            used[i] = true;
            tmp.add(nums[i]);
            back(i+1,nums);
            tmp.remove(tmp.size()-1);
            used[i] = false;
        }

    }
}