import java.util.Scanner;
    public class CanExchange2 {
        public static int canExchange(int n){
            int count = 0;
            for (; n >= 3; ) {
                count = count + (n / 3);
                n = n / 3 + n % 3;
            }
            if (n == 2) {
                count++;
            }
            return count;
        }
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            while(sc.hasNext()){
                int a = sc.nextInt();
                System.out.println(canExchange(a));
            }
        }
    }
