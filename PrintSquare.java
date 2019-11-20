import java.util.Scanner;
/*
* 输出由给定字符C画出的正方形。
* 但是注意到行间距比列间距大，所以为了让结果看上去更像正方形，
* 我们输出的行数实际上是列数的50%*/
public class PrintSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String c = scanner.next();
        int col = n / 2 - 2;
        if(n % 2 != 0){
            col++;
        }
        for(int i = 0; i < n; i ++){
            if(i != n - 1){
                System.out.print(c);
            }else{
                System.out.println(c);
            }
        }
        for(int i = 0; i < col; i ++){
            for(int j = 0; j < n; j++){
                if(j == 0 ){
                    System.out.print(c);
                }else if(j == n - 1){
                    System.out.println(c);
                }else{
                    System.out.print(" ");
                }
            }
        }
        for(int i = 0; i < n; i ++){
            if(i != n - 1){
                System.out.print(c);
            }else{
                System.out.println(c);
            }
        }
    }
}
