import java.util.ArrayList;
import java.util.Scanner;

public class MinK {
    //找n个数中，最小的K个数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(scanner.hasNextInt()){
            list.add(scanner.nextInt());
        }
        int k = list.remove(list.size() - 1);
        list.sort(Integer::compareTo);
        for(int i = 0; i < k ; i++){
            System.out.printf("%d ",list.get(i));
        }


    }
}
