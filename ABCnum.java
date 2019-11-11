import java.util.Scanner;
//OJ练习   有ABC三个整数，现在输入 A-B B-C A+B B+C 的值，求ABC，不存在输入No
public class ABCnum {
    public static void main(String[] args){
        long A,B,C;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long c = scanner.nextLong();
            long d = scanner.nextLong();
            A = (a + c)/2;
            B = A - a;
            C = (d - b)/2;
            if((A - B != a) || (B - C != b) || (A + B != c) || (B + C != d)){
                System.out.println("No");
            }else{
                if((int)A != A || (int)B != B || (int)C != C){
                    System.out.println("No");
                }else{
                    System.out.printf("%d %d %d",A, B, C);
                }
            }
        }
    }


}
