/*
输入一行字符串，计算其中A-Z大写字母中出现的次数
*/
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] count = new int[26];
        for(char ch : s.toCharArray()){
            if(ch >= 'A' && ch <= 'Z'){
                int index = (int)(ch - 'A');
                count[index] ++;
            }else{
                continue;
            }
        }
        for(int i = 0; i < 26; i ++){
            char word = (char)(i + 'A');
            System.out.println(word + ":" + count[i]);
        }
    }
}

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        LinkedHashMap<Character,Integer> list = new LinkedHashMap<>();
        for(int i = 0; i < 26; i++){
            list.put(((char)(i+'A')),0);
        }
        for(int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                int val = list.get(ch);
                list.put(ch,val + 1);
            }else{
                continue;
            }
        }
        for(int i = 0; i < list.size(); i ++){
            char ch = (char)(i + 'A');
            System.out.println(ch +":"+ list.get(ch));
        }
    }
}