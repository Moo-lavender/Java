/*
链接：https://www.nowcoder.com/questionTerminal/bb4f1a23dbb84fd7b77be1fbe9eaaf32
来源：牛客网

nowcoder有两盒（A、B）乒乓球，有红双喜的、有亚力亚的……现在他需要判别A盒是否包含了B盒中所有的种类，并且每种球的数量不少于B盒中的数量，该怎么办呢？

输入描述:
输入有多组数据。
每组数据包含两个字符串A、B，代表A盒与B盒中的乒乓球，每个乒乓球用一个大写字母表示，即相同类型的乒乓球为相同的大写字母。
字符串长度不大于10000。


输出描述:
每一组输入对应一行输出：如果B盒中所有球的类型在A中都有，并且每种球的数量都不大于A，则输出“Yes”；否则输出“No”。
示例1
输入
ABCDFYE CDE
ABCDGEAS CDECDE
输出
Yes
No
*/

import java.util.Scanner;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String A = sc.next();
            String B = sc.next();
            LinkedList<Character> list = new LinkedList<>();
            for (char c : A.toCharArray()) {
                list.add(c);
            }
            int i;
            for (i = 0; i < B.length(); i++) {
                char ch = B.charAt(i);
                if (list.contains(ch)) {
                    list.remove(list.indexOf(ch));
                } else {
                    break;
                }
            }
            if (i == B.length()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}