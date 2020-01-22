/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 
整数，并返回他们的数组下标。
*/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
               ans[0] = i;
               ans[1] = map.get(nums[i]);
               return ans;
            }
            map.put(target - nums[i], i);
        }
        return ans;
    }
}