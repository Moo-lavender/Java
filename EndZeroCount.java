/**
 *输入一个正整数n,求n!(即阶乘)末尾有多少个0？
 * 如果使用暴力解法，直接求出阶乘会导致输入数字有限制，long所能表示的数字长度不够使用
 * 【解答】尾部所有的0都是由因子5*2得到的，
 * 由于2.6.8 都可以视为因子2，所以因子2的个数远大于因子5的个数
 * 所以只需要求出因子5的个数即可。
 * 由于25,125这个数不止含有一个因子5，所以需要求完后递归调用n/5
 * 以上。
 */

import java.util.Scanner;

public class EndZeroCount {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for(int i = n; i >= 5; i--){
            int tmp = i;
            while(tmp % 5 == 0) {
                count++;
                tmp /= 5;
            }
        }
        System.out.println(count);
    }
}
