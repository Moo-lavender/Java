/*
如何得到一个数据流中的中位数？
如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
*/
import java.util.ArrayList;
public class Solution {
    private ArrayList<Integer> arr = new ArrayList<>();
    public void Insert(Integer num) {
        int i;
        for ( i = 0; i < arr.size(); i ++) {
            if(num <= arr.get(i)) {
                arr.add(i,num);
                break;
            }
        }
        if (i == arr.size()){
            arr.add(num);
        }
    }

    public Double GetMedian() {
        int index = arr.size()/2;
        if(arr.size() % 2 == 0) {
            return (double)(arr.get(index) + arr.get(index - 1)) / 2;
        }else{
            return (double)arr.get(index);
        }
    }
}