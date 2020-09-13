import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        if (list.get(0) > 0) {
            System.out.println();
            return;
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < list.size() - 2 ; i ++) {
            if (i > 0 && list.get(i).equals(list.get(i-1))) continue;
            int j = i+1, k = list.size() - 1;
            while (j < k) {
                if (list.get(i) + list.get(j) + list.get(k) ==0) {
                    ArrayList<Integer> list1 = new ArrayList<>();
                    list1.add(list.get(i));
                    list1.add(list.get(j));
                    list1.add(list.get(k));
                    res.add(list1);
                    j ++;
                    k--;
                    while(j < k && list.get(j).equals(list.get(j-1))) {
                        j++;
                    }
                    while(j < k && list.get(k).equals(list.get(k+1))) {
                        k --;
                    }
                }else if (list.get(i) + list.get(j) + list.get(k) > 0) {
                    k--;
                }else{
                    j++;
                }
            }
        }
        for (int i = 0; i < res.size(); i ++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j ++) {
                sb.append(res.get(i).get(j));
                sb.append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}