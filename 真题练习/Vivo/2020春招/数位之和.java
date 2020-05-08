/*

*/

import java.util.*;

//法一（回溯）
public class Solution {    /**
     * 输入一个整形数值，返回一个整形值
     * @param n int整型 n>9
     * @return int整型
     */
    ArrayList<String> res = new ArrayList<>();
    StringBuilder tmp = new StringBuilder();
    public int solution (int n) {
        if (n == 1) return 1;
        back (1,n);
        if (res.isEmpty()) return -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.size(); i ++) {
            int t = Integer.valueOf(res.get(i));
            min = Math.min(min,t);
        }
        return min;
    }
    private void back(int index,int target) {
        if (target > 0 && target < 10) {
            tmp.append(target);
            res.add(new String(tmp.toString()));
            tmp.deleteCharAt(tmp.length()-1);
            return;
        }
        for (int i = 2;i < 10; i ++) {
            if (target % i != 0 || tmp.length() > 7) {
                continue;
            }
            tmp.append(i);
            back(i,target/i);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }
}
//法二

import java.util.*;


public class Solution {
    /**
     * 输入一个整形数值，返回一个整形值
     * @param n int整型 n>9
     * @return int整型
     */
    public int solution (int n) {
        if (n == 1) return 1;
        int[] arr = new int[10];
        for (int i = 9; i > 1; i --) {
            while(n%i == 0) {
                n = n / i;
                arr[i] ++;
            }
        }
        if (n != 1) return -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < 10; i ++) {
            if (arr[i] != 0) {
                for (int j = 0; j < arr[i]; j ++) {
                    sb.append(i);
                }
            }
        }
        return Integer.valueOf(sb.toString());
    }
}