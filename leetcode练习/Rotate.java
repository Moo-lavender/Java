//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
class Rotate{
	//时间O（n）空间O（n）
    public void rotate1(int[] nums, int k) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[(i+k) % nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = result[i];
        }
    }
	//使用反转 时间O（n）空间O（1）
	public void rotate2(int[] nums, int k){
		k %= nums.length;
		reverse(nums,0,nums.length - 1);
		reverse(nums,0,k - 1);
		reverse(nums,k,nums.length - 1);
	}
	public void reverse(int[] nums,int begin,int end){
		while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
	}
}