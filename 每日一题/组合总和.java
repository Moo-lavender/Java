/*

39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        backtrack(candidates,target,0,0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int index,int total) {
        if (total == target) {
            res.add(new ArrayList(tmp));
            return;
        }

        for (int i = index; i < candidates.length; i ++) {
            total += candidates[i];
            if (total > target) {
                break;
            }
            tmp.add(candidates[i]);
            backtrack(candidates,target,i,total);
            total -= candidates[i];
            tmp.remove(tmp.size()-1);
        }
    }
}