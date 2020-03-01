/*
给定依据与要求将输入的单词反向
如输入：
Hello World Here I Come
输出：
Come I Here World Hello
*/
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.length() == 0 || s == null) {
            System.out.println("");
        }
        char[] ch = s.toCharArray();
        char[] result = new char[ch.length];
        int start = ch.length - 1;
        int p = 0;
        int end = start;
        while(start >= 0) {
            if(ch[start] == ' ' ) {
                for(int i = start + 1; i <= end; i ++) {
                    result[p++] = ch[i];
                }
                end = --start; 
                result[p++] = ' ';
            }else{
                start --;
            }
        }
        for(int i = 0; i <= end; i ++) {
            result[p++] = ch[i];
        }
        System.out.println(new String(result));
    }
}