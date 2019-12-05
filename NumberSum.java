import java.util.Scanner;
/*
* 对于给定的正整数n，计算十进制形式下所有的位置的数字之和，
* 并计算其平方的各位数字之和
* 例如：
* 输入：
* 4 12
* 输出：
* 4 7
* 3 9
* */
public class NumberSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int num = sc.nextInt();
            int sqrtzNum = num * num;
            int sumNum = 0;
            int sumSqrt = 0;
            while(num != 0){
                int t = num % 10;
                sumNum += t;
                num /= 10;
            }
            while(sqrtNum != 0){
                int t = sqrtNum % 10;
                sumSqrt += t;
                sqrtNum /= 10;
            }
            System.out.printf("%d %d",sumNum,sumSqrt);
        }
    }
}
