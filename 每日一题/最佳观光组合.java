/*
给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。

一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。

返回一对观光景点能取得的最高分。

 

示例：

输入：[8,1,5,2,6]
输出：11
解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 

提示：

2 <= A.length <= 50000
1 <= A[i] <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-sightseeing-pair
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
	/*
		A[i] + A[j] + i - j 可以分为 A[i] + i 和A[j] - j 两部分
		遍历一遍数组，每一次将选出A[i]+i的最大和res的最大
		先替换res的值
		如果当前的A[i]+i比left大就要替换
	*/
    public int maxScoreSightseeingPair(int[] A) {
        if (A == null) {
            return -1;
        }
        int left = A[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < A.length; i ++) {
            res = Math.max(res,left + A[i]-i);
            left = Math.max(left,A[i]+i);
        }
        return res;
    }
}