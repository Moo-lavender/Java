/*给定一个整数数组，判断是否存在重复元素。
如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
利用set去重复的特性
*/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < length; i++){
            set.add(nums[i]);
        }
        boolean result = length > set.size()? true : false;
        return result;
    }
}