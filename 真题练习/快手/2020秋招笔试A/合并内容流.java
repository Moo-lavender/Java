/*
合并两个内容流，实现隔4个插入1个，如果合并完还有剩下，则加内容流尾部

输入描述:
第行表示第一种类型的内容，字符数量<=100，空格分隔。比如说

1 2 3 4 5 6 7 8 9

a b c

输出描述:
合并两种内容流，输出

1 2 3 4 a 5 6 7 8 b 9 c

输入例子1:
1 2 3 4 5 6 7 8 9
a b c

输出例子1:
1 2 3 4 a 5 6 7 8 b 9 c

https://www.nowcoder.com/questionTerminal/0f3bdc60198244d9a8893b843afd2310?answerType=1&f=discussion
*/
import java.util.*;
public class Main{
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String str1  = sc.nextLine();
        String str2  = sc.nextLine();
        List<String> list = doInsert(str1.trim().split(" "),str2.trim().split(" "));
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
    private static List<String> doInsert(String[] s1,String[] s2) {
        List<String> ans = new LinkedList<>();
        int index1 = 0,index2 = 0;
        while (index1 < s1.length && index2 < s2.length) {
            for (int i = 0; i < 4 && index1 < s1.length; i ++) {
                ans.add(s1[index1++]);
            }
            ans.add(s2[index2++]);
        }
        for (int i = index1; i < s1.length; i ++) {
            ans.add(s1[index1++]);
        } 
        for (int i = index2; i < s2.length; i ++) {
            ans.add(s2[index2++]);
        }
        return ans;
    }
}