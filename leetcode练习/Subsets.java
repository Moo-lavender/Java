import java.util.LinkedList;
import java.util.List;
/*
* 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
* 遍历每一个元素，给结果集中的每一个子集都加上该元素
* */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new  LinkedList<>();
        ans.add(new LinkedList<>());
        for(int i = 0; i < nums.length;i ++){
            //size要首先保存，不能放在循环中间中计算，否则会死循环
            int size = ans.size();
            for(int j = 0; j < size; j ++){
                List<Integer> tmp = new LinkedList<>(ans.get(j));
                tmp.add(nums[i]);
                ans.add(tmp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
