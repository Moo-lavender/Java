import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//统计一个1000位以内的数字每个数位出现的次数
public class NumBitCount {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] c = s.toCharArray();
        Map<Character,Integer> map = new HashMap();
        for(char ch: c){
            int t = map.getOrDefault(ch,0);
            map.put(ch,t + 1);
        }
        System.out.println(map);
        for(Map.Entry<Character,Integer> entry: map.entrySet() ){
            //因为HashMap的key是使用数组实现的，因此，会保证key是有序的
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
