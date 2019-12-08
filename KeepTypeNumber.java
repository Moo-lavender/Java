import java.util.Scanner;
/*
* 守形数是这样一种整数，它的平方的低位部分等于它本身。
* 比如25的平方是625，低位部分是25，因此25是一个守形数。
* 编一个程序，判断N是否为守形数*/
public class KeepTypeNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int bit = 0;
            int x = n;
            while(x != 0){
                x /= 10;
                bit ++;
            }
            String sBegin = String.valueOf(n);
            int sqrtN = n * n;
            String sT = String.valueOf(sqrtN);
            int m = sT.length();
            String sEnd = sT.substring(m - bit, m);
            if(sBegin.equals(sEnd)){
                System.out.println("Yes!");
            }else{
                System.out.println("No!");
            }
        }
    }
}
