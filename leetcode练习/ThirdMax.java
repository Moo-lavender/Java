/*
给定一个非空数组，返回此数组中第三大的数。
如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
*/
public class ThirdMax {
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer x : nums) {
            if (x.equals(max1) || x.equals(max2) || x.equals(max3)) {
                continue;
            }
            if ((max1 == null) || x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            }
            else if ((max2 == null) || x > max2) {
                max3 = max2;
                max2 = x;
            }
            else if ((max3 == null) || x > max3) {
                max3 = x;
            }
        }
        if (max3 == null) {
            return max1;
        }else {
            return max3;
        }
    }
}