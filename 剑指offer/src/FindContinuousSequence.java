/*
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

思路： 穷举

*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 1; i < sum; i ++) {
            int add = i; //从i开始加
            int j = 1;//表示增量
            while (add < sum) { //比sum小就继续加数字
                add += (i+j);
                if(add  == sum) { //等于sum就往结果集中加
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int p = i; p <= i+j; p ++){
                        list.add(p);
                    }
                    result.add(list);
                } 
                j++;
            }
        }
        return result;
    }
}