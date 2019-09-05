import java.util.HashSet;
import java.util.Set;
//从石头中找到宝石的数量
public class newJeweIsInStones {
    public static int numJeweIsInStones(String j,String s){
        Set<Character> jewels = new HashSet<>();
        int count = 0;
        for(char ch :j.toCharArray()){
            jewels.add(ch);
        }
        for(char ch : s.toCharArray()){
            if(jewels.contains(ch)){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String j = "Aas";
        String s = "ahAs";
        int count = numJeweIsInStones(j,s);
        System.out.println(count);
    }
}
