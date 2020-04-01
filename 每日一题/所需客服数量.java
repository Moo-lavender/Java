
/*
* 输入一个n表示要输入的通话记录个数，接下来输入n行，每行为逗号相隔的两个整数，两个数字分别代表呼入时间和挂断时间的时间戳。 举例：10,30，表示[10,30)，代表第10秒呼入，第30秒已经挂断，即第30秒可以接入新的来电； 每一行都是一条通话记录，通话记录已经按呼入时间由小到大排序；

输出
输出一个整数；

代表最少需要多少客服，可以满足所有旅客来电不用等待。


样例输入
6
0,30
0,50
10,20
15,30
20,50
20,65
样例输出
5
*/
import java.util.*;


public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int calcMinStaff() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0;i < n; i ++) {
            String s = in.nextLine();
            String[] str = s.split(",");
            int begin = Integer.valueOf(str[0]);
            int end = Integer.valueOf(str[1]);
            if (begin < 0 || end < 0) {
                return 0;
            }
            boolean flag = false;
            for (int j = 0; j < list.size(); j ++) {
                if (begin >= list.get(j)) {
                    list.set(j,end);
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                list.add(end);
            }
        }
        return list.size();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        int res;

        res = calcMinStaff();
        System.out.println(String.valueOf(res));

    }
}
