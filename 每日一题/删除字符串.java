/*
将给定的字符串，按照规则删除字符，输出删除后的字符串。
删除规则为：相同字符连续，则删除，如”aaaab”删除后的字符串为”b” 。
注：仅是单个字符连续才删除，如babababa则不能删除；
*/
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] ch = str.toCharArray();
            StringBuilder s = new StringBuilder();
            int index = 0;
            while (index < str.length()) {
                int j = index+1;
                char c = ch[index];
                while(j < str.length() && ch[j] == c) {
                    j++;
                }
                if (j == index +1){
                    s.append(c);
                }
                index = j;
            }
            if (s == null || s.length() == 0) {
                System.out.println("no");
            }else {
                 System.out.println(s.toString());
            }
        }
    }
}
