/*
链接：https://www.nowcoder.com/questionTerminal/9dd19c9305704138bdf83e2dffdcb4f4?f=discussion
来源：牛客网

给定一组石头，每个石头有一个正数的重量。每一轮开始的时候，选择两个石头一起碰撞，假定两个石头的重量为x，y，x<=y,碰撞结果为
1. 如果x==y，碰撞结果为两个石头消失
2. 如果x != y，碰撞结果两个石头消失，生成一个新的石头，新石头重量为y-x

最终最多剩下一个石头为结束。求解最小的剩余石头质量的可能性是多少。

输入描述:
第一行输入石头个数(<=100)

第二行输入石头质量，以空格分割，石头质量总和<=10000


输出描述:
最终的石头质量
示例1
输入
6
2 7 4 1 8 1
输出
1
*/

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),sum=0,result=0;
        int[] nums=new int[n+1];
        for(int i=1;i<=n;i++) {
            nums[i]=scanner.nextInt();
            sum+=nums[i];
        }
        boolean[] dp=new boolean[sum/2+1];
        dp[0]=true;
        for(int i=1;i<=n;i++)
            for(int j=sum/2;j>=nums[i];j--)
                dp[j]|=dp[j-nums[i]];

        for(int j=sum/2;j>=0;j--)
            if(dp[j]) {
                result=Math.abs(j-(sum-j));
                break;
            }
        System.out.println(result);
    }
}