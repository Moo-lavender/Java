/*
剑指 Offer 57 - II. 和为s的连续正数序列
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

 

示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 
*/class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for (int left = 1,right = 1,sum = 0; right < target; right ++) {
            sum += right;
            while (sum > target) {
                sum -= left;
                left ++;
            }
            if (sum == target) {
                int[] tmp = new int[right-left+1];
                for (int i = 0; i < tmp.length; i ++) {
                    tmp[i] = i+left;
                }
                list.add(tmp);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i ++) {
            res[i] = list.get(i);
        }
        return res;
    }
}