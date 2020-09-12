/*
求一个字符串中大于1的回文字串的数量
*/

//网易第二题——最多的回文
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str == null || str.length() <= 1) {
            System.out.println(0);
            return;
        }
        int res = 0;
        char[] ch = str.toCharArray();
        int n = ch.length;
        for (int i = 0; i < n; i ++) {
            for (int j = n-1; j >= 0 && j > i; j--) {
                if (ishuiwen(ch,i,j)) {
                    res ++;
                }
            }
        }
        System.out.println(res);
    }

    private static boolean ishuiwen(char[] ch, int i, int j) {
        if (i > j) return false;
        if (i == j) return false;
        while (i <= j) {
            if (ch[i++] != ch[j--]) {
                return false;
            }
        }
        return true;
    }
}