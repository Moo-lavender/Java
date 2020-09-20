/*
近似周期串
时间限制： 3000MS
内存限制： 589824KB
题目描述：
小明发现有的字符串中蕴含着一些规律，但是它们又和普通的周期串有点不一样。例如：ABCABDABDABE。如果以3为周期，可以看到其中包含“ABC”、“ABD”和“ABE”等子串，其中“ABD”出现了两次。

这些子串两两之间最多只有某一位上的字符不相同，其他位置上的字符都一样。小明将其称为“近似串”，由多个“近似串”组成的字符串称为“近似周期串”。“近似周期串”中的每一个“近似串”的长度需大于等于2。

需要注意的是“ABCABBACD”并不是一个“近似周期串”。如果以3为周期，其子串包括“ABC”、“ABB”和“ACD”，“ABB”与“ACD”、“ABC”与“ACD”均存在两个位置上的字符不相同，因此不是“近似周期串”。特别的，“AAAAAA”也是一个“近似周期串”，因为它满足上述“近似周期串”的定义。

现在给你一个字符串，请编写一个程序判断该字符串是否是以3为周期的“近似周期串”。



输入描述
多组输入，第1行输入一个正整数T表示输入数据的组数。

对于每一组输入数据：输入一个长度不超过1000的字符串，字符串中只包含大写英文字母。

输出描述
针对每一组输入数据，输出该字符串是否是以3为周期的“近似周期串”，如果是输出“Yes”，否则输出“No”。


样例输入
2
ABCABDABDABEABEABF
ABCABDAEC
样例输出
Yes
No
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i ++) {
            String s = sc.nextLine();
            if (s.length() % 3 != 0) {
                System.out.println("No");
                continue;
            }
            if (s.length() == 3) {
                System.out.println("Yes");
                continue;
            }
            String tmp = s.substring(0,3);
            int index = 3;
            int different = -1;
            boolean flag = false;
            while (index < s.length()) {
                for (int j = 0; j < 3; j ++) {
                    if (tmp.charAt(j) != s.charAt(j+index)) {
                        if (different == -1) {
                            different = j;
                        }else if (different != j){
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag) {
                    System.out.println("No");
                    break;
                }
                index += 3;
            }
            if (!flag) {
                System.out.println("Yes");
            }
        }
    }
}