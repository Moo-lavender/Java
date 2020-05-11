/*
定一个数组，每个元素范围是0~K（K < 整数最大值2^32），将该数组分成两部分，使得 |S1- S2|最小，其中S1和S2分别是数组两部分的元素之和。



输入描述:
数组元素个数N（N 大于1但不超过 10, 000, 000）

数组中N个元素（用空格分割）

输出描述:
|S1- S2|的值

输入例子1:
5
2 4 5 6 9

输出例子1:
0

输入例子2:
4
1 1 1 999

输出例子2:
996
*/


import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i ++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int res = partition(nums);
        System.out.println(res);
    }

    private static int partition(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int min = nums[n-2];
        int max = nums[n-1];
        for (int i = n-3; i >= 0; i --) {
            min += nums[i];
            if (min > max) {
                int t = max;
                max = min;
                min = t;
            }
        }
        return max-min;
    }
}