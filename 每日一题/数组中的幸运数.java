/*
在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。

给你一个整数数组 arr，请你从中找出并返回一个幸运数。

如果数组中存在多个幸运数，只需返回 最大 的那个。
如果数组中不含幸运数，则返回 -1 。
1 <= arr.length <= 500
1 <= arr[i] <= 500

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-lucky-integer-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int findLucky(int[] arr) {
        int[] count = new int[501];
        for (int i = 0; i < arr.length; i ++) {
            count[arr[i]] ++;
        }
        int ans = 0;
        for (int i = 0; i < 501; i ++) {
            if (count[i] == i) {
                ans = i;
            }
        }
        if (ans == 0) return -1;
        return ans;
    }
}