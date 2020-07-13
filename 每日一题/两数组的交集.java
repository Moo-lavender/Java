/*
给定两个数组，编写一个函数来计算它们的交集。

 

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        int i = 0;
        int[] res = new int[nums1.length]; 
        for (int num : nums2) {
            int value = map.getOrDefault(num, 0);
            if (value > 0) {
                res[i++] = num;
                map.replace(num, value - 1);
            }
        }
        
        return Arrays.copyOfRange(res, 0, i);
    }
}