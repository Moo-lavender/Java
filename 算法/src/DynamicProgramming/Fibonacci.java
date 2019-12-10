package DynamicProgramming;
import java.util.Scanner;

/*
动态规划题目一：
* 求斐波那契数列
* 状态：F(i):数列的第i项值
* 转移方程：F(i) = F(i-1) + F(i-2)
* 初识化：F(1) = F(2) = 1
* 返回值：F(n)
* */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        arr[0] = 0;
        if(n == 1){
            arr[1] = 1;
        }
        if(n > 1){
            arr[1] = 1;
            arr[2] = 1;
        }
        for(int i = 3; i < n+1; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[n]);
    }
}
