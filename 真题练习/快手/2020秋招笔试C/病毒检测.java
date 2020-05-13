/*
链接：https://www.nowcoder.com/questionTerminal/6f0d16fc06274f44af8913d182668037?f=discussion
来源：牛客网

小明最近在做病毒自动检测，他发现，在某些library 的代码段的二进制表示中，如果包含子串并且恰好有k个1，就有可能有潜在的病毒。library的二进制表示可能很大，并且子串可能很多，人工分析不可能，于是他想写个程序来先算算到底有多少个子串满足条件。如果子串内容相同，但是开始或者结束位置不一样，则被认为是不同的子串。
注：子串一定是连续的。例如"010"有6个子串，分别是 "0, "1", "0", "01", "10", "010"


输入描述:
第一行是一个整数k，表示子串中有k个1就有可能是病毒。其中 0 <= k <= 1 000 000

第二行是一个字符串，就是library的代码部分的二进制表示。字符串长度 <= 1 000 000。并且字符串中只包含"0"或"1".


输出描述:
输出一个整数，所有满足只包含k个1的子串的个数。
示例1
输入
1
1010
输出
6
说明
满足条件的子串有："1", "1", "10", "01", "10", "010".
示例2
输入
2
01010
输出
4
说明
满足条件的子串有： "101", "0101", "1010", "01010".
示例3
输入
100
01010
输出
0

*/



import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int len = s.length();
        char[] ch = s.toCharArray();
        if (len <= 0) {
            System.out.println(0);
            return;
        }
        int count = 0;

        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i ++) {
            for (int j = i; j < len; j ++) {
                if (i == j) {
                    if (ch[i] == '1') {
                        dp[i][j] = 1;
                    }
                }else if (ch[j] == '1') {
                    dp[i][j] = dp[i][j-1] + 1;
                }else {
                    dp[i][j] = dp[i][j-1];
                }
                if (dp[i][j] == k) {
                    count ++;
                }
            }
        }
        System.out.println(count);
    }
}