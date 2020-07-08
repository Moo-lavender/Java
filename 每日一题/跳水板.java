/*

你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。

返回的长度需要从小到大排列。

示例：

输入：
shorter = 1
longer = 2
k = 3
输出： {3,4,5,6}
提示：

0 < shorter <= longer
0 <= k <= 100000
*/
class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0) return new int[0];
        if(shorter == longer) return new int[]{k*shorter};
        int[] nums = new int[k+1];
        nums[0] = k*shorter;
        int len = longer - shorter;
        for(int i = 1;i<=k;i++){
            nums[i] = nums[i-1] + len;
        }
        return nums;
    }
}