/*
链接：https://www.nowcoder.com/questionTerminal/65429b39865a4d4a8fd11ea1c7bcb7ce
来源：牛客网

现在你的班级刚刚参加了一个只有单选题的考试。班级一共n个学生，考试有m个问题。每个题目都有5个可选答案（A，B，C，D，E）。并且每个题目只有一个正确答案。每个题目的分数并不一样，第i个题目的分数用a[i]表示。如果题目没答对该题会获得0分。
考试结束后，每个学生都记得自己的答案，但是他们还不知道正确答案是什么。如果非常乐观的考虑，他们班级最多可能得到多少分呢？

输入描述:
第一行包含2个正整数，n和m。(1 <= n, m <= 1000，n是班级中学生数量，m是题目的数量)

下面n行数据每行包含一个string si，表示第i个学生的答案。si的第j个字符表示该学生第j个题目的答案。


输出描述:
一个正整数，全班学生最大的可能获得的分数总和。
示例1
输入
2 4
ABCD
ABCE
1 2 3 4
输出
16
说明
最优的答案是ABCD，这样2个学生的总分是16。
示例2
输入
3 3
ABC
BCD
CDE
5 4 12
输出
21
说明
最优的答案是CCC，3个学生的总分是5+4+12=21
*/

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[m][5];
        for (int i = 0; i < n; i ++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j ++) {
                char ans = str.charAt(j);
                if (ans == 'A') arr[j][0] ++;
                if (ans == 'B') arr[j][1] ++;
                if (ans == 'C') arr[j][2] ++;
                if (ans == 'D') arr[j][3] ++;
                if (ans == 'E') arr[j][4] ++;
            }
        }
        int max = 0;
        for (int i = 0; i < m; i ++) {
            int  t = findMax(arr,i);
            int score = sc.nextInt();
            max += (score * t);
        }
        System.out.println(max);
    }
    private static int findMax(int[][] arr,int index){
        int max = 0;
        for (int i = 0; i < arr[0].length; i ++) {
            max = Math.max(max,arr[index][i]);
        }
        return max;
    }
}