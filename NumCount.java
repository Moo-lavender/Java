import java.util.*;
//OJ练习，找出一组数中，出现次数大于数组一半的数字
public class NumCount {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(scanner.hasNextInt()){
            list.add(scanner.nextInt());
        }
        int length = list.size()/2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : list){
           int c = map.getOrDefault(n,0);
           map.put(n,c+1);
        }
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            if(e.getValue() >= length){
                System.out.println(e.getKey());
            }
        }
    }
}
