import java.util.ArrayList;
import  java.util.List;
public class PascalsTriangle {
    public List <List<Integer>> generate(int numRos){
        List<List<Integer>>list = new ArrayList<>(numRos);
        //list 是一种引用，List 类型的接口引用
        //list 逻辑上是一种线性表
        //线性表元素类型是 List<Integer>
        //                     List 类型的接口引用
        //                     元素类型是Integer 类 类型的引用
        //                     Integer 是 int类型的包装类
        for(int i = 0; i < numRos; i++){
            list.add(new ArrayList<>());
        }
        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);
        for(int i = 2 ; i < numRos; i++){
            List<Integer> nums = list.get(i);  //定义一个引用指向要处理的行
            nums.add(1);                        //插入每一行的第一个1
            for (int j = 1; j < i;j++){          //设置除了第一个1的位置开始，到除了最后一个1的位置
                int num = list.get(i-1).get(j-1)     //设置每一个数
                        + list.get(i-1).get(j);
                nums.add(num);
            }
            nums.add(1);                         //尾插入每一行的最后一个1
        }
        return list;
    }
}
//杨辉三角
//定义一个线性表表示行
//每一个元素都是另一个线性表
