/*
在vivo产线上，每位职工随着对手机加工流程认识的熟悉和经验的增加，日产量也会不断攀升。
假设第一天量产1台，接下来2天(即第二、三天)每天量产2件，接下来3天(即第四、五、六天)每天量产3件 ... ... 
以此类推，请编程计算出第n天总共可以量产的手机数量。
输入例子1:
11

输出例子1:
35

例子说明1:
第11天工人总共可以量产的手机数量
https://www.nowcoder.com/questionTerminal/2e4363c23c6741f98319d5a7e3882325
*/
import java.util.*;


public class Solution {
    /**
     * 
     * @param n int整型 第n天
     * @return int整型
     */
    public int solution (int n) {
        int ans = 0;
        int count = 1,day = 0; //count表示某一个时间段产量，day表示相应产的时间
        for (int i = 1; i <= n; i ++) {
            day ++;
            ans += count;
            if (count == day) {
                count ++;
                day = 0;
            }
        }
        return ans;
    }
}