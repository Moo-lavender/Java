/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，
使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
思路：
要求乘积最小则大数和小数的乘积 < 中间数的乘积
所以两个指针分别从头到尾遍历和从未到头
*/
import java.util.ArrayList;
public class FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            int add = array[i] + array[j] ;
            if( add > sum ){
                j --;
            } else if (add < sum){
                i ++;
            }else {
                result.add(array[i]);
                result.add(array[j]);
                break;
            }
        }
        return result;
    }
}