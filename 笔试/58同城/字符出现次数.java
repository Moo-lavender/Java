/*求字符串中每一个字符出现的次数*/
import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            int n = map.getOrDefault(c,0);
            map.put(c,n+1);
        }
        for (char c : map.keySet()) {
         System.out.print(c + "=" + map.get(c) + " ");
        }
    }
}