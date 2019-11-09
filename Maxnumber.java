

import java.util.ArrayList;
import java.util.Scanner;

public class Maxnumber {
    public String  maxNumber (String s) {
        char[] c = s.toCharArray();
        ArrayList<Character> maxArrayList = new ArrayList<>();
        ArrayList<Character> currentArrayList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if ((c[i] <= 'z' && c[i] >= 'a')||(c[i] <= 'Z' && c[i] >= 'A')) {
                if (currentArrayList.size() > maxArrayList.size()) {
                    maxArrayList.clear();
                    maxArrayList.addAll(currentArrayList);
                }
                currentArrayList.clear();
                continue;
            }
            if (c[i] >= '0' && c[i] <= '9') {
                currentArrayList.add(c[i]);
            }
        }
        if (currentArrayList.size() > maxArrayList.size()) {
            maxArrayList.clear();
            maxArrayList.addAll(currentArrayList);
        }
        char[] r = new char[maxArrayList.size()];
        for(int i = 0; i < maxArrayList.size();i++){
            r[i] = maxArrayList.get(i);
        }
        String result = new String(r);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s=new Maxnumber().maxNumber(s);
        System.out.println(s);
    }
}
