import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt()*100;
        int day = 0;
        int down = 0;
        int jian = 2;
        int t = 0;
        while (t < m){
            t += n;
            day ++;
            if (t >= m) {
                break;
            }
            down += n/jian;
            t -= down;
            jian *= 2;

        }
        System.out.println(day);
    }
}
