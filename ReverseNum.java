import java.util.Scanner;

public class ReverseNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        String s = String.valueOf(n);
        char[] ch = s.toCharArray();
        int l = ch.length;
        char[] c = new char[l];
        for (int i = 0; i < l; i++) {
            c[i] = ch[l - 1 - i];
        }
        String result = new String(c);
        System.out.println(result);
    }
}
