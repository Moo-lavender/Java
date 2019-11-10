import java.util.Scanner;

public class BuyApple {
    public int buyApple(int x){
        for(int i = 0;i <= 17; i++){
            for(int j = 0; j <= 13; j++){
                if((6 * i + 8 * j) == x){
                    return i + j;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(new BuyApple().buyApple(x));
    }
}
