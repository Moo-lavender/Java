import java.util.Scanner;

/*
*给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。
* 目标是使得最后得到的数尽可能小（注意0不能做首位）。
* 例如：给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
*/
public class buildMinNum {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int[] num = new int[10];
        for(int i = 0; i < 10; i ++){
            num[i] = sc.nextInt();
        }
        for(int i=1;i<10;i++){
            if(num[i]!=0){
                System.out.print(i);
                num[i]--;
                break;
            }
        }
        while(num[0]!=0){
            System.out.print(0);
            num[0]--;
        }
        for(int i=1;i<10;i++){
            while(num[i]!=0){
                System.out.print(i);
                num[i]--;
            }
        }
    }
}
