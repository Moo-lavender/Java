import java.util.Scanner;

public class CharPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String value = sc.nextLine();
            char[] chars = value.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if ('A' <= c) {
                    c = (char) ('E' < c ? (c - 5) : (c + 21));
                    chars[i] = c;
                }
            }
            System.out.println(new String(chars));

        }
    }
}
