
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = 0;
        int[] used = new int[256];
        for (int i = 0; i < 256; i ++) {
            used[i] = -1;
        }
        int start = 0;
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (used[ch] >= start) {
                start = used[ch] + 1;
                used[ch] = i;
            }else {
                used[ch] = i;
                if (i - start + 1 > res) {
                    res = i - start + 1;
                }
            }
        }
        System.out.println(res);
    }
}