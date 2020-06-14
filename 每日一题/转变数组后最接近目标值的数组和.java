/*
给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。

如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。

请注意，答案不一定是 arr 中的数字。

 

示例 1：

输入：arr = [4,9,3], target = 10
输出：3
解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
示例 2：

输入：arr = [2,3,5], target = 10
输出：5
示例 3：

输入：arr = [60864,25176,27249,21296,20204], target = 56803
输出：11361

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
	public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int curSum = 0;
        for (int i = 0; i < len; i++) {
            int curAve = (target - curSum) / (len - i);
            if (curAve <= arr[i]) {
                //即判断curAve两边
                double curAveDou = (target * 1.0 - curSum) / (len - i);
                if (curAveDou - curAve <= 0.5) {
                    return curAve;
                } else {
                    return curAve + 1;
                }
            }
            curSum += arr[i];
        }
        return arr[len - 1];
    }
}