/*
40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        back(candidates,0,target);
        return res;
    }

    public void back(int[] candidates,int index,int target) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i ++) {
            //i > index 保证了不会越界，不能写成i>0虽然也不会越界，但第一个重复的数字就不会被添加到选择中
            if (i > index && candidates[i] == candidates[i-1]) continue;
            tmp.add(candidates[i]);  //选择
            back(candidates,i+1,target-candidates[i]); //回溯
            tmp.remove(tmp.size()-1);  //撤销选择
        }
    }
}