/*
给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

 

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int pindex = 0,qindex = 0;
        if (nums1 == null || nums1.length == 0) {
            pindex = -1;
        }
        if (nums2 == null || nums2.length == 0) {
            qindex = -1;
        }
        int x = 0,y = 0;
        for (int i = 0; i < n/2+1; i ++) {
            x = y;
            if (pindex != -1 && qindex != -1){
                if (nums1[pindex] <= nums2[qindex]) {
                    y = nums1[pindex ++];
                }else{
                    y = nums2[qindex ++];
                }
            }else if (pindex == -1 && qindex == -1){
                break;
            }else if (pindex == -1) {
                y = nums2[qindex ++];
            }else {
                y = nums1[pindex ++];
            }
            
            if (pindex >= nums1.length) {
                pindex = -1;
            }
            if (qindex >= nums2.length) {
                qindex = -1;
            }
        }
        if ((n & 1) == 0) {
            return (double)(x+y)/2;
        }else{
            return y;
        }
    }
	
	
}