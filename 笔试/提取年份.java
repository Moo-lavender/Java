/*
提取年份
时间限制： 3000MS
内存限制： 589824KB
题目描述：
小明想从一段英文短文中提取潜在的年份信息，待匹配的年份的范围为1000年至3999年，包含1000和3999。

输入一段英文短文，按出现次序输出所提取到的所有可能的年份字符串。



输入描述
单组输入，输入一段英文短文，可能包含字母大小写，标点符号及空格。（不超过2000个字符）

输出描述
输出所提取到的所有可能的年份字符串，两两之间用一个空格隔开。


样例输入
And millionaires will hold 46% of total wealth by 2019, the report says. This ratio is likely to increase in 2020.
样例输出
2019 2020
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0;i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '1' && c <= '3') {
                int j;
                for (j = i+1; j < i+4 && j < str.length(); j++) {
                    char ch = str.charAt(j);
                    if (!Character.isDigit(ch)) {
                        break;
                    }
                }
                if (j == i+4) {
                    String s = str.substring(i,i+4);
                    res.add(s);
                 //   i += 3;
                }
            }
        }
        for (int i = 0; i < res.size(); i ++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
