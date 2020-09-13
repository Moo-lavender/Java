import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 1;
        while (sc.hasNextInt()) {
            int tmp = sc.nextInt();
            if (num == tmp) {
                count ++;
            }else {
                if (count == 1) {
                    num = tmp;
                }else {
                    count --;
                }
            }
        }
        System.out.println(num);
    }
}