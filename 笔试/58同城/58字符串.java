/*找出[5,8]之间的最长字串*/

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] ch = s.toCharArray();
        int max = 0;
        int start = 0,end = 0;
        for (int i = 0; i < ch.length; i ++) {
            char c = ch[i];
            int j = i;
            while (j < ch.length && ch[j] >= '5' && ch[j] <= '8') {
                j++;
            }
            if (max < (j-i)) {
                max = j-i;
                end = j;
                start = i;
            }
        }
        String res = s.substring(start,end);
        System.out.println(res);
    }
}