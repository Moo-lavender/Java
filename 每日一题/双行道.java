import java.util.Scanner;
/*
*
* 有一个2*n的网格，有一个人位于(1,1)的位置，即左上角，他希望从左上角走到右下角，即(2,n)的位置。在每一次，他可以进行三种操作中的一种：

1． 向右走一格，即从(x,y)到(x,y+1);

2． 向上右方走一格，即，如果他在(2,y)的位置可以走到(1,y+1);

3． 向下右方走一格，即，如果他在(1,y)的位置可以走到(2,y+1);



问题当然不会这么简单，在这2*n的格子中，有一部分格子上有障碍物，他不能停在障碍物上，当然也不能走出网格，请问他有多少种不同的路线可以到达(2,n)。

输入
输入第一行仅包含一个正整数n，表示网格的长度。(1<=n<=50)

接下来有2行,每行有n个字符，“X”代表障碍物，“.”代表可以停留。

输出
如果没有可以到达的路线则输出-1，否则输出方案数量。


样例输入
5
..X.X
XX...
样例输出
2*/

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            String first = sc.next();
            String second = sc.next();
            if(n == 0 || first == null || first.length() == 0 || second == null || second.length() ==0){
                System.out.println(0);
            }else{
                int[][] dp = new int[2][n];
                dp[0][0] = 1;
                dp[1][0] = 0;
                int i = 0;
                for(int j = 1; j < n; j++) {
                    if (first.charAt(j) == 'X') {
                        dp[0][j] = 0;
                    } else {
                        dp[0][j] = dp[0][j - 1] + dp[1][j - 1];
                    }

                    if (second.charAt(j) == 'X') {
                        dp[1][j] = 0;
                    } else {
                        dp[1][j] = dp[1][j - 1] + dp[0][j - 1];
                    }
                }
                System.out.println(dp[1][n-1]);
            }
        }
    }
}