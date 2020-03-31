/*给定一个整数数组 nums，将该数组升序排列。

 

示例 1：

输入：[5,2,3,1]
输出：[1,2,3,5]
示例 2：

输入：[5,1,1,2,0,0]
输出：[0,0,1,1,2,5]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        return nums;
    }
    public void swap(int[] arr, int i,int j) {
	        int tmp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = tmp;
	}
    private void quickSort(int[] nums,int begin,int end) {
        if (begin >= end) return;
        int pivotIndex = partition(nums,begin,end);
        quickSort(nums,begin,pivotIndex - 1);
        quickSort(nums,pivotIndex + 1,end);
    }
    private int partition(int[] nums,int begin,int end) {
        int pivot = nums[end];
        int i = begin;
        int j = end;
        while(i < j) {
            while (i < j && nums[i] <= pivot) {
                i ++;
            }
            while (i < j && nums[j] >= pivot) {
                j --;
            }
            swap(nums,i,j);
        }
        swap(nums,i,end);
        return i;

    }
}